package com.br.thibes.presto.internal.di.components;

import android.content.Context;

import com.br.thibes.presto.internal.di.modules.ApplicationModule;
import com.br.thibes.presto.internal.executor.PostExecutionThread;
import com.br.thibes.presto.internal.executor.ThreadExecutor;
import com.br.thibes.presto.presentation.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();
    //WaitingDataRepository userRepository();
}