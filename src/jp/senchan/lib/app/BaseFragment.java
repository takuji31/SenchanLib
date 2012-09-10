/**
 *
 */
package jp.senchan.lib.app;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;


/**
 * @author takuji
 *
 */
public class BaseFragment<AppClass extends BaseApp, ActivityClass extends BaseActivity<AppClass>> extends RoboSherlockFragment {

	@SuppressWarnings("unchecked")
    public ActivityClass activity() {
	    return (ActivityClass) getActivity();
	}

	public AppClass app() {
        return activity().app();
    }
}
