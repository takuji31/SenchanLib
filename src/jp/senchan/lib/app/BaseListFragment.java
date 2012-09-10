package jp.senchan.lib.app;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockListFragment;


public class BaseListFragment<AppClass extends BaseApp, ActivityClass extends BaseActivity<AppClass>> extends RoboSherlockListFragment {

	public AppClass app() {
		return activity().app();
	}

	@SuppressWarnings("unchecked")
    public ActivityClass activity() {
		return (ActivityClass) getActivity();
	}
}
