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

import android.app.Activity;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * 自定义Toolbar
 * @author timpkins
 */
public class ExToolbar extends Toolbar {

    public ExToolbar(Context context) {
        super(context);
    }

    public ExToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTitleBackground(@ColorRes int res){
        setBackgroundResource(res);
    }

    public void setTitleName(@StringRes int res){
        setTitle(res);
    }

    public void setTitleName(@StringRes int res, @ColorInt int textColor){
        setTitle(res);
        setTitleTextColor(textColor);
    }

    public void setTitleNavigation(@DrawableRes int res){
        setNavigationIcon(res);
        setNavigationOnClickListener(v -> ((Activity)getContext()).finish());
    }

    public void setTitleNavigation(@DrawableRes int res, @NonNull OnClickListener listener){
        setNavigationIcon(res);
        setNavigationOnClickListener(listener);
    }
}
