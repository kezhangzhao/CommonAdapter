package com.bit.commonadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.bit.adapter.lvadapter.CommonLvAdapter;
import com.bit.adapter.lvadapter.ViewHolderLv;
import com.bit.adapter.rvadapter.CommonRvAdapter;
import com.bit.adapter.rvadapter.SimpleDividerItemDecoration;
import com.bit.adapter.rvadapter.ViewHolderRv;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private RecyclerView recyclerView;
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
        setAdapter();
    }

    /**
     * 初始化view
     */
    private void initView() {
        listView = findViewById(R.id.lv_view);
        recyclerView = findViewById(R.id.rc_view);
    }

    /**
     * 设置adapter
     */
    private void setAdapter() {
        listView.setAdapter(new CommonLvAdapter<String>(this, R.layout.item_acitivity_main, data) {
            @Override
            protected void convert(ViewHolderLv viewHolder, String item, int position) {
                //item：数据datas列表中的bean类
                viewHolder.setText(R.id.tv_item, item);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加分割线
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, 0.5f));
        recyclerView.setAdapter(new CommonRvAdapter<String>(this, R.layout.item_acitivity_main, data) {

            @Override
            public void convert(ViewHolderRv holder, String item, int position) {
                //item：数据datas列表中的bean类
                holder.setText(R.id.tv_item, item);
            }
        });
    }

    /**
     * 创建数据
     */
    private void getData() {
        data.add("001");
        data.add("002");
        data.add("003");
        data.add("004");
        data.add("005");
        data.add("006");
        data.add("007");
        data.add("008");
        data.add("009");
        data.add("010");
        data.add("011");
        data.add("012");
        data.add("013");
        data.add("014");
    }
}
