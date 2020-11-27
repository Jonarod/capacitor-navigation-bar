package com.jonarod.capacitor.NavigationBar;

import android.app.Activity;
import android.graphics.Color;
import android.view.Window;
import android.view.View;
import android.view.WindowManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin
public class NavigationBar extends Plugin {

    @PluginMethod()
    public void set(PluginCall call) {

        String bgColor = call.getString("bgColor");

        if(bgColor == null || bgColor.equals("") || !bgColor.contains("#")){
            call.error("Backgroud color cannot be empty or null. It should be a hex value, eg: #d1009d");
        }

        /**
        * Set android navigation bar background and buttons colors
        */
        try{
            final int parsedBgColor = Color.parseColor(bgColor);
            final Window window = ((Activity) getContext()).getWindow();

            // only update views on ui thread
            //  getActivity().runOnUiThread(new Runnable() {
            //      @Override
            //      public void run() {
            //          window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //          window.setNavigationBarColor(parsedBgColor);
            //          window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
            //      }
            //  });


        } catch (Exception e){
            call.error(e.toString());
        }

        call.success();

    }

}