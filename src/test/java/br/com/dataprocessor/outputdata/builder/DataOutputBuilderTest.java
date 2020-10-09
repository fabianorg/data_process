package br.com.dataprocessor.outputdata.builder;

import org.junit.Assert;
import org.junit.Test;
import stub.OutputStub;

public class DataOutputBuilderTest {

    @Test
    public void shouldMountStringToSaveInFile(){

        String out = "3ç3ç2çJonelson";

        Assert.assertTrue(DataOutputBuilder.buildStringToSave(OutputStub.buildOutputModel()).equals(out));

    }
}