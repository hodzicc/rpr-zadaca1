package ba.unsa.etf.rpr;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Double.parseDouble;

/**
 * Dijkstra's algorithm for expression evaluation
 */
public class ExpressionEvaluator {
    public static double evaluate(String expression){

        Stack<String> ops  = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        String[] s = expression.split(" ");
        for(int i=0; i<s.length; i++) {
            if      (s[i].equals("("))               ;
            else if (s[i].equals("+"))    ops.push(s[i]);
            else if (s[i].equals("-"))    ops.push(s[i]);
            else if (s[i].equals("*"))    ops.push(s[i]);
            else if (s[i].equals("/"))    ops.push(s[i]);
            else if (s[i].equals("sqrt")) ops.push(s[i]);
            else if (s[i].equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if      (op.equals("+"))    v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))   {
                    if(v==0)
                    {
                        throw new
                                RuntimeException(
                                "Dijeljenje s nulom nije dozvoljeno");
                    }
                    v = vals.pop() / v;
                }
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);

            }
        else if(!s[i].equals("(")) {
            if(i==0)
                throw new RuntimeException("Izraz nije validan");
                try {
                    vals.push(parseDouble(s[i]));
                } catch (NumberFormatException exception) {
                    throw new RuntimeException("Izraz nije validan");
                }
            }
        }
        if(ops.size() != 0) throw new RuntimeException("Izraz nije validan");
       return vals.pop();
    }


}
