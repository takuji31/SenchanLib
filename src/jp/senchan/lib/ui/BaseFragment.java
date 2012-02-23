/**
 * 
 */
package jp.senchan.lib.ui;

import jp.senchan.lib.BaseApp;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * @author takuji
 *
 */
public class BaseFragment extends Fragment {

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
