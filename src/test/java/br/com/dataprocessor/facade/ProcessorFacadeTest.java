package br.com.dataprocessor.facade;

import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.service.DataInputService;
import br.com.dataprocessor.service.DataOutputService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import stub.InputDataStub;
import stub.OutputStub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProcessorFacadeTest {

    @InjectMocks
    private ProcessorFacade processorFacade;

    @Mock
    private DataInputService dataInputService;

    @Mock
    private DataOutputService dataOutputService;

    @Test
    public void shouldProcessFile() throws IOException {
        String file = new String(Files.readAllBytes(Paths.get("src/test/resources/fileIn")));
        InputData build = new InputData();

        when(dataInputService.extractor(build, file))
                .thenReturn(InputDataStub.build());
        when(dataOutputService.processOutput(any(), any()))
                .thenReturn(OutputStub.buildOutputModel());

        processorFacade.process(file);
    }

}