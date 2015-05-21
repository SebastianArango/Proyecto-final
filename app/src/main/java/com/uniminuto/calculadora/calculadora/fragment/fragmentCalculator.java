package com.uniminuto.calculadora.calculadora.fragment;


import android.app.Activity;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.uniminuto.calculadora.calculadora.R;

import java.text.DecimalFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCalculator extends Fragment {

    @InjectView(R.id.txtNota1)
    BootstrapEditText not1;

    @InjectView(R.id.txtNota2)
    BootstrapEditText not2;

    @InjectView(R.id.txtNota3)
    BootstrapEditText not3;

    @InjectView(R.id.btnCalcular)
    BootstrapButton btnCalcular;

    @InjectView(R.id.btnlimpiar)
    BootstrapButton btnlimpiar;

    @InjectView(R.id.labelresulta)
    TextView labelresulta;


    Double nota1, nota2, nota3, notafinal, notparcial, notasum;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        ButterKnife.inject(this, view);


        return view;
    }


    @OnClick(R.id.btnCalcular)
    public void calcularNotas(View view) {
        DecimalFormat df = new DecimalFormat("0.0");

        if (!TextUtils.isEmpty(not1.getText().toString()) && !TextUtils.isEmpty(not2.getText().toString()) &&
                !TextUtils.isEmpty(not3.getText().toString())) {

            nota1 = Double.parseDouble(not1.getText() + "");
            nota2 = Double.parseDouble(not2.getText() + "");
            nota3 = Double.parseDouble(not3.getText() + "");

            if (nota1 >= 0.0 && nota1 <= 5.0 && nota2 >= 0.0 && nota2 <= 5.0 && nota3 >= 0.0 && nota3 <= 5.0) {
               // notafinal = (nota1 + nota2 + nota3) / 3;
                notafinal =  (nota1 * 0.35) + (nota2 * 0.35) + (nota3 * 0.30);
                Math.rint(notafinal);

                if (notafinal > 2.95) {
                    labelresulta.setTextColor(getResources().getColor(R.color.color_green));
                    labelresulta.setText("Aprobaste \nNota final: " + df.format(notafinal));
                } else {
                    labelresulta.setTextColor(getResources().getColor(R.color.color_red));
                    labelresulta.setText("Reprobaste \nNota final: " + df.format(notafinal));
                }
                }else{
                    Toast.makeText(getActivity(), "Debes ingresar notas en el rango de 0.0 - 5.0", Toast.LENGTH_SHORT).show();
                }
            }

            if (!TextUtils.isEmpty(not1.getText().toString()) && !TextUtils.isEmpty(not2.getText().toString()) &&
                    TextUtils.isEmpty(not3.getText().toString())) {

                nota1 = Double.parseDouble(not1.getText() + "");
                nota2 = Double.parseDouble(not2.getText() + "");

                if (nota1 >= 0.0 && nota1 <= 5.0 && nota2 >= 0.0 && nota2 <= 5.0) {
                    notparcial = (nota1 * 0.35) + (nota2 * 0.35) - 3;
                    notafinal = notparcial / 0.3;
                    notafinal = notafinal * (-1);
                    notasum = (nota1 + nota2) / 3;
                    if (notasum >= 3) {
                        labelresulta.setTextColor(getResources().getColor(R.color.color_green));
                        labelresulta.setText("Obtuviste buenas notas en los primeros cortes \n" +
                                "Tu asignatura ahora tiene un promedio de: " + df.format(notasum));
                    }else if (notafinal>5 ){
                        labelresulta.setTextColor(getResources().getColor(R.color.color_red));
                        labelresulta.setText("No hay nada que hacer  \nTu asignatura fue reprobada \nTe faltaria:  " + df.format(notafinal));
                    }

                    else {
                        labelresulta.setTextColor(getResources().getColor(R.color.color_red));
                        labelresulta.setText("Para aplicar a una nota de 3.0 \nTe falta:  " + df.format(notafinal));

                    }


                } else {

                    Toast.makeText(getActivity(), "Debes ingresar notas en el rango de 0.0 - 5.0", Toast.LENGTH_SHORT).show();
                }
            }


            if (TextUtils.isEmpty(not1.getText().toString()) && TextUtils.isEmpty(not2.getText().toString())
                    && TextUtils.isEmpty(not3.getText().toString())) {

                not1.setError("Campo requerido");

            } else if (!TextUtils.isEmpty(not1.getText().toString()) && TextUtils.isEmpty(not2.getText().toString())
                    && TextUtils.isEmpty(not3.getText().toString())) {

                not2.setError("Campo requerido");

            } else if ((TextUtils.isEmpty(not1.getText().toString()) && !TextUtils.isEmpty(not2.getText().toString())
                    && TextUtils.isEmpty(not3.getText().toString()))) {

                not1.setError("Campo requerido");
            }

            if ((!TextUtils.isEmpty(not1.getText().toString()) && TextUtils.isEmpty(not2.getText().toString())
                    && !TextUtils.isEmpty(not3.getText().toString()))) {

                not2.setError("Campo requerido");
            } else if ((TextUtils.isEmpty(not1.getText().toString()) && !TextUtils.isEmpty(not2.getText().toString())
                    && !TextUtils.isEmpty(not3.getText().toString()))) {

                not1.setError("Campo requerido");
            }

        InputMethodManager inputMethodManager = (InputMethodManager)  getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

        }

        @OnClick(R.id.btnlimpiar)
        public void limpiarEditText (View view){
            InputMethodManager inputMethodManager = (InputMethodManager)  getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

            not1.setText("");
            not2.setText("");
            not3.setText("");
            labelresulta.setText("");
        }

    }


