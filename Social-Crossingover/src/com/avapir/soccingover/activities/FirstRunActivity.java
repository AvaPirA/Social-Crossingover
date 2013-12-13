package com.avapir.soccingover.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.avapir.soccingover.Constants;
import com.avapir.soccingover.R;
import com.avapir.soccingover.activities.profile_management.LoginActivity;
import com.avapir.soccingover.core.DataHandler;
import com.avapir.soccingover.core.NegotiableServices;
import com.perm.kate.api.Api;
import com.perm.kate.api.KException;
import com.perm.kate.api.beans.User;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** User: Alpen Ditrix Date: 20.11.13 Time: 13:04 */
public class FirstRunActivity extends Activity implements View.OnClickListener {

    private static final int CODE_AUTH = 141231414;
    Button twitter;
    Button vk;
    Button instagram;

    private void findViews() {
        twitter = (Button) findViewById(R.id.btn_login_twitter);
        vk = (Button) findViewById(R.id.btn_login_vk);
        instagram = (Button) findViewById(R.id.btn_login_instagram);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_run);

        findViews();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        twitter.setOnClickListener(this);
        vk.setOnClickListener(this);
        instagram.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        switch (v.getId()) {
            case R.id.btn_login_twitter:
                startActivity(new Intent(this, FeedActivity.class));
//                intent.putExtra(LoginActivity.BUNDLE_KEY_SERVICE, NegotiableServices.TWITTER);
                return;
            case R.id.btn_login_vk:
                intent.putExtra(LoginActivity.BUNDLE_KEY_SERVICE, NegotiableServices.VK);
                break;
            case R.id.btn_login_instagram:
                intent.putExtra(LoginActivity.BUNDLE_KEY_SERVICE, NegotiableServices.INSTAGRAM);
                break;
        }
        startActivityForResult(intent, CODE_AUTH);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE_AUTH) {
            if (resultCode == RESULT_OK) {
                final String access_token = data.getStringExtra("token");
                final long user_id = data.getLongExtra("user_id", 0);
                final Api api = new Api(access_token, Constants.APP_ID_VK);
                DataHandler.api = api;
                //todo create and save account
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        boolean b = true;
                        try {
                            final List<User> list = api.getProfiles(new ArrayList<Long>() {{
                                add(user_id);
                            }}, null, null, null, null, null);
                            FirstRunActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast t = Toast.makeText(FirstRunActivity.this, String.format("%s\n%s\n%s",
                                                                                                  list.get(0).uid, list
                                            .get(0).first_name, list.get(0).last_name), Toast.LENGTH_LONG);
                                    ((LinearLayout) t.getView()).setGravity(
                                            Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                                    t.show();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File
                            // Templates.
                        } catch (JSONException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File
                            // Templates.
                        } catch (KException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File
                            // Templates.
                        }
                    }
                }).start();
            }
        }
    }
}