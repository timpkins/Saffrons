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

package cn.saffron.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * {@link ExRecyclerView} 上拉加载View
 * @author timpkins
 */
public abstract class RecyclerFooterView extends LinearLayout implements RecyclerCommon {

    public RecyclerFooterView(Context context) {
        super(context);
    }

    public RecyclerFooterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerFooterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RecyclerFooterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 设置上拉加载View的状态
     * @param state 上拉加载View的状态
     */
    protected abstract void setFooterState(@FooterState int state);
}
