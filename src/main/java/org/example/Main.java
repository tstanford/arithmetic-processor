package org.example;


public class Main {
    public static void main(String[] args) {
        var arithProcessor = new ArithProcessor();
        var result = arithProcessor.calculate(args[0]);
        System.out.println(result);
    }

}