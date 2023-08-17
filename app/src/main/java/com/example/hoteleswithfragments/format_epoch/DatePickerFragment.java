package com.example.hoteleswithfragments.format_epoch;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private OnSelectTime onSelectTime;

    public DatePickerFragment(OnSelectTime onSelectTime) {
        this.onSelectTime = onSelectTime;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,day);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.YEAR,year);
        this.onSelectTime.timeSelect(c.getTimeInMillis());
        Log.e("La fecha es: ", ""+ c.getTimeInMillis());
    }
}
