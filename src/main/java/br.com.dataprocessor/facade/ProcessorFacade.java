package br.com.dataprocessor.facade;

import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.outputdata.model.OutputData;
import br.com.dataprocessor.service.DataInputService;
import br.com.dataprocessor.service.DataOutputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class ProcessorFacade {

	private DataInputService dataInputService;
	private DataOutputService dataOutputService;
	private InputData inputData;
	private OutputData outputData;

    private static final Logger logger = LoggerFactory.getLogger(ProcessorFacade.class);

	public ProcessorFacade(){
		this.dataInputService = new DataInputService();
		this.dataOutputService = new DataOutputService();
		this.inputData = new InputData();
		this.outputData = new OutputData();
	}

	public void process(String file){
		dataInputService.clearList(inputData);
		extractInputData(file)
				.andThen(processToOutputData(outputData))
				.andThen(saveOutputData())
				.apply(inputData);
	}


	private Function<InputData, InputData> extractInputData(String file){
		return (InputData inputData)-> {
			logger.info("Extracting file: " + file);
			dataInputService.extractor(inputData, file);
			return inputData;
		};
	}

	private Function<InputData, OutputData> processToOutputData(OutputData outputData){
		return (InputData inputData) -> {
			logger.info("Will start process to output");
			logger.info(inputData.toString());
			dataOutputService.processOutput(outputData, inputData);
			return outputData;
		};
	}

	private Function<OutputData, OutputData> saveOutputData(){
		return (OutputData outputData)-> {
			logger.info("Saving... " + outputData);
			dataOutputService.save(outputData);
			return outputData;
		};
	}
}
 
