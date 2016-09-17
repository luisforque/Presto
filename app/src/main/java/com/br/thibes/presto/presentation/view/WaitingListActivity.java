package com.br.thibes.presto.presentation.view;

import android.os.Bundle;

import com.br.thibes.presto.R;
import com.br.thibes.presto.internal.di.HasComponent;
import com.br.thibes.presto.internal.di.components.DaggerWaitingListComponent;
import com.br.thibes.presto.internal.di.components.WaitingListComponent;
import com.br.thibes.presto.internal.di.modules.WaitingListModule;
import com.br.thibes.presto.presentation.base.BaseActivity;

import butterknife.ButterKnife;

public class WaitingListActivity extends BaseActivity implements HasComponent<WaitingListComponent> {

    private WaitingListComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        this.initializeInjector();

        addFragment(R.id.waiting_list_fragment_container, new WaitingListFragment());
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initializeInjector() {
        this.userComponent = DaggerWaitingListComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .presenterModule(getPresenterModule())
                .waitingListModule(new WaitingListModule())
                .build();
    }

    @Override
    public WaitingListComponent getComponent() {
        return userComponent;
    }

}
