package com.br.thibes.presto.data;

import com.br.thibes.presto.presentation.model.WaitingItem;

import java.util.List;

import rx.Observable;

public interface WaitingDataRepository {

    Observable<List<WaitingItem>> waitingItemList();

    Observable<WaitingItem> waitingItem(final int itemId);
}
