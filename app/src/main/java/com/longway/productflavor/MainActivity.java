package com.longway.productflavor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.e(TAG, getString(R.string.label));
//        B.print("hello");
//        Bundle bundle;
//        try {
//            bundle = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA).metaData;
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//            return;
//        }
//        String channel = bundle.getString("channel");
//        Log.e(TAG, channel);
//        final String market = PackerNg.getMarket(getApplication());
//        Log.d(TAG, market);
//        Log.e(TAG,"model:"+ Build.MODEL);
    }
}
