package com.br.thibes.presto.presentation.presenter;

import android.app.Activity;

import com.br.thibes.presto.internal.subscription.DefaultSubscriber;
import com.br.thibes.presto.presentation.model.WaitingItem;

public class WaitingListPresenter extends DefaultSubscriber<WaitingItem> implements BasePresenter {

    @Override
    public void setView(Activity view) {

    }

    @Override
    public void create() {

    }

    @Override
    public void resume() {

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
}
