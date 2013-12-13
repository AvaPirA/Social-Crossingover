package com.avapir.soccingover.activities.profile_management;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.avapir.soccingover.Constants;
import com.avapir.soccingover.R;
import com.avapir.soccingover.core.NegotiableServices;
import com.perm.kate.api.Auth;

/** Activity User: Alpen Ditrix Date: 24.11.13 Time: 14:34 */
public class LoginActivity extends Activity {

    public static final  String BUNDLE_KEY_SERVICE = "nj4kl79G79g3";
    private static final String TAG                = "Kate.LoginActivity";
    WebView webview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        webview = (WebView) findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.clearCache(true);

        //Чтобы получать уведомления об окончании загрузки страницы
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                try {
                    if (url == null) { return; }
                    Log.i(TAG, "url=" + url);

                    if (url.startsWith(Auth.redirect_url)) {
                        if (!url.contains("error=")) {
                            String[] auth = Auth.parseRedirectUrl(url);
                            Intent intent = new Intent();
                            Log.v("token", auth[0]);
                            Log.v("user_id", auth[1]);
                            intent.putExtra("token", auth[0]);
                            intent.putExtra("user_id", Long.parseLong(auth[1]));
                            setResult(Activity.RESULT_OK, intent);
                        } else {
                            throw new Exception();
                        }
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();

        String url;
        switch ((NegotiableServices) getIntent().getSerializableExtra(BUNDLE_KEY_SERVICE)) {
            case VK:
                url = Auth.getUrl(Constants.APP_ID_VK, Auth.getSettings());
                Log.v("url=", url);
                break;
            default:
                throw new InternalError();
        }

        webview.loadUrl(url);
    }
}