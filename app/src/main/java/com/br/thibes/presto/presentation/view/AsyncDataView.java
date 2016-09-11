package com.br.thibes.presto.presentation.view;

public interface AsyncDataView {
    void showLoading();

    void hideLoading();

    void showError();

    void showRefresh();

    void hideRefresh();
}
