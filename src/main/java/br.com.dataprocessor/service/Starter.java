package br.com.dataprocessor.service;

import br.com.dataprocessor.facade.ProcessorFacade;
import br.com.dataprocessor.inputdata.extractor.DataExtractor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Starter {

    public void start(){

        int threads = Runtime.getRuntime().availableProcessors();

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(threads-1);
        DataExtractor.listAllFiles().forEach(file-> {
            ProcessorFacade processor = new ProcessorFacade();
            executor.submit(() -> {
                processor.process(file);
            });
        });
    }

}
