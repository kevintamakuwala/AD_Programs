package com.example.datetimepicker.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.timepicker.TimeFormat;

import java.text.DateFormat;
import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    EditText editText;

    public TimePickerFragment(EditText e) {
        editText = e;
    }

    @Override
    public Dialog onCreateDialog(Bundle b) {
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR);
        int m = c.get(Calendar.MINUTE);
        return new TimePickerDialog(requireContext(), this, h, m, true);
    }

    @Override
    public void onTimeSet(TimePicker tp, int h, int m) {
        editText.setText(h + " " + m);
    }

}
