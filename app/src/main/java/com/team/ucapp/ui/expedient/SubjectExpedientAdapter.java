package com.team.ucapp.ui.expedient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team.ucapp.R;

import java.util.List;

public class SubjectExpedientAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<SubjectExpedient> subjectsExpedientDetail;

    private final int TYPE_HEADER = 0;
    private final int TYPE_ITEM = 1;

    //TODO: añadir com header la parte superior del fragment

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER){
            View view = LayoutInflater.from(context).inflate(R.layout.expedient_header ,parent,false);
            return (new HeaderViewHolder(view));
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.subject_record_item,parent,false);
            return (new SubjectExpedientViewHolder(view));
        }
    }

    public SubjectExpedientAdapter(Context context, List<SubjectExpedient> subjectsExpedientDetail) {
        this.context = context;
        this.subjectsExpedientDetail = subjectsExpedientDetail;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(!(holder instanceof HeaderViewHolder)){
            SubjectExpedientViewHolder holderA = (SubjectExpedientViewHolder) holder;
            SubjectExpedient subjectExpedient = subjectsExpedientDetail.get(position);
            holderA.subjectLetter.setText(subjectExpedient.getSubjectLetter());
            holderA.subject.setText(subjectsExpedientDetail.get(position).getSubject());
            holderA.grade.setText(subjectsExpedientDetail.get(position).getGrade());
        }
    }

    @Override
    public int getItemCount() {
        return subjectsExpedientDetail.size(); //cambiar despues por condicion para aver si esta vacio
    }

    @Override
    public int getItemViewType(int position) {
        if(position ==0) return TYPE_HEADER;
        else return TYPE_ITEM;
    }

    class SubjectExpedientViewHolder extends RecyclerView.ViewHolder{
        TextView subjectLetter, subject,grade;
        SubjectExpedientViewHolder(View itemView) {
            super(itemView);
            subjectLetter = itemView.findViewById(R.id.txt_subject_letter);
            subject = itemView.findViewById(R.id.txt_subject);
            grade = itemView.findViewById(R.id.txt_grade);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView subjectLetter, subject,grade;
        HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
