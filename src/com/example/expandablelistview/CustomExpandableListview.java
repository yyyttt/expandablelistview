package com.example.expandablelistview;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**自定义ExpandableListView,解决二级嵌套数据不显示的问题
 * @author YangTao
 *
 */
public class CustomExpandableListview extends ExpandableListView{

	public CustomExpandableListview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public CustomExpandableListview(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomExpandableListview(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

    
    
}
