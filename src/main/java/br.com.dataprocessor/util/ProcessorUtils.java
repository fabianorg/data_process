package br.com.dataprocessor.util;

import br.com.dataprocessor.type.IdentifierEnum;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessorUtils {

    private static final Integer SALESMAN_CUSTOMER_INDEX_NAME = 2;
    private static final Integer SALESMAN_INDEX_NAME_IN_SALE = 3;

    public static List<String> splitLine(String data, Character delimitator){
        List<String> dataSplited = Splitter.on(delimitator)
                .trimResults()
                .omitEmptyStrings()
                .splitToList(data);
        return (dataSplited.size()>3) ? validatePersonalNames(dataSplited) : dataSplited;

    }

    public static String removeSquareBrackets(String data){
        data = data.replace("[","");
        data = data.replace("]","");
        return data;
    }

    public static String extractFileName(String path){
        String[] split = path.split("/");
        return split[split.length -1];
    }

    private static List<String> validatePersonalNames(List<String> dataSplited){
        List newList = Collections.EMPTY_LIST;

        if (dataSplited.get(0).equals(IdentifierEnum.SALESMAN.identifier) ||
                dataSplited.get(0).equals(IdentifierEnum.CUSTOMER.identifier)){
            newList = validateSalesmanCustomerNames(dataSplited);
        }

        if (dataSplited.get(0).equals(IdentifierEnum.SALE.identifier)){
            newList = validateSalesmanNameInSale(dataSplited);
        }
        return (newList.isEmpty()) ? dataSplited : newList;
    }

    private static  List<String> validateSalesmanCustomerNames(List<String> resultSet){
            int index = SALESMAN_CUSTOMER_INDEX_NAME;
            String name = "";
            while (index <= resultSet.size()-2) {
                name = name.concat(resultSet.get(index ++));
                if (index == resultSet.size()-1){
                    index++;
                }else {
                    name = name.concat("ç");
                }
            }

            ArrayList<String> list = new ArrayList<>();
            list.add(0, resultSet.get(0));
            list.add(1, resultSet.get(1));
            list.add(2, name);
            list.add(3, resultSet.get(resultSet.size()-1));
            return list;

    }

    private static  List<String> validateSalesmanNameInSale(List<String> resultSet){
            int index = SALESMAN_INDEX_NAME_IN_SALE;
            String name = "";
            while (index <= resultSet.size()-1) {
                name = name.concat(resultSet.get(index ++));
                if (index == resultSet.size()){
                    index++;
                }else {
                    name = name.concat("ç");
                }
            }

            ArrayList<String> list = new ArrayList<>();
            list.add(0, resultSet.get(0));
            list.add(1, resultSet.get(1));
            list.add(2, resultSet.get(2));
            list.add(3, name);
            return list;
    }

}
