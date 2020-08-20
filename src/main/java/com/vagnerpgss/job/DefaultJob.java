package com.vagnerpgss.job;

public class DefaultJob implements Job {

    @Override
    public void run() {
        System.out.println(" DO THE PARALLEL JOB HERE! ");
    }

}