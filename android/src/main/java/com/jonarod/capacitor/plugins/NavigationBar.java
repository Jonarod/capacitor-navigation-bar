package com.jonarod.capacitor.plugins;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import android.app.Activity;
import android.graphics.Color;
import android.view.Window;
import android.view.View;
import android.view.WindowManager;

@NativePlugin
public class NavigationBar extends Plugin {
    private String TAG = "capacitor-navigation-bar";

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.success(ret);
    }


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

             getActivity().runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                     window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                     window.setNavigationBarColor(parsedBgColor);
                     window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
                 }
             });

        } catch (Exception e){
            call.error(e.toString());
        }

        call.success();
    }

}
