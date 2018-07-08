package com.team.ucapp.ui.grades;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team.ucapp.R;
import com.team.ucapp.ui.expedient.SubjectExpedient;
import com.team.ucapp.ui.expedient.SubjectExpedientAdapter;

import java.util.List;

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.GradesAdapterViewHolder> {
    Context context;
    List<SubjectExpedient> subjectsExpedientDetail;

    public interface GradesAdapterListener{
        public void onSubjectSelected(String subject);
    }

    private GradesAdapterListener mListener;
    @NonNull
    @Override
    public GradesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.subject_grade_item,parent,false);
        return (new GradesAdapterViewHolder(view));
    }

    public GradesAdapter(Fragment fragment, List<SubjectExpedient> subjectsExpedientDetail) {
        this.context = fragment.getContext();
        this.subjectsExpedientDetail = subjectsExpedientDetail;
        mListener = (GradesAdapterListener) fragment;
    }

    public void setList(List<SubjectExpedient> newList){
        this.subjectsExpedientDetail = newList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull GradesAdapterViewHolder holder, int position) {
        Log.d("GradesAdapter", "bindviewholder");
        holder.subjectLetter.setText(subjectsExpedientDetail.get(position).getSubjectLetter());
        holder.subject.setText(subjectsExpedientDetail.get(position).getSubject());
        holder.grade.setText(subjectsExpedientDetail.get(position).getGrade());
        holder.subjectItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onSubjectSelected(subjectsExpedientDetail.get(position).getSubject());
            }
        });
    }

    @Override
    public int getItemCount() {
        return  subjectsExpedientDetail == null ? 0 : subjectsExpedientDetail.size(); //cambiar despues por condicion para aver si esta vacio
    }

    public class GradesAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView subjectLetter, subject,grade;
        LinearLayout subjectItem;
        public GradesAdapterViewHolder(View itemView) {
            super(itemView);
            subjectItem = itemView.findViewById(R.id.subject_grade_item);
            subjectLetter = itemView.findViewById(R.id.txt_subject_letter);
            subject = itemView.findViewById(R.id.txt_subject);
            grade = itemView.findViewById(R.id.txt_grade);
        }
    }
}
