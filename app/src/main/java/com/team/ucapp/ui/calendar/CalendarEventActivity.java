package com.team.ucapp.ui.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.team.ucapp.R;

public class CalendarEventActivity extends AppCompatActivity {
    private Button mBtnClearDate;
    private TextInputEditText mInputEventDate;
    public final static String BUNDLE_DATE = "BUNDLE_DATE";
    TextView date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_event);
        mInputEventDate = findViewById(R.id.input_event_date);
        mBtnClearDate = findViewById(R.id.btn_clear_date);

        mBtnClearDate.setOnClickListener(onClickListener);

        mInputEventDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DatePickerFragment datePickerFragment = new DatePickerFragment();
                    Bundle args = new Bundle();
                    args.putString(BUNDLE_DATE, mInputEventDate.getText().toString().trim());
                    datePickerFragment.setArguments(args);
                    datePickerFragment.show(getSupportFragmentManager(), "datePicker");
                    mInputEventDate.clearFocus();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calendar_event, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item_add) {
            //agregar action
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        setTitle(R.string.calendar_event);
        super.onResume();
    }

    /*public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }*/

    public void setEventDate(String date) {
        mInputEventDate.setText(date);
        mBtnClearDate.setVisibility(View.VISIBLE);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mInputEventDate.setText(null);
            v.setVisibility(View.GONE);
        }
    };
}
