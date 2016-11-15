package com.test.linkedin.utils;

import android.content.Context;
import android.widget.Toast;

import com.test.linkedin.R;

/**
 * Created by chris on 11/14/16.
 * This handles toasters and general alerts
 */

public class AlertUtils {

    /**
     * Show a toaster witht message
     * @param con
     * @param message
     */
    public static void showToaster(Context con, String message) {

        Toast toast = Toast.makeText(con, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
