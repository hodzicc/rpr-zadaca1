package ba.unsa.etf.rpr;

import junit.framework.TestCase;
import junit.framework.TestResult;

import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

   @org.junit.jupiter.api.Test
    void evaluate(){
        ExpressionEvaluator exp = new ExpressionEvaluator();
        //assertEquals(1,1);
           assertEquals(101, exp.evaluate("( 1 + ( 5 * 20 ) )"));
    }


}