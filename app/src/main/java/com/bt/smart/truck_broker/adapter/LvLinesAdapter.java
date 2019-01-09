package com.bt.smart.truck_broker.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bt.smart.truck_broker.R;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/9 8:59
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class LvLinesAdapter extends BaseAdapter {
    private Context mContext;
    private List    mList;

    public LvLinesAdapter(Context context, List list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return null == mList ? 0 : mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final MyViewHolder viewholder;
        if (null == view) {
            viewholder = new MyViewHolder();
            view = View.inflate(mContext, R.layout.adapter_personal_lines, null);
            viewholder.tv_place = view.findViewById(R.id.tv_place);
            viewholder.tv_explain = view.findViewById(R.id.tv_explain);
            viewholder.tv_del = view.findViewById(R.id.tv_del);
            view.setTag(viewholder);
        } else {
            viewholder = (MyViewHolder) view.getTag();
        }

        return view;
    }

    private class MyViewHolder {
        TextView tv_del, tv_explain, tv_place;
    }
}
