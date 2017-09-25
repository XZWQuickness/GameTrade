package com.exz.gametrade.gametrade.appclication;


import android.text.TextUtils;

import com.exz.gametrade.gametrade.entity.User;
import com.exz.gametrade.gametrade.utils.LocaleUtils;
import com.exz.gametrade.gametrade.utils.SPutils;
import com.szw.framelibrary.app.MyApplication;

import org.jetbrains.annotations.Nullable;


/**
 * Created by pc on 2017/6/22.
 */

public class App extends MyApplication {
    private static User user;
    @Override
    public void onCreate() {
        super.onCreate();
       init();
        if(!TextUtils.isEmpty(SPutils.getString(getApplicationContext(),"language"))){
            if(SPutils.getString(getApplicationContext(),"language").equals("中文")){
                LocaleUtils.updateLocale(getApplicationContext(), LocaleUtils.LOCALE_CHINESE);//中文
            }else{
                LocaleUtils.updateLocale(getApplicationContext(), LocaleUtils.LOCALE_ENGLISH);//中文
            }
        }
    }

    @Nullable
    @Override
    public String getSaltStr() {
        return "";
    }

    public static boolean checkUserLogin() {
        return user != null && !"".equals(user.getUserId());
    }

    public static String getLoginUserId() {
        return user == null ? "" : user.getUserId();
    }

    public static User getUserInfo() {
        return user == null ? new User() : user;
    }

    public static void setUserInfo(User user) {
        App.user = user;
    }


}
