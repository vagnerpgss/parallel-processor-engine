package com.vagnerpgss.job;

import com.vagnerpgss.job.result.JobResult;
import java.util.concurrent.Callable;

public interface Job extends Callable<JobResult> {

}