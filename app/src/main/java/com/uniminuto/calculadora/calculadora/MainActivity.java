package com.uniminuto.calculadora.calculadora;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.uniminuto.calculadora.calculadora.fragment.fragmentCalculator;
import com.uniminuto.calculadora.calculadora.fragment.fragmentMessage;
import com.uniminuto.calculadora.calculadora.fragment.fragmentOther;
import com.uniminuto.calculadora.calculadora.fragment.fragment_Acercade;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;


public class MainActivity extends MaterialNavigationDrawer  {

    fragmentMessage mensaje;

    @Override
    public void init(Bundle savedInstanceState) {


        this.setDrawerBackground(this.getResources().getDrawable(R.mipmap.logo22));

        this.addSection(this.newSection("Calcular notas", this.getResources().getDrawable(R.mipmap.calculator24),
                new fragmentCalculator()).setSectionColor(Color.parseColor("#2196f3")));


        this.addSection(this.newSection("Institucional",this.getResources().getDrawable(R.mipmap.chrome_3_24),
                new fragmentOther()).setSectionColor((Color.parseColor("#2196f3")))); // material orange 500

        this.addSection(this.newSection("Acerca de",this.getResources().getDrawable(R.mipmap.ic_action_person),
                new fragment_Acercade()).setSectionColor((Color.parseColor("#2196f3"))));

            mensaje = new fragmentMessage();
            mensaje.show(getSupportFragmentManager(), "key");

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.closeSesion) {
            finish();
            return true;
        }

        if(this.getCurrentFocus() != null && this.getCurrentFocus() instanceof EditText){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        return super.onOptionsItemSelected(item);
    }

}