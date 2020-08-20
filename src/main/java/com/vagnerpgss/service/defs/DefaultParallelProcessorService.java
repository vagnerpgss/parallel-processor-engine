package com.vagnerpgss.service.defs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.vagnerpgss.job.DefaultJob;
import com.vagnerpgss.service.interfaces.ConsumersService;
import com.vagnerpgss.service.interfaces.ParallelProcessorService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultParallelProcessorService implements ParallelProcessorService {

    private final ConsumersService consumersService;

    @Autowired
    public DefaultParallelProcessorService(ConsumersService consumersService) {
        this.consumersService = consumersService;
    }

    @Override
    public void processParallelizableFile(String pathName) {
        Scanner scan = null;
        try {
            System.out.println(" ##################################################### ");
            scan = new Scanner(new File(pathName));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                consumersService.produce(new DefaultJob());
            }
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