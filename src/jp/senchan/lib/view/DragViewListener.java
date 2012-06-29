package jp.senchan.lib.view;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DragViewListener implements OnTouchListener {

	private View mTargetView;
	private int mBeforeX;
	private int mBeforeY;
	private OnTouchListener mExtraEventListener;
	
	public DragViewListener(View targetView, OnTouchListener extraEventListener) {
		mTargetView = targetView;
		mExtraEventListener = extraEventListener;
	}

	public boolean onTouch(View v, MotionEvent event) {
		int x = (int) event.getRawX();
		int y = (int) event.getRawY();

		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			int left = mTargetView.getLeft() + (x - mBeforeX);
			int top = mTargetView.getTop() + (y - mBeforeY);
			mTargetView.layout(left, top, left + mTargetView.getWidth(), top
					+ mTargetView.getHeight());
		}

		mBeforeX = x;
		mBeforeY = y;
		if (mExtraEventListener != null) {
			mExtraEventListener.onTouch(v, event);
		}
		return true;
	}
}