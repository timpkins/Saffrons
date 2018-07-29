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

package cn.saffron;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup.LayoutParams;

import cn.saffron.activity.BaseLifecycleHandle;
import cn.saffron.activity.TitleLifecyclerHandle;
import cn.saffron.util.LogUtils;
import cn.saffron.util.ScreenUtils;
import cn.saffron.view.ExToolbar;

/**
 * Activity生命周期方法回调的实现
 * @author timpkins
 */
public class SaffronActivityCallbacks implements ActivityLifecycleCallbacks {
    private static final String TAG = SaffronActivityCallbacks.class.getSimpleName();

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity instanceof AppCompatActivity && activity instanceof BaseLifecycleHandle) {
            BaseLifecycleHandle lifecycleHandle = (BaseLifecycleHandle) activity;
            activity.setContentView(lifecycleHandle.setContentView());
            if (activity instanceof TitleLifecyclerHandle) {
                initToolBar(activity);
            }
            lifecycleHandle.initView(savedInstanceState);
            lifecycleHandle.initData();
        }
    }

    /**
     * 初始化{@link Toolbar}，其高度为状态栏高度和标题栏高度之和，布局会自动延伸到状态栏上面
     * @param activity 当前Activity对象
     */
    private void initToolBar(Activity activity) {
        ExToolbar tbTitle = activity.findViewById(R.id.tbTitle);
        if (tbTitle != null) {
            int height = ScreenUtils.getStatusBarHeight();
            tbTitle.setPadding(0, height, 0, 0);
            LayoutParams params = tbTitle.getLayoutParams();
            params.height = height + activity.getResources().getDimensionPixelOffset(R.dimen.title_height);
            tbTitle.setLayoutParams(params);
            tbTitle.setMinimumHeight(activity.getResources().getDimensionPixelOffset(R.dimen.title_height));
            ((AppCompatActivity)activity).setSupportActionBar(tbTitle);
            ((TitleLifecyclerHandle) activity).initTitle(tbTitle);
        }
    }



    @Override
    public void onActivityStarted(Activity activity) {
        LogUtils.e(TAG, "onActivityStarted：" + activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        LogUtils.e(TAG, "onActivityResumed：" + activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        LogUtils.e(TAG, "onActivityPaused：" + activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
        LogUtils.e(TAG, "onActivityStopped：" + activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        LogUtils.e(TAG, "onActivitySaveInstanceState：" + activity);
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        LogUtils.e(TAG, "onActivityDestroyed：" + activity);
    }
}
