package org.example;

public class ArithProcessor {
    public int calculate(String s) {
        StringBuilder operatorBuffer = new StringBuilder();
        StringBuilder numericBuffer = new StringBuilder();
        Integer register1 = null;
        Integer register2 = null;
        boolean wasPreviousADigit = false;

        for(int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            boolean isADigit = Character.isDigit(currentChar);
            
            if (isADigit) {
                if(!wasPreviousADigit) {
                    numericBuffer.setLength(0);
                }
                numericBuffer.append(currentChar);
            } else {
                if(wasPreviousADigit) {
                    if(register1 == null) {
                        register1 = Integer.parseInt(numericBuffer.toString());
                    } else {
                        register2 = Integer.parseInt(numericBuffer.toString());
                        register1 = execute(register1, register2, operatorBuffer.toString());
                    }
                    operatorBuffer.setLength(0);
                }
                operatorBuffer.append(currentChar);
            }
            wasPreviousADigit = isADigit;
        }
        register2 = Integer.parseInt(numericBuffer.toString());
        register1 = execute(register1, register2, operatorBuffer.toString());
        
        return register1;        
    }

    private Integer execute(Integer register1, Integer register2, String operator) {
        return switch(operator) {
            case "plus" -> register1+register2;
            case "minus" -> register1-register2;
            case "times" -> register1*register2;
            case "divide" -> register1/register2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
