/**
 *
 */
package jp.senchan.lib.ui;

import com.actionbarsherlock.app.SherlockFragment;

import jp.senchan.lib.BaseApp;

/**
 * @author takuji
 *
 */
public class BaseFragment<AppClass extends BaseApp, ActivityClass extends BaseActivity<AppClass>> extends SherlockFragment {

	@SuppressWarnings("unchecked")
    public ActivityClass activity() {
	    return (ActivityClass) getActivity();
	}

	public AppClass app() {
        return activity().app();
    }
}
