package org.example;

public class ArithProcessor {
    public float calculate(String s) {
        StringBuilder operatorBuffer = new StringBuilder();
        StringBuilder numericBuffer = new StringBuilder();
        Float register1 = null;
        Float register2 = null;
        boolean wasPreviousADigit = false;

        for(char currentChar : s.toCharArray()) {
            boolean isADigit = containsNumericChars(currentChar);
            
            if (isADigit) {
                if(!wasPreviousADigit) {
                    numericBuffer.setLength(0);
                }
                numericBuffer.append(currentChar);
            } else {
                if(wasPreviousADigit) {
                    if(register1 == null) {
                        register1 = Float.parseFloat(numericBuffer.toString());
                    } else {
                        register2 = Float.parseFloat(numericBuffer.toString());
                        register1 = execute(register1, register2, operatorBuffer.toString());
                    }
                    operatorBuffer.setLength(0);
                }
                operatorBuffer.append(currentChar);
            }
            wasPreviousADigit = isADigit;
        }
        register2 = Float.parseFloat(numericBuffer.toString());
        register1 = execute(register1, register2, operatorBuffer.toString());
        
        return register1;        
    }

    private static boolean containsNumericChars(char currentChar) {
        return Character.isDigit(currentChar) || currentChar == '.';
    }

    private Float execute(Float register1, Float register2, String operator) {
        return switch(operator) {
            case "plus" -> register1+register2;
            case "minus" -> register1-register2;
            case "times" -> register1*register2;
            case "divide" -> register1/register2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
