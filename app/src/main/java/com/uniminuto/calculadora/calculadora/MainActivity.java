package com.uniminuto.calculadora.calculadora;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.uniminuto.calculadora.calculadora.fragment.fragmentCalculator;
import com.uniminuto.calculadora.calculadora.fragment.fragmentMessage;
import com.uniminuto.calculadora.calculadora.fragment.fragmentOther;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;


public class MainActivity extends MaterialNavigationDrawer  {

    fragmentMessage mensaje;

    @Override
    public void init(Bundle savedInstanceState) {


        this.setDrawerBackground(this.getResources().getDrawable(R.mipmap.logo2));

        this.addSection(this.newSection("Calcular notas", this.getResources().getDrawable(R.mipmap.calculator24),
                new fragmentCalculator()).setSectionColor(Color.parseColor("#2196f3")));


        this.addSection(this.newSection("Institucional",this.getResources().getDrawable(R.mipmap.chrome_3_24),
                new fragmentOther()).setSectionColor((Color.parseColor("#2196f3")))); // material orange 500

            mensaje = new fragmentMessage();
            mensaje.show(getSupportFragmentManager(), "key");


//        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//
//        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(mDrawerLayout.getWindowToken(), 0);
//        }



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

        return super.onOptionsItemSelected(item);
    }

}