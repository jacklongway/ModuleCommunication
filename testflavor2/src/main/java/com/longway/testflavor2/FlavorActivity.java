package com.longway.testflavor2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by longway on 16/11/7. Email:longway1991117@sina.com
 */

public class FlavorActivity extends AppCompatActivity {
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavor);
        mBtn = (Button) findViewById(R.id.flavor_btn);
        Flavor.getInstance().addUiInterface(Constants.UPDATE, this);
        setTitle("Module Flavor2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Flavor.getInstance().removeUiInterface(Constants.UPDATE);
    }

    public void action(View view) {
        FModule.build().getUIService().startActivityFlavor(this);
    }

    public void update(String msg) {
        mBtn.setText(msg);
    }
}
