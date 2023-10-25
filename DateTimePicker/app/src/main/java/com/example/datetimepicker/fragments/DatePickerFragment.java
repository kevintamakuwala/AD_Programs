package com.example.datetimepicker.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    EditText editText;

    public DatePickerFragment(EditText e) {
        editText = e;
    }

    @Override
    public Dialog onCreateDialog(Bundle b) {
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(requireContext(), this, y, m, d);
    }

    @Override
    public void onDateSet(DatePicker view, int y, int m, int d) {
        editText.setText(y + " " + (m + 1) + " " + d);
    }

}
