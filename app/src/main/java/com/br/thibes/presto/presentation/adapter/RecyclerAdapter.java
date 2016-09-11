package com.br.thibes.presto.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.br.thibes.presto.R;
import com.br.thibes.presto.presentation.model.WaitingItem;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<WaitingItem> items;

    public RecyclerAdapter(ArrayList<WaitingItem> list) {
        this.items = list;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout container = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        TextView title = (TextView) container.findViewById(R.id.recycler_view_title);
        TextView time = (TextView) container.findViewById(R.id.recycler_view_time);
        ViewHolder viewHolder = new RecyclerAdapter.ViewHolder(container, title, time);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        WaitingItem item = this.items.get(position);
        // TODO change container
        holder.time.setText(item.getTime());
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        TextView title;
        TextView time;

        public ViewHolder(RelativeLayout container, TextView title, TextView time) {
            super(container);
            this.container = container;
            this.title = title;
            this.time = time;
        }
    }
}
