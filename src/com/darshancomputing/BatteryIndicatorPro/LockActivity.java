/*
    Copyright (c) 2014 Darshan-Josiah Barber

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
*/

package com.darshancomputing.BatteryIndicatorPro;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LockActivity extends Activity {
    private SharedPreferences settings;
    private SharedPreferences sp_store;

    private LayoutInflater mInflater;

    private Resources res;
    private Context context;

    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.home);

        res = getResources();
        context = getApplicationContext();
        settings = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNav();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideNav();
        }
    }

    public void hideNav() {
        getWindow().getDecorView().setSystemUiVisibility(
                                                         View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                                         | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                                         //| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                                         | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                                         //| View.SYSTEM_UI_FLAG_FULLSCREEN
                                                         | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                                         );
    }
}
