package com.avapir.soccingover.core;

import com.avapir.soccingover.R;

import java.text.DateFormat;
import java.util.*;

/** User: Alpen Ditrix Date: 23.11.13 Time: 19:58 */
public class UserAccount {

    public enum UserAccountState {
        /** Log in successful, update is on */
        CONNECTED,
        /** Will not try to relog. Update is off. */
        DISABLED,
        /** Need relog. Update is unavailable. */
        WRONG_DATA,
        /**
         * Didn't got server answer on logging in (e.g. network unavailable).
         * <p/>
         * Will try to relog. Update is  unavailable.
         */
        UNKNOWN;

        public String toString() {
            switch (this) {
                case CONNECTED:
                    return "State: Connected";
                case DISABLED:
                    return "State: Disabled";
                case WRONG_DATA:
                    return "State: Wrong login or password";
                case UNKNOWN:
                    return "State: Unknown";
                default:
                    return "[WARNING]: UNKNOWN STATE";
            }
        }
    }

    public static final String[] MAP_KEYS = {"service", "login", "status", "date"};
    public static final int[]    VIEW_IDs = {R.id.item_user_service_icon, R.id.item_user_login,
            R.id.item_user_password_status, R.id.item_user_date};
    private final NegotiableServices service;
    private final CharSequence       login;
    private final long               creationDate;
    private       UserAccountState   state;
    private       String             authKey;

    /**
     * Creates {@link UserAccountState#DISABLED} account
     *
     * @param login
     * @param service
     */
    public UserAccount(CharSequence login, NegotiableServices service) {
        this.login = login;
        this.service = service;

        state = UserAccountState.DISABLED;
        creationDate = System.currentTimeMillis();
    }

    /**
     * Creates {@link UserAccountState#CONNECTED} account
     *
     * @param login
     * @param service
     * @param authKey
     */
    public UserAccount(CharSequence login, NegotiableServices service, String authKey) {
        this.login = login;
        this.service = service;
        this.authKey = authKey;

        state = UserAccountState.CONNECTED;
        creationDate = System.currentTimeMillis();
    }

    /**
     * Converts list of {@link UserAccount}s to list of {@link Map}s which will be used in {@link
     * android.widget.SimpleAdapter}
     *
     * @param list list of account
     *
     * @return list of view models
     */
    public static List<Map<String, Object>> toViews(List<UserAccount> list) {
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
        for (UserAccount account : list) {
            retList.add(account.toMap());
        }
        return retList;
    }

    /**
     * Converts {@link UserAccount} to {@link Map} which will be used in {@link android.widget.SimpleAdapter}
     *
     * @return view model of that account
     */
    private Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(MAP_KEYS[0], service);
        map.put(MAP_KEYS[1], login);
        map.put(MAP_KEYS[2], state);
        map.put(MAP_KEYS[3], creationDate);
        return map;
    }

    /** @return login of that user */
    public CharSequence getLogin() {
        return login;
    }

    /** @return the key provided by server that identifies current session */
    public String getAuthKey() {
        return authKey;
    }

    /** @param authKey new key for authentication */
    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    /** @return date when account was created */
    public String getCreationDate() {
        return DateFormat.getDateInstance().format(new Date(creationDate));
    }

    /** @return to which service that account relies */
    public NegotiableServices getService() {
        return service;
    }

    /**
     * @param state new state
     *
     * @return this account
     */
    public UserAccount setState(UserAccountState state) {
        this.state = state;
        return this;
    }
}