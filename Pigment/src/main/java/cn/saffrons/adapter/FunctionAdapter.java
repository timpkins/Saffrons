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

package cn.saffrons.adapter;

import android.content.Context;
import android.support.annotation.NonNull;

import cn.saffron.adapter.BaseViewHolder;
import cn.saffron.adapter.StringRecyclerAdapter;
import cn.saffrons.R;

/**
 * @author timpkins
 */
public class FunctionAdapter extends StringRecyclerAdapter {

    public FunctionAdapter(Context context) {
        super(context);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.item_function_layout;
    }

    @Override
    protected void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull String d) {
        holder.setText(R.id.tv, d);
    }
}
