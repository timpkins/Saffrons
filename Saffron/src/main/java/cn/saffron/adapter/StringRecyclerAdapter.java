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

package cn.saffron.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView}数据适配器，暂仅支持同一类数据类型
 * @author timpkins
 */
public abstract class StringRecyclerAdapter extends Adapter<BaseViewHolder> {
    private List<String> datas; // 存储列表数据，永不为null
    @LayoutRes
    private int layoutId;
    private LayoutInflater inflater;
    private OnItemClickListener itemClickListener;
    private OnItemLongClickLister itemLongClickListener;

    public StringRecyclerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        layoutId = setLayoutRes();
        datas = new ArrayList<>();
    }

    @LayoutRes
    protected abstract int setLayoutRes();

    public void setItemClickListener(@NonNull OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setItemLongClickListener(@NonNull OnItemLongClickLister itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(layoutId, parent, false);
        return new BaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        onBindViewHolder(holder, position, datas.get(position));
        if (itemClickListener != null) {
            holder.itemView.setOnClickListener(view -> itemClickListener.onItemClickListener(view, position,
                    datas.get(position)));
        }
        if (itemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(view -> {
                itemLongClickListener.onItemLongClickListener(view, position, datas.get(position));
                return true;
            });
        }
    }

    protected abstract void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull String d);

    public boolean isEmpty() {
        return datas.isEmpty();
    }

    public boolean add(String d) {
        return datas.add(d);
    }

    public boolean remove(String d) {
        return datas.remove(d);
    }


    public boolean addAll(@NonNull List<String> lists) {
        return datas.addAll(lists);
    }

    public boolean addAll(int index, @NonNull List<String> lists) {
        return datas.addAll(index, lists);
    }

    public boolean removeAll(@NonNull List<String> lists) {
        return datas.retainAll(lists);
    }

    public void clear() {
        datas.clear();
    }

    public String get(int index) {
        return datas.get(index);
    }

    public String set(int index, String element) {
        return datas.set(index, element);
    }

    public void add(int index, String element) {
        datas.add(index, element);
    }

    public String remove(int index) {
        return datas.remove(index);
    }

    /**
     * item点击事件监听
     * @param <D> item中相应的数据
     */
    public interface OnItemClickListener<D> {

        /**
         * item点击事件监听
         * @param view item相应的布局
         * @param position item相应的位置
         * @param data item中相应的数据
         */
        void onItemClickListener(View view, int position, D data);
    }

    /**
     * item长按事件监听
     * @param <D> item中相应的数据
     */
    public interface OnItemLongClickLister<D> {

        /**
         * item长按事件监听
         * @param view item相应的布局
         * @param position item相应的位置
         * @param data item中相应的数据
         */
        void onItemLongClickListener(View view, int position, D data);
    }
}
