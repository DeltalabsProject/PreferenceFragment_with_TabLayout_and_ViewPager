package id.delta.settings.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.delta.settings.fragment.FragmentTema;
import id.delta.settings.fragment.FragmentTentang;
import id.delta.settings.fragment.FragmentWarna;

/**
 * Created by Administrator on 10/17/16.
 */

public class SettingsAdapter extends FragmentStatePagerAdapter {

    public SettingsAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment=new FragmentTema();
                break;
            case 1:
                fragment=new FragmentWarna();
                break;
            case 2:
                fragment=new FragmentTentang();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="THEME";
                break;
            case 1:
                title="COLOR";
                break;
            case 2:
                title="ABOUT";
                break;
        }

        return title;
    }
}
