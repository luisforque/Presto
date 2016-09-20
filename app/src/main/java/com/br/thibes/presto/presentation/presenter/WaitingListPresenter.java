package com.br.thibes.presto.presentation.presenter;

import com.br.thibes.presto.domain.interactor.UseCase;
import com.br.thibes.presto.internal.subscription.DefaultSubscriber;
import com.br.thibes.presto.presentation.base.BaseFragment;
import com.br.thibes.presto.presentation.model.WaitingItem;
import com.br.thibes.presto.presentation.view.WaitingListFragment;

import java.util.List;

import javax.inject.Named;

public class WaitingListPresenter extends DefaultSubscriber<WaitingItem> implements IWaitingListPresenter {

    private final UseCase getWaitingListUseCase;
    private WaitingListFragment view;

    public WaitingListPresenter(@Named("waitingList") UseCase getWaitingListUseCase) {
        this.getWaitingListUseCase = getWaitingListUseCase;
    }

    @Override
    public void setView(BaseFragment view) {
        this.view = (WaitingListFragment) view;
    }

    @Override
    public void create() {

    }

    @Override
    public void resume() {
        view.showLoading();
        getWaitingListUseCase.execute(new WaitingListSubscriber());
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
    }

    @Override
    public void onCompleted() {
        super.onCompleted();
    }

    @Override
    public void onNext(WaitingItem waitingItem) {
        super.onNext(waitingItem);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void refresh() {

    }

    @Override
    public void addNew() {

    }

    @Override
    public void itemClick(WaitingItem item) {

    }

    private final class WaitingListSubscriber extends DefaultSubscriber<List<WaitingItem>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            WaitingListPresenter.this.view.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            WaitingListPresenter.this.view.hideLoading();
            WaitingListPresenter.this.view.showError();
        }

        @Override
        public void onNext(List<WaitingItem> waitingItems) {
            super.onNext(waitingItems);
            WaitingListPresenter.this.view.updateList(waitingItems);
        }
    }
}
