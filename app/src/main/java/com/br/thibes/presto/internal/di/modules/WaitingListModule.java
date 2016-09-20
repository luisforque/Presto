package com.br.thibes.presto.internal.di.modules;

import com.br.thibes.presto.domain.interactor.GetWaitingItem;
import com.br.thibes.presto.domain.interactor.GetWaitingList;
import com.br.thibes.presto.domain.interactor.UseCase;
import com.br.thibes.presto.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class WaitingListModule {
    public WaitingListModule() {
    }

    @Provides
    @PerActivity
    @Named("waitingList")
    UseCase provideGetWaitingListUseCase(GetWaitingList getWaitingListUseCase) {
        return getWaitingListUseCase;
    }

    @Provides
    @PerActivity
    @Named("waitingItem")
    UseCase provideGetUserDetailsUseCase(GetWaitingItem getWaitingItemUseCase) {
        return getWaitingItemUseCase;
    }
}
