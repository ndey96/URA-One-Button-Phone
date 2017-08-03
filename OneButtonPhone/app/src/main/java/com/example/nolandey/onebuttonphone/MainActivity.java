package com.example.nolandey.onebuttonphone;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    private Activity thisActivity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(thisActivity, new String[]{Manifest.permission.CALL_PHONE}, 2);
                } else {
                    callHusband();
                }
            }
        });
    }

    private void callHusband() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        // 226-338-3795
        // 647-530-8266
        intent.setData(Uri.parse("tel:+1-226-338-3795"));
        Log.d("test", "attempting to call husband");
        try {
            startActivity(intent);
        } catch (SecurityException e) {
            Log.d("test", e.toString());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 2) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callHusband();
            }
            return;
        }
    }
}
