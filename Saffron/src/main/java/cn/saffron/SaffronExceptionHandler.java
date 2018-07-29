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

import java.lang.Thread.UncaughtExceptionHandler;

import cn.saffron.util.ExceptionUtils;

/**
 * 默认异常处理
 * @author timpkins
 */
public class SaffronExceptionHandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable exception) {
        ExceptionUtils.printStackTrace((Exception) exception);
        SaffronBaseApplication.getInstance().onTerminate();
    }
}
