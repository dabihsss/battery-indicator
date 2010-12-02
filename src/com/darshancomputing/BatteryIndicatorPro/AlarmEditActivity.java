/*
    Copyright (c) 2010 Josiah Barber (aka Darshan)

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

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;

public class AlarmEditActivity extends PreferenceActivity implements OnPreferenceChangeListener {
    private Resources res;
    private Context context;
    private Str str;
    private PreferenceScreen mPreferenceScreen;
    private int alarmID;

    public static final String EXTRA_ALARM_ID = "com.darshancomputing.BatteryIndicatorPro.AlarmID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getApplicationContext();
        res = getResources();
        str = new Str(res);

        Intent intent = getIntent();
        alarmID = intent.getIntExtra(EXTRA_ALARM_ID, -1);

        addPreferencesFromResource(R.xml.alarm_pref_screen);

        mPreferenceScreen = getPreferenceScreen();
        setOnPreferenceChangeListeners(mPreferenceScreen);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setWindowSubtitle(String subtitle) {
        setTitle(res.getString(R.string.app_full_name) + " - " + subtitle);
    }

    private void setOnPreferenceChangeListeners(Preference p) {
        if (p instanceof PreferenceGroup) {
            PreferenceGroup pg = (PreferenceGroup) p;

            for (int i=0, count = pg.getPreferenceCount(); i < count; i++)
                setOnPreferenceChangeListeners(pg.getPreference(i));
        } else {
            p.setOnPreferenceChangeListener(this);
        }
    }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return true;
    }
}