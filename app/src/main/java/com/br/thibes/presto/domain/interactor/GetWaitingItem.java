package com.br.thibes.presto.domain.interactor;

import com.br.thibes.presto.data.WaitingDataRepository;
import com.br.thibes.presto.internal.executor.PostExecutionThread;
import com.br.thibes.presto.internal.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

public class GetWaitingItem extends UseCase {

    private final int itemId;
    private final WaitingDataRepository waitingDataRepository;

    @Inject
    public GetWaitingItem(int itemId, WaitingDataRepository waitingDataRepository, ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.waitingDataRepository = waitingDataRepository;
        this.itemId = itemId;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return waitingDataRepository.waitingItem(this.itemId);
    }
}
