package com.br.thibes.presto.presentation.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.br.thibes.presto.internal.application.AndroidApplication;
import com.br.thibes.presto.internal.di.components.ApplicationComponent;
import com.br.thibes.presto.internal.di.modules.ActivityModule;
import com.br.thibes.presto.internal.di.modules.PresenterModule;
import com.br.thibes.presto.internal.navigator.Navigator;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected PresenterModule getPresenterModule() {
        return new PresenterModule();
    }
}
