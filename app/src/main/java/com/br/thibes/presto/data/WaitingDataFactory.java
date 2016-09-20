package com.br.thibes.presto.data;

import com.br.thibes.presto.presentation.model.WaitingItem;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class WaitingDataFactory implements WaitingDataRepository {
    @Override
    public Observable<List<WaitingItem>> waitingItemList() {
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
        return null;
    }
}
