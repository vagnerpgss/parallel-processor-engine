package com.vagnerpgss.job;

import com.vagnerpgss.job.result.DefaultJobResult;
import com.vagnerpgss.job.result.JobResult;

import java.util.concurrent.ThreadLocalRandom;

public class DefaultJob implements Job {

    private String fileLine;

    public DefaultJob(String fileLine) {
        this.fileLine = fileLine;
    }

    @Override
    public JobResult call() throws Exception {
        //Simulate time required to process job
        System.out.println("Current working at: " + this.fileLine);
        Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 4000));
        System.out.println("Finished working at: " + this.fileLine);
        return new DefaultJobResult();
    }

}