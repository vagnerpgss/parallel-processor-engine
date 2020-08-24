package com.vagnerpgss.service;

import com.vagnerpgss.job.DefaultJob;
import com.vagnerpgss.job.result.JobResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public abstract class ConsumerProducerAbstractService implements ConsumerProducerService {

    List<DefaultJob> jobs = new ArrayList<DefaultJob>();
    ExecutorService threadPool = Executors.newCachedThreadPool();
    CompletionService<JobResult> service = new ExecutorCompletionService<JobResult>(threadPool);

}