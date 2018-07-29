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
 * {@link ExRecyclerView}上拉刷新View基类
 * @author timpkins
 */
public abstract class RecyclerHeaderView extends LinearLayout implements RecyclerCommon {
    @HeaderState
    protected int headerState = STATE_NORMAL;

    public RecyclerHeaderView(Context context) {
        super(context);
    }

    public RecyclerHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RecyclerHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 设置下拉刷新View的状态{@link HeaderState}
     * @param state 下拉刷新View的状态{@link HeaderState}
     */
    protected abstract void setHeaderState(@HeaderState int state);

    /**
     * 获取下拉刷新View的状态{@link HeaderState}
     * @return 下拉刷新View的状态{@link HeaderState}
     */
    @HeaderState
    protected abstract int getHeaderState();

    /**
     * {@link ExRecyclerView}移动时的操作
     * @param deltaY Y轴移动的增量
     */
    protected abstract void onMove(float deltaY);

    /**
     * 当前是否处于刷新状态
     * @return true：处于刷新状态，false：不处于刷新状态
     */
    protected abstract boolean releaseAction();

}
