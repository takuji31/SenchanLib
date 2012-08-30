package jp.senchan.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PagingListView extends ListView implements AbsListView.OnScrollListener {
	
	private static final int POST_DELAY_TIME = 50;

	public static interface OnPagingListener {
		public void onScrollStart(int page);
		public void onScrollFinish(int page);
		public void onNextListLoad(int page);
	}
		
	private int mPage;
	private int mScrollDuration = 400;
	private boolean mFlinged;
	private OnPagingListener mListener;
	private OnGlobalLayoutListener mLayoutListener = new OnGlobalLayoutListener() {
		@Override
		public void onGlobalLayout() {
			mViewHeight = getHeight();
			ListAdapter adapter = getAdapter();
			if (adapter != null && adapter instanceof PagingArrayListAdapter<?>) {
				((PagingArrayListAdapter<?>)adapter).notifyDataSetChanged(mViewHeight);
			} else {
				setAdapter(adapter);
			}
		}
	};
	
	int mViewHeight;

	public PagingListView(Context context) {
		super(context);
		init();
	}

	public PagingListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PagingListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();		
	}
	
	public void setPagingListener(OnPagingListener listener) {
		mListener = listener;
	}
	
	public void setNowPage(int page){
		mPage = page;		
	}
			
	public int getNowPage(){
		return mPage;
	}
		
	public void scrollNextPage(){
		View firstVisibleView = getChildAt(0);
		mPage += 1;
		smoothScrollBy(mViewHeight-0-Math.abs(firstVisibleView.getTop())-1, 400);
	}
		
	public void scrollPrevPage(){
		View firstVisibleView = getChildAt(0);
		mPage -= 1;
		smoothScrollBy(firstVisibleView.getTop(), mScrollDuration);
	}
	
	private void init(){
		setOnScrollListener(this);
		ViewTreeObserver observer = getViewTreeObserver();
		observer.addOnGlobalLayoutListener(mLayoutListener);
	}

	public void setAdapter(PagingArrayListAdapter<?> adapter) {
		if (mViewHeight != 0) {
			adapter.setViewHeight(mViewHeight);
		}
		super.setAdapter(adapter);
	}
	
	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		switch (scrollState) {
		 
	    case OnScrollListener.SCROLL_STATE_IDLE:			    				    				    	
	    	if (mFlinged) {
	    		mFlinged = false;
	    		if (mListener != null) {
					mListener.onScrollFinish(mPage);
				}
			}else{
				postDelayed(new Runnable() {
		    	    public void run() {
		    	    	int savedPosition = getFirstVisiblePosition();
		    	    	View firstVisibleView = getChildAt(0);
		    	    	
		    	    	if (firstVisibleView.getHeight()/2.0 < Math.abs(firstVisibleView.getTop())) { 
		    	    		mPage = savedPosition;
				    		smoothScrollBy(mViewHeight - Math.abs(firstVisibleView.getTop() - 1), mScrollDuration); 
				    	}else{			    		
				    		mPage = savedPosition;
				    		smoothScrollBy(firstVisibleView.getTop(), mScrollDuration);
				    	}
		    	    		
		    	    	if (mListener != null) {
							mListener.onScrollFinish(mPage);
						}
		    	    } 
		    	}, POST_DELAY_TIME);
			}
	    				    	
	        break;
	 
	    case OnScrollListener.SCROLL_STATE_FLING:			    				    				    
	    	mFlinged = true;
	    	postDelayed(new Runnable() {
	    	    public void run() {
	    	    	int savedPosition = getFirstVisiblePosition();
	    	    	View firstVisibleView = getChildAt(0);			    	    				    	    	
	    	    	
	    	    	Adapter adapter = getAdapter();
	    	    	int totalPage = adapter != null ? adapter.getCount() : 0;
	    	    	if (savedPosition < mPage){			    	    		
	    	    		if (mPage + 1 == totalPage ) {
	    	    			int firstVisibleItem = mPage-getFirstVisiblePosition();
							View lastView = getChildAt(firstVisibleItem);
	    	    			if (lastView.getTop() > 0) {
	    	    				scrollPrevPage();
	    	    			}
						}else{
							scrollPrevPage();
						}
			    	}else if (0 < savedPosition || ( 0 == savedPosition && 0 > firstVisibleView.getTop() ) ){					    		
			    		if (mPage != totalPage - 1) {
							scrollNextPage();
						} 		
			    	}
	    	    	
	    	    	mListener.onScrollStart(mPage);
	    	    } 			    	    
	    	}, POST_DELAY_TIME);
	    				    	
	        break;
	    }
	}
	
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		if (mListener != null) {
			mListener.onNextListLoad(mPage);
		}				
	}
}
