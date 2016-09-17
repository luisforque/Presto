package com.br.thibes.presto.internal.di.modules;

import com.br.thibes.presto.internal.di.PerActivity;
import com.br.thibes.presto.presentation.presenter.WaitingListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    public PresenterModule() {
    }

    @Provides
    @PerActivity
    WaitingListPresenter provideWaitingListPresenter() {
        return new WaitingListPresenter();
    }
}
