package com.br.thibes.presto.presentation.view;

import com.br.thibes.presto.presentation.model.WaitingItem;

import java.util.List;

public interface WaitingListView extends AsyncDataView {
    void updateItem(WaitingItem item);

    void updateList(List<WaitingItem> item);
}
