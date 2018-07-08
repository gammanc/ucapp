package com.team.ucapp.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.team.ucapp.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HorizontalViewHolder>{

    Context context;
    private ArrayList<Section> sections;

    private final int TYPE_NEWS = 1;
    private final int TYPE_SCHEDULE = 2;
    private final int TYPE_EVENTS = 3;

    private static final String TAG = "HomeAdapter";

    public HomeAdapter(Context context, ArrayList<Section> sections) {
        Log.d(TAG, "HomeAdapter: Constructor called");
        this.context = context;
        this.sections = sections;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v;
        RecyclerView.ViewHolder holder;
        switch (viewType){
            case TYPE_NEWS:
                v = layoutInflater.inflate(R.layout.horizontalrecycler, parent, false);
                holder = new HorizontalViewHolder(v);
                break;
            case TYPE_SCHEDULE:
                v = layoutInflater.inflate(R.layout.verticalrecycler,parent,false);
                holder = new VerticalViewHolder(v);
                break;
            case TYPE_EVENTS:
                v = layoutInflater.inflate(R.layout.verticalrecycler,parent,false);
                holder = new VerticalViewHolder(v);
                break;
             default:
                 v = layoutInflater.inflate(R.layout.verticalrecycler,parent,false);
                 holder = new VerticalViewHolder(v);
                 break;
        }*/
        Log.d(TAG, "onCreateViewHolder: Setting viewholder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontalrecycler, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        final Section section = sections.get(position);
        Log.d(TAG, "onBindViewHolder: section:"+section.getSectionLabel());
        holder.title.setText(section.getSectionLabel());
        holder.recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recyclerView.setLayoutManager(manager);

        Log.d(TAG, "onBindViewHolder: elemetos:"+section.getObjects().size());
        ItemAdapter adapter = new ItemAdapter(context, section.getObjects());
        holder.recyclerView.setAdapter(adapter);
        /*switch (holder.getItemViewType()){

        }*/
    }

    @Override
    public int getItemCount() {
        return sections != null ? sections.size():0;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        Button button;
        RecyclerView recyclerView;

        HorizontalViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.section_title);
            button = itemView.findViewById(R.id.section_button);
            recyclerView = itemView.findViewById(R.id.section_recycler);
        }
    }

}
