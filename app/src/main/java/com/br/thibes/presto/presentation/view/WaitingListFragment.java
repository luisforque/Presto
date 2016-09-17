package com.br.thibes.presto.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.thibes.presto.R;
import com.br.thibes.presto.internal.di.components.WaitingListComponent;
import com.br.thibes.presto.presentation.base.BaseFragment;
import com.br.thibes.presto.presentation.model.WaitingItem;
import com.br.thibes.presto.presentation.presenter.WaitingListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class WaitingListFragment extends BaseFragment implements WaitingListView {

    @Inject
    WaitingListPresenter waitingListPresenter;
    @BindView(R.id.waiting_list_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.waiting_list_new_fab)
    FloatingActionButton newItemFab;
    @BindView(R.id.waiting_list_refresh_fab)
    FloatingActionButton refreshListFab;
    private Unbinder butterKnifeUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getComponent(WaitingListComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_waiting_list, container, false);

        this.butterKnifeUnbinder = ButterKnife.bind(this, fragmentView);

        this.recyclerView.setHasFixedSize(true);
        this.waitingListPresenter.create();
        return fragmentView;
    }

    @Override
    public void onDestroyView() {
        this.butterKnifeUnbinder.unbind();
        // TODO destroy recycler view?
        //this.recyclerView.setAdapter(null);
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.waitingListPresenter.resume();
    }

    @Override
    public void onPause() {
        this.waitingListPresenter.pause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        this.waitingListPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void updateItem(WaitingItem item) {

    }

    @Override
    public void updateList(List<WaitingItem> item) {
        this.recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }

    @OnClick(R.id.waiting_list_refresh_fab)
    public void onRefreshClicked() {
        waitingListPresenter.refresh();
    }

    @OnClick(R.id.waiting_list_new_fab)
    public void onNewClicked() {
        waitingListPresenter.addNew();
    }
}
