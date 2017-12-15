package com.example.expandablelistview;

import java.util.ArrayList;

import com.example.expandablelistview.ParentAdapter.Pholder;
import com.example.model.ChildModel;
import com.example.model.ParentModel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class ChildAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<ChildModel> childModellist;
	private ExpandableListView exlv;

	public ChildAdapter(Context context, ArrayList<ChildModel> childModellist,
			ExpandableListView exlv) {
		this.context =context;
		this.childModellist = childModellist;
		this.exlv = exlv;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return childModellist.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return childModellist.get(groupPosition).childChild.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return childModellist;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childModellist.get(groupPosition).childChild.get(childPosition);
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
					R.layout.child_group, null);
			pholder.tv = (TextView) convertView
					.findViewById(R.id.child_group_tv);
			convertView.setTag(pholder);

		} else {
			pholder = (Pholder) convertView.getTag();
		}
		// 赋值
		ChildModel pmodel = childModellist.get(groupPosition);
		pholder.tv.setText(pmodel.childName);
		return convertView;
	}
	class Cholder {
		TextView tv;
	}
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		Cholder cholder;
		if (convertView == null) {
			cholder = new Cholder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.child_child, null);
			cholder.tv = (TextView) convertView
					.findViewById(R.id.child_child_tv);
			convertView.setTag(cholder);

		} else {
			cholder = (Cholder) convertView.getTag();
		}
		// 赋值
		String cmodel = childModellist.get(groupPosition).childChild.get(childPosition);
		cholder.tv.setText(cmodel);
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
		return false;
	}

}
