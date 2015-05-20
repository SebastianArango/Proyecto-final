package com.uniminuto.calculadora.calculadora.fragment;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.uniminuto.calculadora.calculadora.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentOther extends Fragment {


    @InjectView(R.id.btncallGenesis)
    BootstrapButton btnCallGenesis;


    @InjectView(R.id.btncallAulas)
    BootstrapButton btncallAulas;

    @InjectView(R.id.btncallPortal)
    BootstrapButton btncallPortal;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_other, container, false);

        ButterKnife.inject(this, view);

        InputMethodManager inputMethodManager = (InputMethodManager)  getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

        return view;
    }

    @OnClick(R.id.btncallGenesis)
    public void callGenesis(View view) {
        Uri uri = Uri.parse("http://wiwa.uniminuto.edu:8501/pls/PROD/twbkwbis.P_WWWLogin");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }


    @OnClick(R.id.btncallAulas)
    public void callAulasVirtuales(View view) {
        Uri uri = Uri.parse("http://aulas.uniminuto.edu/inicio/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    @OnClick(R.id.btncallPortal)
    public void callPortal(View view) {
        Uri uri = Uri.parse("http://www.uniminuto.edu/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
}
