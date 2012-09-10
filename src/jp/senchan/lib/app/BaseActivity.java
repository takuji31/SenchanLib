package jp.senchan.lib.app;

import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;


public class BaseActivity<AppClass extends BaseApp> extends RoboSherlockFragmentActivity {

	@SuppressWarnings("unchecked")
    public AppClass app() {
		return (AppClass) getApplication();
	}
}
