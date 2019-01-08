package com.bt.smart.truck_broker.adapter;

import android.content.Context;

import com.bt.smart.truck_broker.messageInfo.OrderListInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/11/20 14:07
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class RecyOrderAdapter extends BaseQuickAdapter<OrderListInfo, BaseViewHolder> {
    private Context mContext;

    public RecyOrderAdapter(int layoutResId, Context context, List data) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderListInfo item) {

    }
}
