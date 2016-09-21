package com.br.thibes.presto.data;

import com.br.thibes.presto.internal.log.thibesLog;
import com.br.thibes.presto.presentation.model.WaitingItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class WaitingDataFactory implements WaitingDataRepository {

    @Inject
    public WaitingDataFactory() {
        thibesLog.d("entrei na factory");
    }

    @Override
    public Observable<List<WaitingItem>> waitingItemList() {
        thibesLog.d("waiting list item");
        ArrayList<WaitingItem> items = new ArrayList<>();
        items.add(new WaitingItem("Itau", "2 horas"));
        items.add(new WaitingItem("Correios", "15 segundos"));
        items.add(new WaitingItem("Santander", "20 minutos"));
        items.add(new WaitingItem("Outback", "5 horas"));
        return Observable.create(subscriber -> {
            subscriber.onStart();
            subscriber.onNext(items);
            subscriber.onCompleted();
        });
    }

    @Override
    public Observable<WaitingItem> waitingItem(int itemId) {
        thibesLog.d("waiting item");
        return null;
    }
}
