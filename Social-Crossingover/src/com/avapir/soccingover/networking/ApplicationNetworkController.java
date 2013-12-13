package com.avapir.soccingover.networking;

import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

/** User: Alpen Ditrix Date: 10.11.13 Time: 16:15 To change this template use File | Settings | File Templates. */
public class ApplicationNetworkController {

    public synchronized void doRequest(String requestUrl) throws ExecutionException, InterruptedException {
        MyAsyncTask requester = new MyAsyncTask(requestUrl);
        requester.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR).execute((Void) null);
    }

    public void cancelCurrentRequest() {

    }

}
