package com.michael.viewstubdemo;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainAdapter extends BaseAdapter {

//	private Context context;
	private List<Map<String, String>> data;
	private LayoutInflater layoutInflater;

	public MainAdapter(Context context, List<Map<String, String>> data) {

//		this.context = context;
		this.data = data;
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}

	class ViewHolder {
		RelativeLayout rlListItem;// 点击展开或收起ViewStub

		View vsOperations;// 点击后显示的更多的操作
		ImageButton ibCompelete;// 打钩按钮
		ImageButton ibImportant;// 感叹号按钮
		ImageButton ibNotify;// 提醒按钮
		ImageButton ibLove;// 爱心按钮
		ImageButton ibShare;// 分享按钮
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		if (convertView == null) {

			convertView = layoutInflater.inflate(R.layout.list_item_main_task,
					null);
			viewHolder = new ViewHolder();
			viewHolder.rlListItem = (RelativeLayout) convertView
					.findViewById(R.id.rl_list_item);
			viewHolder.vsOperations = (ViewStub) convertView
					.findViewById(R.id.vs_detail_operations);

			convertView.setTag(viewHolder);
		} else {

			viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.vsOperations.setVisibility(View.GONE);
		}

		viewHolder.rlListItem.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (viewHolder.vsOperations.getVisibility() == View.GONE) {
					
					if(viewHolder.vsOperations instanceof ViewStub){
						
						viewHolder.vsOperations = ((ViewStub)viewHolder.vsOperations).inflate();
					}
					viewHolder.vsOperations.setVisibility(View.VISIBLE);
					
				} else {

					viewHolder.vsOperations.setVisibility(View.GONE);
				}
			}
		});

		Log.e("111", "getView");
		
		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}
