package com.core.utility;

public class PrintUtility {


    public void printSimpleMessage(final String message){
        System.out.print(message);
    }

    public void printSimpleMessageLn(final String message){
        System.out.println(message);
    }


    public void printMessageOfFormat(final String message,final String format){
        System.out.printf(format,message);
    }


}
