package com.avapir.soccingover.core;

import android.content.Context;

import java.util.List;

/** User: Alpen Ditrix Date: 24.11.13 Time: 16:51 */
public class AccountsHandler {

    private static List<UserAccount> cachedList;

    private AccountsHandler() {}

    public static List<UserAccount> getAccounts(Context context) {
        return cachedList != null ? DataHandler.getDatabase(context).getUserAccounts() : cachedList;
    }

    public static void saveAccount(UserAccount account, Context context) {
        cachedList.add(account);
        DataHandler.getDatabase(context).saveAccount(account);
    }

}
