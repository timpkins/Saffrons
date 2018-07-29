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

package cn.saffron.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * 组件间跳转
 * @author timpkins
 */
public final class IntentUtils {

    /**
     * Activity之间跳转
     * @param context 源Activity
     * @param clazz 目的Activity
     * @param <T> Activity子类
     */
    public static <T extends Activity> void startActivity(Context context, Class<T> clazz){
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    public static <T extends Activity> void stattActivity(Context context, Class<T> clazz, String key, String value){
        Intent intent = new Intent(context, clazz);
        intent.putExtra(key,value);
        context.startActivity(intent);
    }

    public static <T extends Activity> void stattActivity(Context context, Class<T> clazz, Bundle bundle){
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

}
