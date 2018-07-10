package com.team.ucapp.ui.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team.ucapp.R;
import com.team.ucapp.data.database.Event;

import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarAdapterViewHolder> {
    Context context;
    List<Event> events;
    Resources resources;

    @NonNull
    @Override
    public CalendarAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.calendar_event_item, parent, false);
        return (new CalendarAdapterViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarAdapterViewHolder holder, int position) {
        holder.day.setText(events.get(position).getDay());
        holder.month.setText(events.get(position).getMonth());
        holder.title.setText(events.get(position).getTitle());
        holder.description.setText(events.get(position).getDescription());
    }

    public CalendarAdapter(Fragment fragment,List<Event> events) {
        this.context = fragment.getContext();
        this.events = events;
    }

    public void setList(List<Event> newList) {
        this.events = newList;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return events == null ? 0 : events.size();
    }

    public class CalendarAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView day, month, title, description;
        LinearLayout subjectItem;

        public CalendarAdapterViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.txt_day);
            month = itemView.findViewById(R.id.txt_month);
            title = itemView.findViewById(R.id.txt_title);
            description = itemView.findViewById(R.id.txt_description);
        }
    }
}
