package id.delta.settings.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;

import id.delta.settings.utils.PreferenceUtils;

/**
 * Created by Administrator on 10/17/16.
 */

public class SwitchView extends SwitchCompat{
    public SwitchView(Context context) {
        super(context);
        setChecked(isChecked());
    }

    public SwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setChecked(isChecked());
    }

    public SwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setChecked(isChecked());
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        changeColor(checked);
    }

    private void changeColor(boolean isChecked) {
        if (Build.VERSION.SDK_INT >= 16) {
            int thumbColor;
            int trackColor;

            if(isChecked) {
                thumbColor = PreferenceUtils.setWarnaAksen(getContext());
                trackColor = 80 * 0x01000000;
            } else {
                thumbColor = Color.argb(255, 236, 236, 236);
                trackColor = 0xff9e9e9e;
            }

            try {
                getThumbDrawable().setColorFilter(thumbColor, PorterDuff.Mode.MULTIPLY);
                getTrackDrawable().setColorFilter(trackColor+thumbColor, PorterDuff.Mode.MULTIPLY);

            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

}
