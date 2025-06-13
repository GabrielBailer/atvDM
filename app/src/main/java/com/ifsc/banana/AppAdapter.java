package com.ifsc.banana;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    int mResource;
    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView tvnome = convertView.findViewById(R.id.textView);
        LinearLayout linearLayout = convertView.findViewById(R.id.linearLayout);

        ApplicationInfo applicationInfo =  getItem(position);

        tvnome.setText(applicationInfo.loadLabel(getContext().getPackageManager()));
        imageView.setImageDrawable(applicationInfo.loadIcon(getContext().getPackageManager()));

        TextView textView = new TextView(getContext());
        textView.setText(applicationInfo.packageName);
        linearLayout.addView(textView);


       return convertView;
    }


}
