package com.br.thibes.presto.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.br.thibes.presto.R;
import com.br.thibes.presto.internal.di.components.WaitingListComponent;
import com.br.thibes.presto.presentation.adapter.RecyclerAdapter;
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
    @BindView(R.id.waiting_list_progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.waiting_list_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.waiting_list_new_fab)
    FloatingActionButton newItemFab;
    @BindView(R.id.waiting_list_refresh_fab)
    FloatingActionButton refreshListFab;
    @BindView(R.id.waiting_list_error_message)
    TextView errorTextView;
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
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        this.waitingListPresenter.create();
        this.waitingListPresenter.setView(this);
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
    public void updateList(List<WaitingItem> items) {
        RecyclerAdapter adapter = new RecyclerAdapter(items);
        this.recyclerView.setAdapter(adapter);
        //this.recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        recyclerView.setVisibility(View.GONE);
        newItemFab.setVisibility(View.GONE);
        refreshListFab.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        recyclerView.setVisibility(View.VISIBLE);
        newItemFab.setVisibility(View.VISIBLE);
        refreshListFab.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        recyclerView.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRefresh() {
        refreshListFab.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRefresh() {
        refreshListFab.setVisibility(View.GONE);
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
