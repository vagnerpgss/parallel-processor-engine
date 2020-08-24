package com.vagnerpgss.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.vagnerpgss.job.DefaultJob;
import com.vagnerpgss.service.ConsumerProducerService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultParallelProcessorService implements ParallelProcessorService {

    private final ConsumerProducerService consumerProducerService;

    @Autowired
    public DefaultParallelProcessorService(ConsumerProducerService consumerProducerService) {
        this.consumerProducerService = consumerProducerService;
    }

    @Override
    public void processParallelizableFile(String pathName) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File(pathName));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                consumerProducerService.produce(new DefaultJob(line));
            }
            consumerProducerService.consume();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //TODO - Exception
        } finally {
            if(scan != null) {
                scan.close();
            }
        }
    }

}