package com.chenggong.navigation.utils;

import android.util.Log;

import com.chenggong.navigation.BuildConfig;

/**
 * Created by chenggong on 18-10-2.
 */

public final class LogUtil {
    private static final int STACK_DEPTH = 4;
    private static LogUtil mInstance;

    public static LogUtil getInstance() {
        if (mInstance == null) {
            mInstance = new LogUtil();
        }
        return mInstance;
    }

    public void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, buildMsg(msg));
        }
    }

    /**
     * 输出的日志信息带有下划线
     */
    public void nav(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, buildNavigationMsg(msg));
        }
    }

    /**
     * 构造日志信息
     *
     * @param msg
     * @return
     */
    private static String buildMsg(String msg) {
        StringBuffer buffer = new StringBuffer();
        StackTraceElement traceElement = Thread.currentThread().getStackTrace()[STACK_DEPTH];
        buffer.append("[").append(traceElement.getFileName());
        buffer.append(":").append(traceElement.getLineNumber()).append("] ");
        buffer.append(msg);
        return buffer.toString();
    }

    /**
     * 构造可以导航到代码的日志
     *
     * @param msg
     * @return
     */
    private static String buildNavigationMsg(String msg) {
        StringBuffer buffer = new StringBuffer();
        StackTraceElement traceElement = Thread.currentThread().getStackTrace()[STACK_DEPTH];
        buffer.append("(").append(traceElement.getFileName());
        buffer.append(":").append(traceElement.getLineNumber()).append(") ");
        buffer.append(msg);
        return buffer.toString();
    }
}
