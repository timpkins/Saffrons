/*
 * Copyright (C) 2018 timpkins
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.saffron.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;

import cn.saffron.R;
import cn.saffron.adapter.BaseRecyclerAdapter;
import cn.saffron.view.ExRecyclerView;
import cn.saffron.view.ExRecyclerView.OnRefreshLoadListener;

/**
 * 实现了列表控件{@link ExRecyclerView}的Actvity，布局文件中必须有ID为ervContent的ExRecyclerView
 * @author timpkins
 */
public abstract class BaseRecyclerActivity extends SaffronTitleActivity implements OnRefreshLoadListener{
    protected ExRecyclerView ervContent;

    @Override
    public void initView(@NonNull Bundle savedInstanceState) {
        initRecyclerView();
    }

    /**
     * 初始化{@link ExRecyclerView}
     */
    private void initRecyclerView(){
        ervContent = findViewById(R.id.ervContent);
        if (ervContent == null){
            throw new RuntimeException("layout must be contain id named ervContent");
        }
        LinearLayoutManager linear = new LinearLayoutManager(this);
        ervContent.setLayoutManager(linear);
        ervContent.setOnRefreshLoadListener(this);
    }

    /**
     * 获取当前的{@link ExRecyclerView}对象
     * @return 当前的{@link ExRecyclerView}对象
     */
    protected ExRecyclerView getRecyclerView(){
        return ervContent;
    }

    /**
     * 设置{@link ExRecyclerView}的数据适配器
     * @param adapter {@link ExRecyclerView}的数据适配器
     * @param <T> 必须为{@link BaseRecyclerAdapter}或其子类
     */
    protected <T extends Adapter> void setAdapter(T adapter){
        ervContent.setAdapter(adapter);
    }

    /**
     * 获取{@link ExRecyclerView}的数据适配器
     * @return {@link ExRecyclerView}的数据适配器
     */
    protected <T extends BaseRecyclerAdapter> T getAdapter(){
        return (T)ervContent.getAdapter();
    }

    /**
     * 设置{@link ExRecyclerView}的布局管理器
     * @param layout {@link ExRecyclerView}的布局管理器
     */
    protected void setLayoutManager(LayoutManager layout){
        ervContent.setLayoutManager(layout);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoading() {

    }
}
