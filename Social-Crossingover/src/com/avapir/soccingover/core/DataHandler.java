package com.avapir.soccingover.core;

import android.content.Context;
import com.avapir.soccingover.Constants;
import com.perm.kate.api.Api;

/** User: Alpen Ditrix Date: 23.11.13 Time: 20:12 */
public class DataHandler {

    public static Api api = new Api
            ("7945a5cff9ca38ed3919d8550e1e5417608b78ae9c4c17ea3875e5adeb07e47b169dbeea92ed4a121532a",
             Constants.APP_ID_VK);

    private DataHandler() {
    }

    public static DbHelper getDatabase(Context context) {
        return new DefautDbHelper(context);
    }
}
