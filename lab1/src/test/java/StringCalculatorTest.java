import org.example.StringCalculator;
import org.junit.jupiter.api.BeforeAll;
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
    public void UnlimitedString(){
        assertEquals(45, StrCalc.add("1,2,3,4,5,6,7,8,9,"));
    }
    @Test
    public void StringWithNewLine(){
        assertEquals(6, StrCalc.add("1\n2,3"));
    }
    @Test
    public void StringWithNewLineWithError(){
        assertEquals(-1, StrCalc.add("1,\n"));
    }
    @Test
    public void StringError(){
        assertEquals(-1, StrCalc.add("1,,"));
    }
    @Test
    public void OwnDelimiter(){
        assertEquals(6, StrCalc.add("//;\n1;2;3"));
    }
    @Test
    public void NegativeNum(){
        assertEquals(4, StrCalc.add("//;\n1;-2;-32;3"));
    }
    @Test
    public void HighestThen1000(){
        assertEquals(1032, StrCalc.add("//;\n1000;-2;1001\n32"));
    }
    @Test
    public void LongDelimiter(){
        assertEquals(1032, StrCalc.add("//[abcd]\n1000abcd-2abcd1001\n32"));
    }
    @Test
    public void AnyLongDelimiters(){
        assertEquals(15, StrCalc.add("//[a][bc][def]\n1a2bc3def4\n5"));
    }
}
