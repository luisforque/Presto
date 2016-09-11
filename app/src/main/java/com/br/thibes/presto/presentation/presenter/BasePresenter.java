package com.br.thibes.presto.presentation.presenter;

import android.app.Activity;

public interface BasePresenter {
    void setView(Activity view);

    void create();

    void resume();

    void pause();

    void destroy();
}
