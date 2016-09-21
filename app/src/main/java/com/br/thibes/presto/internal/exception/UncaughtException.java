package com.br.thibes.presto.internal.exception;

import android.content.Context;
import android.widget.Toast;

import com.br.thibes.presto.internal.log.thibesLog;

public class UncaughtException implements Thread.UncaughtExceptionHandler {

    private final Context context;

    public UncaughtException(Context context) {
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        thibesLog.e("uncaught exception!", e);
        Toast.makeText(context, "CRASHOU!", Toast.LENGTH_LONG);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
