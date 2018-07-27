package cn.saffrons.activity;

import android.os.Bundle;

import cn.saffron.activity.SaffronBaseActivity;
import cn.saffrons.R;

public class MainActivity extends SaffronBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
