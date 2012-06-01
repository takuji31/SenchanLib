/**
 *
 */
package jp.senchan.lib.view;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import jp.senchan.lib.BaseApp;

/**
 * @author takuji
 *
 */
public class BaseActivity<AppClass extends BaseApp> extends SherlockFragmentActivity {

	@SuppressWarnings("unchecked")
    public AppClass app() {
		return (AppClass) getApplication();
	}
}
