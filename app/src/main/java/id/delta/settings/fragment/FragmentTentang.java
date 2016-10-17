package id.delta.settings.fragment;

import android.os.Bundle;

import com.github.machinarius.preferencefragment.PreferenceFragment;

import id.delta.settings.R;

/**
 * Created by Administrator on 10/17/16.
 */

public class FragmentTentang extends PreferenceFragment {

    @Override
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.about_settings);
    }
}
