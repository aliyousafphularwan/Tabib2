package com.persol.tabib;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class UserSession {

    SharedPreferences preferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LOGIN";
    public static final String USER = "USER";

    public UserSession(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void createSession(String username){

        editor.putBoolean(PREF_NAME, true);
        editor.putString(USER, username);
        editor.apply();

    }

    public boolean isLogin(){
        return preferences.getBoolean(PREF_NAME, false);
    }

    public void checkLogin(){

        if (!this.isLogin()){

            context.startActivity(new Intent(context, LoginActivity.class));
            ((DashboardActivity) context).finish();

        }
    }

    public HashMap<String, String> getUserDetails(){

        HashMap<String, String> user = new HashMap<>();

        user.put(USER, preferences.getString(USER, null));

        return user;

    }

    public void logout(){

        editor.clear();
        editor.commit();

        context.startActivity(new Intent(context, LoginActivity.class));
        ((DashboardActivity) context).finish();

    }

}
