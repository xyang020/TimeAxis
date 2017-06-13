package com.you.timeaxis;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by youxuan on 2017/6/12 0012.
 */

public class TimeAxisAdapter extends RecyclerView.Adapter<TimeAxisAdapter.TimeViewHolder> {


    private ArrayList<HashMap<String,Object>> listItem;
    private LayoutInflater mInflater;

    public TimeAxisAdapter(Context context,ArrayList<HashMap<String, Object>> listItem) {
        mInflater = LayoutInflater.from(context);
        this.listItem = listItem;
    }

    @Override
    public TimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cell_item,null);
        TimeViewHolder holder = new TimeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TimeViewHolder holder, int position) {

        if (holder!=null){
            holder.title.setText((String) listItem.get(position).get("ItemTitle"));
            holder.text.setText((String) listItem.get(position).get("ItemText"));

        }
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class TimeViewHolder extends RecyclerView.ViewHolder{

        private TextView title,text;
        public TimeViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
            text = (TextView) itemView.findViewById(R.id.item_text);
        }

        public TextView getTitle(){
            return title;
        }
        public TextView getText(){
            return text;
        }
    }
}
