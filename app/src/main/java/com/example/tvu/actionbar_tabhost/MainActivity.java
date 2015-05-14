package com.example.tvu.actionbar_tabhost;



import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity implements MenuDialog.OnFragmentInteractionListener {

    Integer month;
    Integer year;
    View [] view_array;
    Menu main_menu;
    private Tabexecution tablistener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablistener = new Tabexecution();
        tablistener.main = this;
        view_array = new View[4];
        Calendar cal = Calendar.getInstance();
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for(int i = 0; i< 4; i++) {
            TextView tw1,tw2;
            ActionBar.Tab tab ;
            view_array[i] = this.getLayoutInflater().inflate(R.layout.tab_layout,null);
            tw1 = (TextView) view_array[i].findViewById(R.id.tab_above);
            tw2 = (TextView) view_array[i].findViewById(R.id.tab_below);
            switch(i)
            {
                case 0: {
                    tw1.setText("thu:");
                    tw2.setText("0");
                    break;
                }
                case 1: {
                    tw1.setText("chi:");
                    tw2.setText("0");
                    break;
                }
                case 2: {
                    tw1.setText("du thang");
                    tw2.setText("0");
                    break;
                }
                case 3: {
                    tw1.setText("du tong:");
                    tw2.setText("0");
                    break;
                }
                default :{
                    Toast.makeText(this.getApplicationContext(),"wrong tab selection",Toast.LENGTH_SHORT);
                }
            }
            tab = bar.newTab().setCustomView(view_array[i]);
            tab.setTabListener(tablistener);
            bar.addTab(tab);
        }
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem it = menu.findItem(R.id.action_month);
        main_menu = menu ;
        String time ;
        time = month.toString() + "/" + year.toString();
        it.setTitle(time);
        Toast.makeText(this.getApplicationContext(),"xem chi tieu thoi gian " + time ,Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        try {
            int id = item.getItemId();
            //noinspection SimplifiableIfStatement
            if (id == R.id.action_next) {
                month++;
                if (month > 11) {
                    month = 0;
                    year++;
                }
                MenuItem it = main_menu.findItem(R.id.action_month);

                String time;
                time = month.toString() + "/" + year.toString();
                it.setTitle(time);
                Toast.makeText(this.getApplicationContext(), "xem chi tieu thoi gian " + time, Toast.LENGTH_LONG).show();
            }
            if (id == R.id.action_previous) {
                month--;
                if (month < 0) {
                    month = 12;
                    year--;
                }
                MenuItem it = main_menu.findItem(R.id.action_month);

                String time;
                time = month.toString() + "/" + year.toString();
                it.setTitle(time);
                Toast.makeText(this.getApplicationContext(), "xem chi tieu thoi gian " + time, Toast.LENGTH_LONG).show();
            }
            if (id == R.id.action_chi) {
                Intent intent = new Intent(this.getApplicationContext(), Chi_activity.class);
                startActivity(intent);
            }
            if (id == R.id.action_menu) {
                MenuDialog dialog = new MenuDialog();
               // dialog.se
                dialog.show(getFragmentManager(),"sample");

            }
            return super.onOptionsItemSelected(item);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
