package com.example.chess4x4_android_version;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<String> messages;

    DataAdapter(Context context, List<String> messages) {
        this.messages = messages;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String message = messages.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            holder.messageHolder.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_NONE);
        }
        holder.messageHolder.setText(message);
    }

    public void setItem(String s) {
        messages.add(s);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView messageHolder;
        ViewHolder(View view){
            super(view);
            messageHolder = (TextView)view.findViewById(R.id.message);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                messageHolder.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_NONE);
            }

        }
    }
}
