package com.br.thibes.presto.presentation.presenter;

import com.br.thibes.presto.presentation.model.WaitingItem;

public interface IWaitingListPresenter extends BasePresenter {
    void refresh();

    void addNew();

    void itemClick(WaitingItem item);
}
