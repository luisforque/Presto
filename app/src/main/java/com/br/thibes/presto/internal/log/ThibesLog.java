package com.br.thibes.presto.internal.log;

import com.br.thibes.presto.BuildConfig;

public class thibesLog {

    private final static boolean enabled = BuildConfig.DEBUG;
    private final static String tag = "THIBES";

    public static void d(String log) {
        if (enabled)
            android.util.Log.d(tag, log);
    }

    public static void e(String log, Throwable e) {
        if (enabled)
            android.util.Log.e(tag, log, e);
    }

    public static void e(String log, Exception e) {
        if (enabled)
            android.util.Log.e(tag, log, e);
    }
}
