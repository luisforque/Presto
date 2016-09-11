package com.br.thibes.presto.internal.di;

import android.content.Context;

import com.br.thibes.presto.internal.executor.PostExecutionThread;
import com.br.thibes.presto.internal.executor.ThreadExecutor;
import com.br.thibes.presto.presentation.view.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();
    //UserRepository userRepository();
}