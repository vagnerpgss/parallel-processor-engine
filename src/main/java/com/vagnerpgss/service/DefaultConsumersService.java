package com.vagnerpgss.service;

import com.vagnerpgss.job.DefaultJob;
import com.vagnerpgss.job.result.JobResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class DefaultConsumersService extends ConsumerProducerAbstractService {

    public void produce(DefaultJob producer) {
        jobs.add(producer);
    }

    public void consume () {
        for (final Callable<JobResult> callable : this.jobs) {
            service.submit(callable);
        }
        threadPool.shutdown();
        try {
            while (!threadPool.isTerminated()) {
                final Future<JobResult> future = service.take();
                System.out.println(future.get());
            }
        } catch (ExecutionException | InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}