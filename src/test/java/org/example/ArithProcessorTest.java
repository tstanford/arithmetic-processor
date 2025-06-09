package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithProcessorTest {

    @Test
    public void shouldReturn10(){
        var arithProcessor = new ArithProcessor();

        var result = arithProcessor.calculate("1plus2plus3plus4");

        Assertions.assertEquals(10, result);
    }

    @Test
    public void shouldThrowIllegalStateException(){
        var arithProcessor = new ArithProcessor();

        Assertions.assertThrows(IllegalStateException.class, () -> arithProcessor.calculate("1pls2plus3plus4"));
    }

    @ParameterizedTest
    @CsvSource({
            "1plus2plus3plus4,10",
            "2plus3plus4plus5,14",
            "2times2times2,8",
            "2times2times2plus1,9",
            "10plus1plus1divide2,6"
    })
    public void shouldReturn10(String sum, int expectedResult){
        var arithProcessor = new ArithProcessor();

        var result = arithProcessor.calculate(sum);

        Assertions.assertEquals(expectedResult, result);
    }

}