package com.ifsc.banana;

import android.content.Intent;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.content.pm.ApplicationInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    PackageManager pm;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        pm = getPackageManager();
        List<ApplicationInfo> applicationInfoList = new ArrayList<>();

        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(i, 0);
        applicationInfoList.clear();
        resolveInfos.forEach(resolveInfo -> {
            applicationInfoList.add(resolveInfo.activityInfo.applicationInfo);
        });
        AppAdapter adapter = new AppAdapter(this, R.layout.item_app, applicationInfoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ApplicationInfo app = (ApplicationInfo) adapterView.getItemAtPosition(i);
                Intent in = pm.getLaunchIntentForPackage(app.packageName);
                startActivity(in);
            }

        });
    }

}