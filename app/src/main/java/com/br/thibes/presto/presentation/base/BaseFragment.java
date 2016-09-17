package com.br.thibes.presto.presentation.base;

import android.app.Fragment;
import android.widget.Toast;

import com.br.thibes.presto.internal.di.HasComponent;

public abstract class BaseFragment extends Fragment {

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

}