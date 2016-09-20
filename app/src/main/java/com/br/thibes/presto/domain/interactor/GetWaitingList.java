package com.br.thibes.presto.domain.interactor;

import com.br.thibes.presto.data.WaitingDataRepository;
import com.br.thibes.presto.internal.executor.PostExecutionThread;
import com.br.thibes.presto.internal.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

public class GetWaitingList extends UseCase {

    private final WaitingDataRepository waitingDataRepository;

    @Inject
    public GetWaitingList(WaitingDataRepository waitingDataRepository, ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.waitingDataRepository = waitingDataRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return waitingDataRepository.waitingItemList();
    }
}
