package com.courtyardyearproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.app.Activity
import android.preference.PreferenceFragment

class SettingsActivity : Activity(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        if (savedInstanceState == null) {
            fragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.root_preferences)
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == "capture_time") {
            if (CaptureService.isServiceRunning) {
                val intent = Intent(this, CaptureService::class.java)
                stopService(intent)
                startService(intent)
            }
        }
    }
}
