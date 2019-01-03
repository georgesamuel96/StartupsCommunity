package com.example.georgesamuel.egyptianstartups;

import android.support.v4.app.Fragment;

public class TabMessage {

    public static String get(int menuItemId, boolean isReselection) {
        String message = "Content for ";

        switch (menuItemId) {
            case R.id.tab_home:
                message += "Home";
                break;
            case R.id.tab_search:
                message += "Search";
                break;
            case R.id.tab_account:
                message += "Account";
                break;

        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;


    }

}
