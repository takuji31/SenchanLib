package jp.senchan.lib.os;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;

public abstract class AsyncTaskCompat<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    @TargetApi(11)
	public AsyncTask<Params,Progress,Result> supportExecute(Params... params) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return this.executeOnExecutor(THREAD_POOL_EXECUTOR, params);
        } else {
            return this.execute(params);
        }
    }
}
