package jp.senchan.lib.app;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

@SuppressLint("HandlerLeak")
public class ToastService extends Service {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public static final String LENGTH = "LENGTH";

    public static final int MESSAGE_DISPLAY = 0;
    public static final int MESSAGE_TIMER = 1;

    private ToastHandler mToastHandler;

    public static void showToast(Context context, String message, int length) {
        Intent service = new Intent(context, ToastService.class);
        service.putExtra(EXTRA_MESSAGE, message);
        service.putExtra(LENGTH, length);
        context.startService(service);
    }

    private class ToastHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
            case MESSAGE_DISPLAY: {
            	Toast.makeText(getApplicationContext(), (String)msg.obj, msg.arg2).show();
                removeMessages(MESSAGE_TIMER);
                sendMessageDelayed(obtainMessage(MESSAGE_TIMER, msg.arg1, 0), 4 * 1000);
                break;
            }
            case MESSAGE_TIMER: {
                stopSelf(msg.arg1);
                break;
            }
            }
        }
    }

	@Override
    public void onCreate() {
        super.onCreate();
        // HandlerとServiceの生存時間はほとんど一緒なのでリークとは言えないと考える
       mToastHandler = new ToastHandler();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    	String messageString = intent.getStringExtra(EXTRA_MESSAGE);
    	int length = intent.getIntExtra(LENGTH, Toast.LENGTH_SHORT);
        Message msg = mToastHandler.obtainMessage(MESSAGE_DISPLAY, startId, length, messageString);
        mToastHandler.sendMessage(msg);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
