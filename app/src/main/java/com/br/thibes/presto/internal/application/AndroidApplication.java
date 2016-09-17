package com.br.thibes.presto.internal.application;

import android.app.Application;

import com.br.thibes.presto.BuildConfig;
import com.br.thibes.presto.internal.analytics.AnalyticsTrackers;
import com.br.thibes.presto.internal.di.components.ApplicationComponent;
import com.br.thibes.presto.internal.di.components.DaggerApplicationComponent;
import com.br.thibes.presto.internal.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
        this.initializeAnalytics();
    }

    private void initializeAnalytics() {
        AnalyticsTrackers.initialize(this);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}