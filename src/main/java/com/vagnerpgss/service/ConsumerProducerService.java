package com.vagnerpgss.service;

import com.vagnerpgss.job.DefaultJob;

public interface ConsumerProducerService {
    void produce(DefaultJob producer);
    void consume ();
}