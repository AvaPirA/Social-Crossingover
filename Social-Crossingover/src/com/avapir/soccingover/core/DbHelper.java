package com.avapir.soccingover.core;

import java.util.List;

/**
 * Declareated db-access methods for the most of all goals
 * <p/>
 * User: Alpen Ditrix Date: 23.11.13 Time: 19:53
 */
public interface DbHelper {

    public void storeProfile(UserAccount account);

    public List<UserAccount> getUserAccounts();

    public void saveAccount(UserAccount account);
}
