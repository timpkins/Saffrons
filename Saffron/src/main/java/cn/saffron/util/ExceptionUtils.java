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

import android.util.Log;

/**
 * 异常信息输出
 * @author timpkins
 */
public final class ExceptionUtils {

    /**
     * 异常日志的输出
     * @param e 异常信息
     */
    public static void printStackTrace(Exception e){
        Log.w(e.getMessage(), "全局捕获异常：", e);
    }
}
