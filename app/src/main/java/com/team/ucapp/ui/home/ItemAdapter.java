package com.team.ucapp.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.team.ucapp.R;
import com.team.ucapp.data.database.News;
import com.team.ucapp.utils.GlideApp;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = "ItemAdapter";
    private Context context;
    private ArrayList<Object> items;

    private final int TYPE_NEWS = 1;
    private final int TYPE_SCHEDULE = 2;
    private final int TYPE_EVENTS = 3;

    public ItemAdapter(Context context, ArrayList<Object> items) {
        Log.d(TAG, "ItemAdapter: Constructor called");
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v;
        RecyclerView.ViewHolder holder;
        switch (viewType){
            case TYPE_NEWS:
                v = layoutInflater.inflate(R.layout.news_item,parent,false);
                holder = new NewsViewHolder(v);
                break;
            case TYPE_SCHEDULE:
                v = layoutInflater.inflate(R.layout.class_schedule_item,parent,false);
                holder = new ScheduleViewHolder(v);
                break;
            case TYPE_EVENTS:
                v = layoutInflater.inflate(R.layout.calendar_event_item,parent,false);
                holder = new EventViewHolder(v);
                break;
             default:
                 v = layoutInflater.inflate(R.layout.calendar_event_item,parent,false);
                 holder = new EventViewHolder(v);
                 break;
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        if(items.get(position) instanceof EventDummy)
            return TYPE_EVENTS;
        if(items.get(position) instanceof News)
            return TYPE_NEWS;
        //TODO: añadir y crear los otros tipos
        return -1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case TYPE_EVENTS:
                eventView((EventDummy) items.get(position), (EventViewHolder) holder);
                break;
            case TYPE_NEWS:
                newsView((News) items.get(position), (NewsViewHolder) holder);
                break;
        }
    }

    private void eventView(EventDummy event ,EventViewHolder holder){
        holder.txtTitle.setText(event.getTitle());
        holder.txtDay.setText(event.getDate().substring(0,1));
        holder.txtMonth.setText(event.getDate().substring(3,8));
        holder.txtDescription.setText(event.getDescription());
    }

    private void newsView(News newItem, NewsViewHolder holder){
        if(newItem.getTitle()!=null)
            holder.txtTitle.setText(newItem.getTitle().trim());
        else
            holder.txtTitle.setText(context.getResources().getString(R.string.no_title_available));


        if(newItem.getDescription()!=null)
            holder.txtSubtitle.setText(newItem.getDescription().trim());
        else
            holder.txtSubtitle.setText(context.getResources().getString(R.string.no_description_available));

        if(newItem.getCoverImage() != null){
            GlideApp.with(context)
                    .load(newItem.getCoverImage())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.no_image)
                    .fallback(R.drawable.no_image)
                    .error(R.drawable.no_image)
                    .into(holder.imgPicture);
        } else
            holder.imgPicture.setImageResource(R.drawable.no_image);

        /*if(newItem.isFavorite()){
            holder.btnFav.setImageResource(R.drawable.ic_favorites);
            holder.btnFav.setTag("y");
        } else {
            holder.btnFav.setImageResource(R.drawable.ic_favorite_border);
            holder.btnFav.setTag("n");
        }*/

        //holder.btnFav.setOnClickListener(v-> mClickHandler.onNewsChecked(holder.btnFav, newItem.getId()));
    }

    @Override
    public int getItemCount() {
        return items!=null ? items.size():0;
    }

    class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView txtInitial;
        TextView txtSubject;
        TextView txtTeacher;
        TextView txtPlaceHour;

        ScheduleViewHolder(View itemView) {
            super(itemView);
            txtInitial = itemView.findViewById(R.id.initial);
            txtSubject = itemView.findViewById(R.id.txt_subject);
            txtTeacher = itemView.findViewById(R.id.txt_teacher);
            txtPlaceHour = itemView.findViewById(R.id.txt_place_and_hour);
        }
    }
    class EventViewHolder extends RecyclerView.ViewHolder {
        TextView txtDay;
        TextView txtMonth;
        TextView txtTitle;
        TextView txtDescription;

        EventViewHolder(View itemView) {
            super(itemView);
            txtDay = itemView.findViewById(R.id.txt_day);
            txtMonth = itemView.findViewById(R.id.txt_month);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDescription = itemView.findViewById(R.id.txt_description);
        }
    }

    class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout card;
        TextView txtTitle, txtSubtitle;
        ImageView imgPicture;//, btnFav;

        public NewsViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.news_view);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtSubtitle = itemView.findViewById(R.id.txt_subtitle);
            imgPicture = itemView.findViewById(R.id.img_cover);
            //btnFav = itemView.findViewById(R.id.btn_favorite);
            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //mClickHandler.onNewsClick(newsArray.get(getAdapterPosition()));
        }
    }
}
