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

import android.annotation.SuppressLint;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 默认的无标题Activity的抽象类，在项目中只需继承该类和实现相关方法即可
 * @author timpkins
 */
@SuppressLint("Registered")
public abstract class SaffronBaseActivity extends AppCompatActivity implements BaseLifecycleHandle, OnClickListener{

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    protected <T extends View> T findView(@IdRes int res){
        return getDelegate().findViewById(res);
    }
}
