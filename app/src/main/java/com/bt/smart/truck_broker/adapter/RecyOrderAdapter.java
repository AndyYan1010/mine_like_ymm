package com.bt.smart.truck_broker.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.messageInfo.AllOrderListInfo;
import com.bt.smart.truck_broker.utils.ShowCallUtil;
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

public class RecyOrderAdapter extends BaseQuickAdapter<AllOrderListInfo.DataBean, BaseViewHolder> {
    private Context mContext;

    public RecyOrderAdapter(int layoutResId, Context context, List data) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final AllOrderListInfo.DataBean item) {
        //        (ImageView) helper.getView(R.id.img_call)
        helper.setText(R.id.tv_place, item.getFhAddress() + "  →  " + item.getShAddress());
        helper.setText(R.id.tv_goodsname, item.getGoodsName());
        helper.setText(R.id.tv_loadtime, "装货时间：" + item.getZhTime());
        helper.setText(R.id.tv_name, item.getFhName());
        ImageView img_call = (ImageView) helper.getView(R.id.img_call);
        img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowCallUtil.showCallDialog(mContext, item.getFhTelephone());
            }
        });
    }
}
