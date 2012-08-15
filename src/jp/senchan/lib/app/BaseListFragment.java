package jp.senchan.lib.app;

import com.actionbarsherlock.app.SherlockListFragment;


public class BaseListFragment<AppClass extends BaseApp, ActivityClass extends BaseActivity<AppClass>> extends SherlockListFragment {

	public AppClass app() {
		return activity().app();
	}

	@SuppressWarnings("unchecked")
    public ActivityClass activity() {
		return (ActivityClass) getActivity();
	}
}
