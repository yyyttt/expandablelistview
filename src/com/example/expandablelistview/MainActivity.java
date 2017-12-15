package com.example.expandablelistview;

import java.util.ArrayList;

import com.example.model.ChildModel;
import com.example.model.ParentModel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
	private ExpandableListView mExlistview;//父ExpandableListView
	private ArrayList<ParentModel> list = new ArrayList<ParentModel>();//数据源
	private ParentAdapter padapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
	}

	/**初始化数据
	 * 
	 */
	private void initData() {
 
		for(int i = 0; i<10;i++){
			ParentModel pmodel  = new ParentModel("第一级parentName"+i);
			for(int j = 0; j<4;j++){
				ChildModel cmodel = new ChildModel("第二级childName"+j);
				for(int z = 0;z<2;z++){
					cmodel.childChild.add("第三级"+z);
				}
				pmodel.ChildModel.add(cmodel);
			}
			list.add(pmodel);
		}
	}

	/**初始化控件
	 * 
	 */
	private void initView() {
		mExlistview = (ExpandableListView) findViewById(R.id.exlv);
		padapter = new ParentAdapter(MainActivity.this,list,mExlistview);
		mExlistview.setAdapter(padapter);
		padapter.notifyDataSetChanged();
	}
}
