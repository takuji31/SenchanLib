/**
 *
 */
package jp.senchan.lib.app;

import com.actionbarsherlock.app.SherlockFragmentActivity;


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
