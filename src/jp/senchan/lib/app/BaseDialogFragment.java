package jp.senchan.lib.app;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockDialogFragment;

public class BaseDialogFragment<AppClass extends BaseApp, ActivityClass extends BaseActivity<AppClass>> extends RoboSherlockDialogFragment {

	public AppClass app() {
		return activity().app();
	}

	@SuppressWarnings("unchecked")
    public ActivityClass activity() {
		return (ActivityClass) getActivity();
	}
}
