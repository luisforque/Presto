package com.br.thibes.presto.presentation.presenter;

import com.br.thibes.presto.presentation.base.BaseFragment;

public interface BasePresenter {
    void setView(BaseFragment view);

    void create();

    void resume();

    void pause();

    void destroy();
}
