package com.br.thibes.presto.internal.di.components;

import com.br.thibes.presto.domain.interactor.UseCase;
import com.br.thibes.presto.internal.di.PerActivity;
import com.br.thibes.presto.internal.di.modules.ActivityModule;
import com.br.thibes.presto.internal.di.modules.PresenterModule;
import com.br.thibes.presto.internal.di.modules.WaitingListModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules =
        {ActivityModule.class, WaitingListModule.class, PresenterModule.class})
public interface WaitingListComponent extends ActivityComponent {
    // TODO change the abstract for the real one
    void inject(UseCase userListFragment);

    //void inject(UseCase userDetailsFragment);
}
