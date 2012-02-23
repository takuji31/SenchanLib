/**
 * 
 */
package jp.senchan.lib.ui;

import jp.senchan.lib.BaseApp;
import jp.senchan.lib.ui.actionbar.ActionBarActivity;
import android.widget.Toast;

/**
 * @author takuji
 *
 */
public class BaseActivity extends ActionBarActivity {

	public BaseApp app() {
		return (BaseApp) getApplication();
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
