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

public class SubjectExpedientAdapter extends RecyclerView.Adapter<SubjectExpedientAdapter.SubjectExpedientViewHolder> {
    Context context;
    List<SubjectExpedient> subjectsExpedientDetail;


    @NonNull
    @Override
    public SubjectExpedientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.subject_expedient_list,parent,false);
        return (new SubjectExpedientViewHolder(view));
    }

    public SubjectExpedientAdapter(Context context, List<SubjectExpedient> subjectsExpedientDetail) {
        this.context = context;
        this.subjectsExpedientDetail = subjectsExpedientDetail;
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectExpedientViewHolder holder, int position) {
        holder.subjectLetter.setText(subjectsExpedientDetail.get(position).getSubjectLetter());
        holder.subject.setText(subjectsExpedientDetail.get(position).getSubject());
        holder.grade.setText(subjectsExpedientDetail.get(position).getGrade());
    }

    @Override
    public int getItemCount() {
        return subjectsExpedientDetail.size(); //cambiar despues por condicion para aver si esta vacio
    }

    public class SubjectExpedientViewHolder extends RecyclerView.ViewHolder{
        TextView subjectLetter, subject,grade;
        public SubjectExpedientViewHolder(View itemView) {
            super(itemView);
            subjectLetter = itemView.findViewById(R.id.txt_subject_letter);
            subject = itemView.findViewById(R.id.txt_subject);
            grade = itemView.findViewById(R.id.txt_grade);
        }
    }
}
