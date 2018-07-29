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
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

/**
 * 无标题栏Activity的方法接口
 * @author timpkins
 */
public interface BaseLifecycleHandle {

    /**
     * 当前Activity的布局资源ID
     * @return 布局资源ID
     */
    @LayoutRes
    int setContentView();

    /**
     * 初始化当前布局中的View
     * @param savedInstanceState 保存的上一次对象的状态
     */
    void initView(@NonNull Bundle savedInstanceState);

    /**
     * 当前Activity中数据的操作
     */
    void initData();
}
