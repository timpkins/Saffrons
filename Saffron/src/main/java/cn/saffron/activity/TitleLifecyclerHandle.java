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

import android.support.annotation.NonNull;

import cn.saffron.view.ExToolbar;

/**
 * 带标题栏Activity的方法接口
 * @author timpkins
 */
public interface TitleLifecyclerHandle extends BaseLifecycleHandle{

    /**
     * 标题栏的初始化
     */
    void initTitle(@NonNull ExToolbar tbTitle);
}
