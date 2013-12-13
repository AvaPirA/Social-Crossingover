package com.avapir.soccingover.activities;

import android.content.Context;
import android.widget.Toast;

/** User: Alpen Ditrix Date: 24.11.13 Time: 19:21 */
public class Toaster {

    private static void toast(Context context, CharSequence text, int length) {
        Toast.makeText(context, text, length).show();
    }

    private static void toast(Context context, int text, int length) {
        Toast.makeText(context, text, length).show();
    }

    public static void networkError(Context context) {
        toast(context, "Network unreachable", Toast.LENGTH_SHORT);
    }

    public static void accountCreated(Context context) {
        toast(context, "Account connected", Toast.LENGTH_LONG);
    }
}
