package com.br.thibes.presto.internal.di.components;

import android.app.Activity;

import com.br.thibes.presto.internal.di.PerActivity;
import com.br.thibes.presto.internal.di.modules.ActivityModule;
import com.br.thibes.presto.internal.di.modules.PresenterModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, PresenterModule.class})
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}