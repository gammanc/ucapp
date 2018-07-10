package com.team.ucapp.ui.calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.os.ConfigurationCompat;
import android.util.Log;
import android.widget.DatePicker;
import com.team.ucapp.R;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = DatePickerFragment.class.getSimpleName();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        long maxDate = c.getTimeInMillis();
        if (getArguments() != null) {
            String current_date = getArguments().getString(CalendarEventActivity.BUNDLE_DATE);
            if (current_date != null && !current_date.isEmpty()) {
                c.setTime(dateFromString(current_date, c.getTime()));
            }
        }
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dp =  new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog,this, year, month, day);
        dp.getDatePicker().setMaxDate(maxDate);
        dp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dp.getDatePicker().setCalendarViewShown(false);
        return  dp;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, dayOfMonth);
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, ConfigurationCompat.getLocales(getResources().getConfiguration()).get(0));
        String date = df.format(cal.getTime());
        CalendarEventActivity eventActivity = (CalendarEventActivity) getActivity();
        if (eventActivity != null) {
            eventActivity.setEventDate(date);
        }

    }

    private Date dateFromString(String date, Date defaultDate) {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.date_format_short));
        try {
            d = sdf.parse(date);
        }
        catch (ParseException e) {
            Log.e(TAG, "dateFromString: " + e);
            d = defaultDate;
        }
        return d;
    }


}