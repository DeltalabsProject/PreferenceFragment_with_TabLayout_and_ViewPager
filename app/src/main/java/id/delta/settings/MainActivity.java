package id.delta.settings;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import id.delta.settings.adapter.SettingsAdapter;
import id.delta.settings.utils.PreferenceUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        PreferenceUtils.dialogOption(this);
    }

    void setupView(){
        //Toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ViewPager
        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SettingsAdapter(getSupportFragmentManager()));
        mPager.setOffscreenPageLimit(3);

        //TabLayout
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mPager);

        //Coloring with Key
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearlayout);
        linearLayout.setBackgroundColor(PreferenceUtils.setWarnaPrimer(this));
        tabs.setSelectedTabIndicatorColor(PreferenceUtils.setWarnaAksen(this));

        //Coloring StatusBar Lolipop Up
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(PreferenceUtils.setWarnaPrimer(this));
        }

        // Themming App
        PreferenceUtils.applyTheme(this);
    }
}
