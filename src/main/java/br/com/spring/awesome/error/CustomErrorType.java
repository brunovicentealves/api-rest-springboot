package br.com.spring.awesome.error;

public class CustomErrorType {
    private String errorMensager;

    public CustomErrorType(String errorMensager){
        this.errorMensager=errorMensager;

    }

    public String getErrorMensager(){
        return errorMensager;
    }
}
