package com.example.tvu.actionbar_tabhost;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.widget.Toast;
import android.os.Bundle;

/**
 * Created by tvu on 5/7/15.
 */
public class Tabexecution implements ActionBar.TabListener {
    MainActivity main;

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
           Toast.makeText(main.getApplicationContext(),Integer.toString(tab.getPosition()),Toast.LENGTH_LONG);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }


}
