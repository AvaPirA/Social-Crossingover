package com.avapir.soccingover.activities.profile_management;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.avapir.soccingover.R;
import com.avapir.soccingover.core.AccountsHandler;
import com.avapir.soccingover.core.UserAccount;

import java.util.List;
import java.util.Map;

/** User: Alpen Ditrix Date: 23.11.13 Time: 19:11 */
public class AccountManagerActivity extends ListActivity {

    ListView listView;

    private void findViews() {
        listView = getListView();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_manager);
        findViews();
        loadProfiles();
    }

    private void loadProfiles() {
        List<Map<String, Object>> accountsMap = UserAccount.toViews(AccountsHandler.getAccounts(this));
        SimpleAdapter adapter = new SimpleAdapter(this, accountsMap, R.layout.list_element_user_profile,
                                                  UserAccount.MAP_KEYS, UserAccount.VIEW_IDs);
        adapter.notifyDataSetChanged();
    }


}