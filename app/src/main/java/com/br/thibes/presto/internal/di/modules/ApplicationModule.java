package com.br.thibes.presto.internal.di.modules;

import android.content.Context;

import com.br.thibes.presto.internal.application.AndroidApplication;
import com.br.thibes.presto.internal.executor.JobExecutor;
import com.br.thibes.presto.internal.executor.PostExecutionThread;
import com.br.thibes.presto.internal.executor.ThreadExecutor;
import com.br.thibes.presto.internal.executor.UIThread;
import com.br.thibes.presto.internal.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

//    @Provides
//    @Singleton
//    UserCache provideUserCache(UserCacheImpl userCache) {
//        return userCache;
//    }
//
//    @Provides
//    @Singleton
//    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
//        return userDataRepository;
//    }
}