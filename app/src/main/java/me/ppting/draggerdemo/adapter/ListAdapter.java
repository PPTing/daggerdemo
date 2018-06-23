package me.ppting.draggerdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.ppting.draggerdemo.R;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{

    private List<Items> items;

    public ListAdapter(){
        this.items = new ArrayList<>();
    }

    public ListAdapter(List<Items> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        Items item = items.get(position);
        holder.radioAndCheckBoxText.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Items> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView radioAndCheckBoxText;

        ListViewHolder(View itemView) {
            super(itemView);
            radioAndCheckBoxText = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
