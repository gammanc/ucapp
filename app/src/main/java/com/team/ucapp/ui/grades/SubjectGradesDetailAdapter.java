package com.team.ucapp.ui.grades;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team.ucapp.R;
import com.team.ucapp.ui.expedient.SubjectExpedient;

import java.util.List;

public class SubjectGradesDetailAdapter extends RecyclerView.Adapter<SubjectGradesDetailAdapter.SubjectDetailViewHolder> {
    Context context;
    List<SubjectGrades> subjectsGradesDetail;

    public SubjectGradesDetailAdapter(Context context, List<SubjectGrades> subjectsGradesDetail) {
        this.context = context;
        this.subjectsGradesDetail = subjectsGradesDetail;
    }

    @NonNull
    @Override
    public SubjectDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.subject_grades_detail_item,parent,false);
        return (new SubjectDetailViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectDetailViewHolder holder, int position) {
        holder.evaluationName.setText(subjectsGradesDetail.get(position).getEvaluation());
        holder.date_percentage.setText(subjectsGradesDetail.get(position).getDate_percentage());
        holder.grade.setText(subjectsGradesDetail.get(position).getGrade());
    }

    @Override
    public int getItemCount() {
        return subjectsGradesDetail == null ? 0 : subjectsGradesDetail.size();
    }

    public class SubjectDetailViewHolder  extends RecyclerView.ViewHolder{
       TextView evaluationName, date_percentage, grade;
        public SubjectDetailViewHolder(View itemView) {
            super(itemView);
            evaluationName = itemView.findViewById(R.id.txt_evaluation_name);
            date_percentage = itemView.findViewById(R.id.txt_date_and_percentage);
            grade = itemView.findViewById(R.id.txt_grade);
        }
    }

    //adaptar metodo para solo un item
    public void setList(List<SubjectGrades> newList){
        this.subjectsGradesDetail = newList;
        notifyDataSetChanged();
    }

}
