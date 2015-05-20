package com.uniminuto.calculadora.calculadora.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;
import com.uniminuto.calculadora.calculadora.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentMessage extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.string_wellcome));
        builder.setMessage(getString(R.string.string_Texto));

        builder.setPositiveButton(R.string.string_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                           }

        });

        Dialog dialog = builder.create();

        return dialog;


    }

}