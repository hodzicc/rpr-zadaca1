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

           assertEquals(101, exp.evaluate("( 1 + ( 5 * 20 ) )"));
    }

    @Test
    void evaluate_double(){
       ExpressionEvaluator exp = new ExpressionEvaluator();
       assertEquals(4, Math.floor((exp.evaluate("( 2 * ( 5 / 3 ) + 1 )"))));

    }
    @Test
    void evaluate_dijeljenje_s_nulom(){
       ExpressionEvaluator exp = new ExpressionEvaluator();
       try{
           exp.evaluate("( 2 + ( 2 / 0 ) )");
       }
       catch(RuntimeException err)
       {
           assertEquals("Cannot divide by zero", err.getMessage());
       }
    }

    @Test
    void evaluate_nepoznat_znak(){
       ExpressionEvaluator exp = new ExpressionEvaluator();
       assertThrows(RuntimeException.class,()-> { exp.evaluate("( 2 + ( 3 * x ) )"); });
    }

    @Test
    void evaluate_mnozenje(){
       ExpressionEvaluator exp = new ExpressionEvaluator();
       assertEquals(100.0, exp.evaluate("( ( 2 * 0 ) + ( 2 * 100 ) / 2 )"));
    }









}