import org.example.StringCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringCalculatorTest {
    private static StringCalculator StrCalc;

    @BeforeAll
    public static void beforeEach(){
        StrCalc = new StringCalculator();
    }
    @Test
    public void EmptyInput(){
        assertEquals(0, StrCalc.add(""));
    }
    @Test
    public void PairInput(){
        assertEquals(3, StrCalc.add("1,2"));
    }
    @Test
    public void UnlimetedString(){
        assertEquals(45, StrCalc.add("1,2,3,4,5,6,7,8,9,"));
    }
    @Test
    public void StrignWithNewLine(){
        assertEquals(6, StrCalc.add("1\n2,3"));
    }
    @Test
    public void StrignWithNewLineWithError(){
        assertEquals(0, StrCalc.add("1,\n"));
    }
    @Test
    public void StrignError(){
        assertEquals(0, StrCalc.add("1,,"));
    }
    @Test
    public void OwnDelimeter(){
        assertEquals(6, StrCalc.add("//;\n1;2;3"));
    }
    @Test
    public void NegativeNum(){
        assertEquals(4, StrCalc.add("//;\n1;-2;3"));
    }
}
