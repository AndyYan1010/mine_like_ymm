package com.bt.smart.truck_broker.adapter;

import android.content.Context;

import com.bt.smart.truck_broker.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/9 21:07
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class RecyPlaceAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private Context mContext;

    public RecyPlaceAdapter(int layoutResId, Context context, List data) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String place) {
        //(ImageView) helper.getView(R.id.img_kind)
        helper.setText(R.id.tv_place, place);
    }
}
