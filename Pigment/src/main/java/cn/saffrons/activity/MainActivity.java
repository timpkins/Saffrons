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

package cn.saffrons.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.widget.Toast;

import cn.saffron.view.ExToolbar;
import cn.saffrons.R;

public class MainActivity extends PigmentTitleActivity{
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initTitle(@NonNull ExToolbar tbTitle) {
        int i = 2 / 0;
        tbTitle.setTitleBackground(R.color.colorAccent);
        tbTitle.setTitleName(R.string.app_name);
        tbTitle.setTitleNavigation(R.mipmap.ic_arrow_back);
        tbTitle.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_search:
                    Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_add:
                    Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_setting:
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        });
    }

    @Override
    public void initView(@NonNull Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 绑定toobar跟menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
