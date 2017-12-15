package com.example.expandablelistview;

import java.util.ArrayList;

import com.example.model.ParentModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class ParentAdapter extends BaseExpandableListAdapter {
	private Context context;
	private ArrayList<ParentModel> list;
	private ExpandableListView mExlistview;

	public ParentAdapter(Context context, ArrayList<ParentModel> list,
			ExpandableListView mExlistview) {
		this.context = context;
		this.list = list;
		this.mExlistview = mExlistview;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	// 解决数据重复问题：返回一个ExpandableListview
	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return list.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return list.get(groupPosition).ChildModel.get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	class Pholder {
		TextView tv;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		Pholder pholder;
		if (convertView == null) {
			pholder = new Pholder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.parent_group, null);
			pholder.tv = (TextView) convertView
					.findViewById(R.id.parent_group_tv);
			convertView.setTag(pholder);

		} else {
			pholder = (Pholder) convertView.getTag();
		}
		// 赋值
		ParentModel pmodel = list.get(groupPosition);
		pholder.tv.setText(pmodel.parentName);
		return convertView;
	}

	// 子ExpandableListView
	class Cholder {
		ExpandableListView exlv;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		Cholder cholder;
		if (convertView == null) {
			cholder = new Cholder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.parent_child, null);
			cholder.exlv = (ExpandableListView) convertView
					.findViewById(R.id.parent_child_exlv);
			convertView.setTag(cholder);

		} else {
			cholder = (Cholder) convertView.getTag();
		}

		ChildAdapter cAdatper = new ChildAdapter(this.context,
				list.get(groupPosition).ChildModel, cholder.exlv);
		cholder.exlv.setAdapter(cAdatper);

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
