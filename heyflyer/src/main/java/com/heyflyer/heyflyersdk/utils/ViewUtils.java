package com.heyflyer.heyflyersdk.utils;


import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.heyflyer.heyflyersdk.R;
import java.util.regex.Pattern;


public class ViewUtils {
    private static Toast mToast;
  //  private static ChooseMediaListner mediaListner;

    @NonNull
    private static String strPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(strPattern);

    @NonNull
    private static String pwdPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{6,}";

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(pwdPattern);
    private static ProgressDialog progress;
    private static double EQUATOR_LENGTH = 6378140;



    public static void showToast(Context mContext, String message, int length) {
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(mContext, message, length);
        mToast.show();
    }

    public static void showToast(Context mContext, String message, String key, int length) {
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(mContext, message, length);
        mToast.show();
    }


    public static void statusBarHide(Activity activity) {
        if (Build.VERSION.SDK_INT < 16) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = activity.getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    public static boolean checkEmail(@Nullable String strEmail) {
        try {
            if (strEmail != null) {

           //     LOGD("UTILS :", "checkEmail() ==> EMAIL :" + strEmail);
           //     LOGD("UTILS :", "checkEmail() ==> " + EMAIL_ADDRESS_PATTERN.matcher(strEmail).matches());
                return EMAIL_ADDRESS_PATTERN.matcher(strEmail).matches();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String checkNull(String key) {

        String result = "";
        if (key != null) {
            return key.equalsIgnoreCase("null") ? "" : key;
        }
        return result;
    }

    public static boolean checkPassword(@Nullable String strPwd) {
        try {
            if (strPwd != null) {


               // LOGD("UTILS :", "checkPassword() ==> PASSWORD :" + strPwd);
                return PASSWORD_PATTERN.matcher(strPwd).matches();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }





    public static void showAlert(Context context, String title, String message, String btnText) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(btnText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        alertDialog.show();
    }

    public static void showDialog(Context context, boolean isDismiss) {
        try {
            if (isDismiss) {
                if (progress != null && progress.isShowing()) {
                    progress.dismiss();
                    progress = null;
                }
            } else {
                if (progress != null && progress.isShowing()) {
                    progress.dismiss();
                    progress = null;
                }
                progress = new ProgressDialog(context);
                progress.setMessage("Please wait..");
                progress.setCanceledOnTouchOutside(false);
                progress.setCancelable(false);
                progress.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


































    public static String device_id(Activity mActivity) {
        return Settings.Secure.getString(mActivity.getContentResolver(), Settings.Secure.ANDROID_ID);
    }












    public static boolean isAppForground(Context context) {
        try {
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            //The first in the list of RunningTasks is always the foreground task.
            ActivityManager.RunningTaskInfo foregroundTaskInfo = am.getRunningTasks(1).get(0);

            String foregroundTaskPackageName = foregroundTaskInfo.topActivity.getPackageName();
            PackageManager pm = context.getPackageManager();
            PackageInfo foregroundAppPackageInfo;

            foregroundAppPackageInfo = pm.getPackageInfo(foregroundTaskPackageName, 0);
            String foregroundTaskAppName = foregroundAppPackageInfo.applicationInfo.loadLabel(pm).toString();

            return foregroundTaskAppName.equalsIgnoreCase(context.getResources().getString(R.string.app_name));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
