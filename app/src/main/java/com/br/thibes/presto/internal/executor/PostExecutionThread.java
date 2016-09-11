package com.br.thibes.presto.internal.executor;

import rx.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}
