package id.delta.settings.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on 10/17/16.
 */

public class PreferenceUtils {

    private PreferenceUtils(){}

    public static int setResources (String string, String string2, Context context){
        return context.getResources().getIdentifier(string, string2, context.getPackageName());
    }

    public static void dialogOption(final Activity activity){
        Context context = activity;
        if (!Boolean.valueOf((boolean) PreferenceManager.getDefaultSharedPreferences(context).getBoolean("disable_dialog_key", false)).booleanValue()) {
            return;
        }else{
            tampilkanDialog(activity);
        }
    }

    public static void tampilkanDialog(final Activity activity){

        final AlertDialog.Builder adb = new AlertDialog.Builder(activity);
        LayoutInflater adbInflater = LayoutInflater.from(activity);
        View view = adbInflater.inflate(setResources("dialog_about", "layout", activity), null);
        adb.setView(view);
        adb.show();

    }

    public static int setWarnaPrimer (Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt("key_warna_primer", 0xff3F51B5);
    }

    public static int setWarnaAksen (Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt("key_warna_aksen", 0x80ffffff);
    }

    public static int listTheme (Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int n = Integer.parseInt((String) preferences.getString("key_tema", "0"));
        if (n == 0) {
            return setResources("AppTheme","style", context);
        }
        if (n == 1) {
            return setResources("DarkTheme", "style", context);
        }
        if (n == 2) {
            return setResources("TransparentTheme", "style", context);
        }
        return n;
    }

    public static void applyTheme(Activity activity) {
        int themeId = listTheme(activity);
        activity.setTheme(themeId);
    }
}
