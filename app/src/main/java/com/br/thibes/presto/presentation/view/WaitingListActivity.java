package com.br.thibes.presto.presentation.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.br.thibes.presto.R;
import com.br.thibes.presto.presentation.model.WaitingItem;
import com.br.thibes.presto.presentation.presenter.WaitingListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WaitingListActivity extends BaseActivity implements WaitingListView {

    @Inject
    WaitingListPresenter waitingListPresenter;

    @BindView(R.id.waiting_list_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        this.recyclerView.setHasFixedSize(true);
        this.waitingListPresenter.create();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.waitingListPresenter.resume();
    }


    @Override
    protected void onPause() {
        this.waitingListPresenter.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        this.waitingListPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void updateItem(WaitingItem item) {

    }

    @Override
    public void updateList(List<WaitingItem> item) {

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
