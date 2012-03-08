package jp.senchan.lib.ui;

import com.actionbarsherlock.app.SherlockListFragment;

import jp.senchan.lib.BaseApp;
import android.widget.Toast;

public class BaseListFragment extends SherlockListFragment {

	public BaseApp app() {
		return getBaseActivity().app();
	}

	public BaseActivity getBaseActivity() {
		return (BaseActivity) getActivity();
	}

	public Toast toast(int text_id) {
		return app().toast(text_id);
	}

	public Toast toast(String text) {
		return app().toast(text);
	}

	public Toast longToast(int text_id) {
		return app().longToast(text_id);
	}

	public Toast longToast(String text) {
		return app().longToast(text);
	}
}
