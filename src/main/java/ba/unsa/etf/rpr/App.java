package ba.unsa.etf.rpr;

import java.sql.SQLOutput;

/**
 * App class with a main method that parses the input from the console
 * and calculate the expression
 *
 */
public class App 
{
    public static void main( String[] args ) throws RuntimeException
    {
       try{
           // check if passed expression is valid

         ExpressionEvaluator.validexpression(args[0]);
           System.out.println("The result of given expression is: "+ ExpressionEvaluator.evaluate(args[0]));

       } catch(RuntimeException exception){
           System.out.println("This expression is invalid!");
       }


    }
}
