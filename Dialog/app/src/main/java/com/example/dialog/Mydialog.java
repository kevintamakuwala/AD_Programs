package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.*;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class Mydialog extends AppCompatDialogFragment {
    public Dialog onCreateDialog(Bundle b) {
        return new AlertDialog.Builder(getActivity()).setTitle("dialog").setMessage("hi").setPositiveButton("OK".new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface d,int p){

            }

        }).create();
    }
}
