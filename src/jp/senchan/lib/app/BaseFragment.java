/**
 *
 */
package jp.senchan.lib.app;

import com.actionbarsherlock.app.SherlockFragment;


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
