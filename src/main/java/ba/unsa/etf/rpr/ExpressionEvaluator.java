package ba.unsa.etf.rpr;
import java.util.Stack;

/**
 * @author Kadrić Nerma
 * 19030 - index
 * @version 1.0
 *

 */

/**
 * ExpressionEvaluator class implements Dijkstra algorithm to perform arithmetic operations of a expression that is given
 */
public class ExpressionEvaluator {
    /**
     * this method perform arithmetic operations +,-,*,/
     * @param  a  the string that is operand from expression
     * @param v stack of doubles that keeps values from expression that must be calculate
     * "b" is the value that will be used with the operand a for arith. operations
     * @return the double value is result of the selected arithmetic operation
     */
    protected static double result(String a, Stack<Double> v){

        double b=v.pop();

        if(a.equals("-")) {
           return  v.pop() - b;
        } else if(a.equals("+")) return v.pop()+b;
        else if(a.equals("*")) return v.pop()*b;
        else if(a.equals("/")) return v.pop()/b;
        else if(a.equals("sqrt")) return Math.sqrt(b);
      // else if(!(a.equals("+") || a.equals("-") || a.equals("/") || a.equals("*") || a.equals("sqrt") || a.equals("(") || a.equals(")"))) throw new RuntimeException("The operand is invalid!");
       else return 0;
    }
/**
 * this method checks if the expression is valid
 * @param str is given expression that must be splited
 * if str has any   operand other than those mentioned or if it is not a digit, it must throw RuntimeException*/
  public static void validexpression(String str) throws RuntimeException{
       String[] s=str.split(" ");
      for(String s1: s){
           if(!(s1.equals("+") || s1.equals("-") || s1.equals("/") || s1.equals("*") || s1.equals("sqrt") || s1.equals("(")
                   || s1.equals(")") )) {
               char[] c=s1.toCharArray();
               for( char ch : c){
           if(!(ch=='0' || ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='6' || ch=='7' || ch=='8' || ch=='9'))    throw new RuntimeException("The operand is invalid!");}
           }
       }

  }

    /**
     * this method checks if expression has same number of parentheses, if there are not then it throws RuntimeException
     * @param str  is given expression that must be splited
     */
    public static void validparentheses(String str) throws RuntimeException{
    String[] s=str.split(" ");
    int frs=0;
    int sec = 0;
    for(String s1 : s){
        if(s1.equals("(")) frs=frs+1;
        if(s1.equals(")")) sec=sec+1;

    }
    if(frs<sec || frs>sec) throw  new RuntimeException("Parentheses are invalid!");
}

    /**
     * this method checks if expression is valid because of operators
     * @param str is given expression that must be splited
     * @throws RuntimeException if operators appeared  consecutively
     */
    public static void validops(String str) throws RuntimeException{ int br=0,br1=0,br2=0;
        for(String s1 : str.split(" ")){
            if(s1.equals("+") || s1.equals("-") || s1.equals("*") || s1.equals("/")) br++;
            if(s1.equals("sqrt")) br2++;
            if(s1.equals("0") || s1.equals("1") || s1.equals("2") || s1.equals("3") || s1.equals("4") || s1.equals("5") || s1.equals("6") || s1.equals("7") || s1.equals("8") || s1.equals("9")) br1++;

        }
        br++;
        if((br1+br2)!=br) throw new RuntimeException("Two operators appeared consecutively- error!");
}
    /**

     * @param str the string that is passed
     *            to the function which evaluates expression from it
     * @return the double value that is result of expression from splited string
     */

    public static double evaluate(String str){
     Stack<String> ops=new Stack<String>();
  Stack<Double> vals=new Stack<Double>();

  String[] s=str.split(" ");
    for(String s1: s) {
       switch(s1){
            case"(": break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "sqrt":
                ops.push(s1);

                break;

            case ")":
                 validexpression(s1);

                vals.push(result(ops.pop(), vals));
                break;
            default: vals.push(Double.parseDouble(s1));
            break;
        }
    }

    return vals.pop();
    }
    }

