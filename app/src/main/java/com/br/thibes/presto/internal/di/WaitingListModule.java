package com.br.thibes.presto.internal.di;

import com.br.thibes.presto.domain.interactor.UseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class WaitingListModule {
    // TODO change abstract class use case to use its children
    @Provides
    @PerActivity
    UseCase provideGetUserListUseCase(UseCase getUserListUseCase) {
        return getUserListUseCase;
    }

    @Provides
    @PerActivity
    UseCase provideGetUserDetailsUseCase(UseCase getUserDetailsUseCase) {
        return getUserDetailsUseCase;
    }
}
