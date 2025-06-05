package com.ifsc.banana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {

    private final Context context;
    private final List<AppInfo> originalList;
    private final List<AppInfo> displayList;

    public AppAdapter(Context context, List<AppInfo> apps) {
        this.context = context;
        this.originalList = new ArrayList<>(apps);
        this.displayList = new ArrayList<>(apps);
    }

    public void filter(String text) {
        displayList.clear();
        if (text.isEmpty()) {
            displayList.addAll(originalList);
        } else {
            for (AppInfo app : originalList) {
                if (app.getLabel().toLowerCase().contains(text.toLowerCase())) {
                    displayList.add(app);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public AppAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.app_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppAdapter.ViewHolder holder, int position) {
        AppInfo app = displayList.get(position);
        holder.icon.setImageDrawable(app.getIcon());
        holder.label.setText(app.getLabel());
        holder.itemView.setOnClickListener(v -> context.startActivity(app.getLaunchIntent()));
    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView label;
        ViewHolder(View view) {
            super(view);
            icon = view.findViewById(R.id.app_icon);
            label = view.findViewById(R.id.app_label);
        }
    }
}
