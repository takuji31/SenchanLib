package jp.senchan.lib.view;

import com.actionbarsherlock.app.SherlockDialogFragment;
import jp.senchan.lib.BaseApp;

public class BaseDialogFragment<AppClass extends BaseApp, ActivityClass extends BaseActivity<AppClass>> extends SherlockDialogFragment {

	public AppClass app() {
		return activity().app();
	}

	@SuppressWarnings("unchecked")
    public ActivityClass activity() {
		return (ActivityClass) getActivity();
	}
}
