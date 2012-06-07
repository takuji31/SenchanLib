package jp.senchan.lib.view;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ListAdapter<T> extends BaseAdapter {

	protected LayoutInflater inflater;
	protected List<T> mList;
	protected Context mContext;
	
	public ListAdapter(Context context, List<T> list) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mList = list;
		mContext = context;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	public abstract int getViewLayoutId(int position);

	public abstract View createView(int position, T item, View v);

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int layoutId = getViewLayoutId(position);
		if (convertView == null || convertView.getId() != layoutId) {
			convertView = inflater.inflate(layoutId, null);
			convertView.setId(layoutId);
		}
		return createView(position, getItem(position), convertView);
	}

	@Override
	public T getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
