package jp.senchan.lib.ui;

import com.actionbarsherlock.app.SherlockListFragment;

import jp.senchan.lib.BaseApp;

public class BaseListFragment<AppClass extends BaseApp, ActivityClass extends BaseActivity<AppClass>> extends SherlockListFragment {

	public AppClass app() {
		return activity().app();
	}

	@SuppressWarnings("unchecked")
    public ActivityClass activity() {
		return (ActivityClass) getActivity();
	}
}
