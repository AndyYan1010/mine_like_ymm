package com.bt.smart.truck_broker.fragment.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.adapter.RecyPlaceAdapter;
import com.bt.smart.truck_broker.utils.PopupOpenHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/9 19:52
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SetLinesAddressFragment extends Fragment implements View.OnClickListener {
    private View             mRootView;
    private TextView         tv_title;
    private ImageView        img_back;
    private RecyclerView     recy_st;//起点
    private RecyclerView     recy_ed;//目的地
    private LinearLayout     linear_cf00;
    private LinearLayout     linear_md00;
    private RelativeLayout   rlt_car_model;
    private TextView         tv_choice_model;
    private List             mDataSt;
    private List             mDataEd;
    private RecyPlaceAdapter placeAdapter;
    private RecyPlaceAdapter placeEdAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.frame_set_lines, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        tv_title = mRootView.findViewById(R.id.tv_title);
        img_back = mRootView.findViewById(R.id.img_back);
        recy_st = mRootView.findViewById(R.id.recy_st);
        recy_ed = mRootView.findViewById(R.id.recy_ed);
        linear_cf00 = mRootView.findViewById(R.id.linear_cf00);
        linear_md00 = mRootView.findViewById(R.id.linear_md00);
        rlt_car_model = mRootView.findViewById(R.id.rlt_car_model);
        tv_choice_model = mRootView.findViewById(R.id.tv_choice_model);
    }

    private void initData() {
        img_back.setVisibility(View.VISIBLE);
        tv_title.setText("添加常用路线");

        mDataSt = new ArrayList();
        mDataSt.add("南通");
        mDataSt.add("南通");
        mDataSt.add("南通");
        recy_st.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        placeAdapter = new RecyPlaceAdapter(R.layout.adpter_city_place, getContext(), mDataSt);
        recy_st.setAdapter(placeAdapter);
        placeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mDataSt.remove(position);
                placeAdapter.notifyDataSetChanged();
            }
        });

        mDataEd = new ArrayList();
        mDataEd.add("南通");
        mDataEd.add("南通");
        recy_ed.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        placeEdAdapter = new RecyPlaceAdapter(R.layout.adpter_city_place, getContext(), mDataEd);
        recy_ed.setAdapter(placeEdAdapter);
        placeEdAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mDataEd.remove(position);
                placeEdAdapter.notifyDataSetChanged();
            }
        });

        mDataPopEd = new ArrayList<>();

        img_back.setOnClickListener(this);
        linear_cf00.setOnClickListener(this);
        linear_md00.setOnClickListener(this);
        rlt_car_model.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                getActivity().finish();
                break;
            case R.id.linear_cf00://选择出发地
                selectStartPlace();
                break;
            case R.id.linear_md00://选择目的地

                break;
            case R.id.rlt_car_model:
                //跳转选择车型界面
                toChoiceCarModel();
                break;
        }
    }

    private void toChoiceCarModel() {
        ChoiceCarModelFragment carModelFragment = new ChoiceCarModelFragment();
        carModelFragment.setTopFragment(this);
        FragmentTransaction ftt = getFragmentManager().beginTransaction();
        ftt.add(R.id.frame, carModelFragment, "carModelFragment");
        ftt.addToBackStack("carModelFragment");
        ftt.commit();
    }

    private List mDataPopEd;
    private int  stCityLevel;

    private void selectStartPlace() {
        PopupOpenHelper openHelper = new PopupOpenHelper(getContext(), linear_cf00, R.layout.popup_choice_start);
        openHelper.openPopupWindowWithView(true, 0, (int) linear_cf00.getY() + linear_cf00.getHeight());
        openHelper.setOnPopupViewClick(new PopupOpenHelper.ViewClickListener() {
            @Override
            public void onViewClickListener(PopupWindow popupWindow, View inflateView) {
                RecyclerView recy_city = inflateView.findViewById(R.id.recy_city);
                final TextView tv_back = inflateView.findViewById(R.id.tv_back);
                recy_city.setLayoutManager(new GridLayoutManager(getContext(), 4));
                final RecyPlaceAdapter recyPlaceAdapter = new RecyPlaceAdapter(R.layout.adpter_pop_city_place, getContext(), mDataPopEd);
                recy_city.setAdapter(recyPlaceAdapter);
                recyPlaceAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        if (stCityLevel == 0) {
                            mDataPopEd.clear();
                            tv_back.setVisibility(View.VISIBLE);
                            //添加选择省对应的城市数据
                            mDataPopEd.add("");
                            recyPlaceAdapter.notifyDataSetChanged();
                        } else if (stCityLevel == 1) {
                            mDataPopEd.clear();
                            //添加选择城市对应的区数据
                            mDataPopEd.add("");
                        }
                        stCityLevel++;
                    }
                });
                //设置返回上一级事件
                tv_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        stCityLevel--;
                        if (stCityLevel == 0) {
                            tv_back.setVisibility(View.GONE);
                            mDataPopEd.clear();
                            //添加省数据
                            mDataPopEd.add("");
                        } else if (stCityLevel == 1) {
                            mDataPopEd.clear();
                            //添加上一级对应城市数据
                            mDataPopEd.add("");
                        }
                    }
                });
            }
        });
    }

    public void setChioceTerm(){

    }
}
