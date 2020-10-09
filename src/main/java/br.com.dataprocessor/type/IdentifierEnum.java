package br.com.dataprocessor.type;


public enum IdentifierEnum {

    SALESMAN( "001"),
    CUSTOMER( "002"),
    SALE( "003");

    public String identifier;

    IdentifierEnum(String identifier) {
        this.identifier = identifier;
    }
}
