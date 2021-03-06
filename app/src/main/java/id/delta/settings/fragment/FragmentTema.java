package id.delta.settings.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;

import com.github.machinarius.preferencefragment.PreferenceFragment;

import id.delta.settings.R;

/**
 * Created by Administrator on 10/17/16.
 */

public class FragmentTema extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{
    // PreferenceFragment di sini menggunakan PreferenceFragment yang dari https://github.com/Machinarius/PreferenceFragment-Compat
    @Override
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.theme_settings);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case "key_tema":
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
