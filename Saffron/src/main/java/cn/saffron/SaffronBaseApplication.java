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

import android.app.Application;

/**
 * Application基类，注册Activity生命周期方法的回调，使用该库的项目必须继承该类并在AndroidManifest.xml中注册。
 * @author timpkins
 */
public class SaffronBaseApplication extends Application {
    private static SaffronBaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        registerActivityLifecycleCallbacks(new SaffronActivityCallbacks()); // 注册Activity生命周期回调
        Thread.setDefaultUncaughtExceptionHandler(new SaffronExceptionHandler());
    }

    public static SaffronBaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        System.exit(0);
    }
}
