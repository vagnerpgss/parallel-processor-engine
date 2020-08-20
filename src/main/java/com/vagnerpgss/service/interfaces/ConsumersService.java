package com.vagnerpgss.service.interfaces;

import com.vagnerpgss.job.Job;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public interface ConsumersService {

    AtomicInteger done = new AtomicInteger();
    Collection<Runnable> jobs = null;

    default void produce(Job job) {
        jobs.add(new Thread(job));
    }

    default void consume() {
        System.out.println(String.format("Starting %d consumers ...", jobs.size()));
        long startTime = System.currentTimeMillis();
        for (Runnable consumer : jobs) {
            consumer.run();
        }
        System.out.println(String.format("%d consumers started!", jobs.size()));
        while (done.get() != jobs.size()) {
            try {
                System.out.println("Waiting the end of the Threads... Total fineshed: " + done.get());
                Thread.sleep(TimeUnit.SECONDS.toMillis(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("DONE, Time: " + (System.currentTimeMillis() - startTime));
    }

}