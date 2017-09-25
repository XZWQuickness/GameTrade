package com.exz.gametrade.gametrade.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;

import com.yanzhenjie.permission.AndPermission;

import me.drakeet.materialdialog.MaterialDialog;

import static android.Manifest.permission.CALL_PHONE;

/**
 * Created by pc on 2017/3/29.
 */

public class MaterialDialogUtils {
    public static MaterialDialog dialog;

    public static void Call(final Context c, final String number) {
        dialog = new MaterialDialog(c);
        dialog.setTitle("拨打电话").setMessage("号码:" + number).setPositiveButton("立即拨打", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        Intent.ACTION_CALL,
                        Uri.parse("tel:" + number));

                if (ActivityCompat.checkSelfPermission(c, CALL_PHONE) != PackageManager
                        .PERMISSION_GRANTED) {
                    // 申请权限。
                    Log.i("Tag", "申请权限.");
                    AndPermission.with(c)
                            .requestCode(200)
                            .permission(CALL_PHONE)
                            .send();
                    return;
                }
                c.startActivity(intent);
                dialog.dismiss();
            }
        })
                .setNegativeButton("稍后拨打", new View
                        .OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    public static void Warning(final Activity c, final String title, String message,
                               View.OnClickListener mOnClickListener) {
        dialog = new MaterialDialog(c);
        dialog.setTitle(title).setMessage(message).setPositiveButton("确定", mOnClickListener)
                .setNegativeButton("取消", new View
                        .OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    public static void Warning(final Activity c, final String title, String message, String
            negativeMsg, String positiveMsg,
                               View.OnClickListener mOnClickListener) {
        dialog = new MaterialDialog(c);
        dialog.setTitle(title).setMessage(message).setPositiveButton(positiveMsg, mOnClickListener)
                .setNegativeButton(negativeMsg, new View
                        .OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    public static void Warning(final Context c, final String title, View.OnClickListener onClickListener) {
        dialog = new MaterialDialog(c);
        dialog.setTitle(title).setMessage(title).setPositiveButton("确定",onClickListener)
                .setNegativeButton("取消", new View
                        .OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    public static void toast(final Context c, final String title) {
        dialog = new MaterialDialog(c);
        dialog.setMessage(title).setPositiveButton("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    /**
     * @param c 上下文
     * @param v 布局
     * @param onClickListener
     */
    public static void way(final Context c, View v, View.OnClickListener
            onClickListener) {
        dialog = new MaterialDialog(c);
        dialog.setContentView(v);
        dialog.setPositiveButton("确定", onClickListener)
                .setNegativeButton("取消", new View
                        .OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

}
