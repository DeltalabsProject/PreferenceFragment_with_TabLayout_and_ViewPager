package id.delta.settings.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.machinarius.preferencefragment.PreferenceFragment;

import id.delta.settings.R;

/**
 * Created by Administrator on 10/17/16.
 */

public class FragmentWarna extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.color_settings);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case "key_warna_primer":
                getActivity().recreate();
            case "key_warna_aksen":
                getActivity().recreate();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
