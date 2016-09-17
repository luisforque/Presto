package com.br.thibes.presto.presentation.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.br.thibes.presto.R;
import com.br.thibes.presto.presentation.base.BaseFragment;
import com.br.thibes.presto.presentation.model.WaitingItem;
import com.br.thibes.presto.presentation.presenter.WaitingListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class WaitingListFragment extends BaseFragment implements WaitingListView {

    @Inject
    WaitingListPresenter waitingListPresenter;

    @BindView(R.id.waiting_list_recycler_view)
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.recyclerView.setHasFixedSize(true);
        this.waitingListPresenter.create();
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
}
