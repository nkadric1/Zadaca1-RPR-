package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionEvaluatorTest {

    /**
     * testing whether the function calculates well
     */
    @Test
    void result() {
         Stack<Double> a = new Stack<>();
         a.push(25.0);
         a.push(4.0);


        assertEquals(2, ExpressionEvaluator.result("sqrt", a),"Error!");
    }

    /**
     * testing if function evaluate works on clear example
     */
    @Test
    void evaluate_1() {
        String s="( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101, ExpressionEvaluator.evaluate(s));
    }


    /**
     * testing function with sqrt
     */
    @Test void evaluateinvalid () throws RuntimeException{


        assertThrows(RuntimeException.class, ()-> ExpressionEvaluator.validexpression("( 5 + ( sqrt abc ) )"), "Error!");
    }
/**
     * testing if function evaluate gives right result of expression
     */
    @Test void evaluate_2 (){

        double res = ExpressionEvaluator.evaluate("( ( sqrt 9 ) + 17 )");
        assertEquals(20, res);

    }

    /**
     * testing if operand is valid for evaluating
     */
    @Test
    void validtest() throws RuntimeException
    {
        String s="(2 + 8 $$ 5)";
        assertThrows(RuntimeException.class, ()-> ExpressionEvaluator.validexpression(s), "Error!");
}

    /**
     * testing if value is valid number
     */
 @Test
    void validtestforpar() throws RuntimeException{
        String s="(2 + ( 4 - 5)";
        assertThrows(RuntimeException.class, ()->ExpressionEvaluator.validparentheses(s), "Error");

 }
 /**
  * testing if sqrt function gives right result
 */

 @Test
    void evaluate_3(){
         assertEquals(4, ExpressionEvaluator.evaluate("( sqrt 16 )"));
    }


    /**
     * testing function with more parentheses
     */
    @Test
    void evaluate_4(){
        String z="( 2 + ( ( 50 / 2 ) + ( sqrt 9 ) ) )";
        assertEquals(30,ExpressionEvaluator.evaluate(z));
    }

    /**
     *  if string is empty throw exception
     */
    @Test
    void ev() throws RuntimeException{
        assertThrows(RuntimeException.class, ()->ExpressionEvaluator.evaluate(" "), "Error");
    }
    @Test
    void evaluate_5() throws RuntimeException{
        assertThrows(RuntimeException.class, ()->ExpressionEvaluator.validops("( 1 * * 2 )"), "Error");
    }

}
