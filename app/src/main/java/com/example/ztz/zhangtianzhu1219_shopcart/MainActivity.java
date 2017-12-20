package com.example.ztz.zhangtianzhu1219_shopcart;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ztz.zhangtianzhu1219_shopcart.adapter.ShopAdapter;
import com.example.ztz.zhangtianzhu1219_shopcart.bean.ShopBean;
import com.example.ztz.zhangtianzhu1219_shopcart.presenter.MainPresenter;
import com.example.ztz.zhangtianzhu1219_shopcart.view.MainViewListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements MainViewListener {

    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox checkBoxAll;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private MainPresenter presenter;
    private ShopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
        presenter.getData();

        adapter = new ShopAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);

        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num,boolean allCheck) {

                checkBoxAll.setChecked(allCheck);
                thirdTotalnum.setText("数量"+num);
                thirdTotalprice.setText("总价"+total+"元");
            }
        });
    }

    @Override
    public void success(ShopBean bean) {
        //向适配器添加数据
        if (bean != null) {
            adapter.add(bean);
        }
    }

    @Override
    public void failure(String e) {
        //失败toast提示
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {
        adapter.selectAll(checkBoxAll.isChecked());
    }
}