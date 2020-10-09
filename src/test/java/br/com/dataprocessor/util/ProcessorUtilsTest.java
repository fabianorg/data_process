package br.com.dataprocessor.util;

import br.com.dataprocessor.type.IdentifierEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class ProcessorUtilsTest {

    @Test
    public void shouldValidadeCedillaCharacterInPersonalNamesInSalesmanLine(){
        String line = "001ç1234567891444çJonelson II Caçamba de Moçambiqueç50000";
        List<String> strings = ProcessorUtils.splitLine(line, 'ç');
        Assert.assertEquals(strings.get(0), IdentifierEnum.SALESMAN.identifier);
        Assert.assertEquals("1234567891444", strings.get(1));
        Assert.assertEquals("Jonelson II Caçamba de Moçambique", strings.get(2));
        Assert.assertEquals("50000", strings.get(3));
    }

    @Test
    public void shouldValidadeCedillaCharacterInPersonalNamesInCustomerLine(){
        String line = "002ç2345675434544999çJonelson II Caçamba de MoçambiqueçRural";
        List<String> strings = ProcessorUtils.splitLine(line, 'ç');
        Assert.assertEquals(strings.get(0), IdentifierEnum.CUSTOMER.identifier);
        Assert.assertEquals("2345675434544999", strings.get(1));
        Assert.assertEquals("Jonelson II Caçamba de Moçambique", strings.get(2));
        Assert.assertEquals("Rural", strings.get(3));
    }

    @Test
    public void shouldValidadeCedillaCharacterInPersonalNamesInSaleLine(){
        String line = "003ç05ç[1-34-10,2-33-1.50,3-40-0.10]çJonelson II Caçamba de Moçambique";
        List<String> strings = ProcessorUtils.splitLine(line, 'ç');
        Assert.assertEquals(strings.get(0), IdentifierEnum.SALE.identifier);
        Assert.assertEquals("05", strings.get(1));
        Assert.assertEquals("[1-34-10,2-33-1.50,3-40-0.10]", strings.get(2));
        Assert.assertEquals("Jonelson II Caçamba de Moçambique", strings.get(3));
    }

}