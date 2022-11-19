package ba.unsa.etf.rpr;

/**
 * Zadaca 1 rpr
 * @author Amna Hodzic
 * @version 1.0
 */
public class App 
{
    /**
     * Main function
     * checking if input is valid
     * @param args
     */
    public static void main( String[] args )
    {
        if (args.length < 2){
            System.err.println("Nedovoljan broj argumenata java -jar rpr-zadaca1.jar [funkcija] [argument]");
        } else if (!args[0].equals("evaluate")) {
            System.err.println("Nevalidna funkcija, evaluate je podrzana funkcija");
        }else{
            try {
                String funkcija = args[0];
                String input = new String();
                for(int i=1; i<args.length; i++) {
                    if(i>=2)
                    input = input +" "+ args[i];
                    else input = args[i];
                }
                System.out.println(input);
               System.out.println("evaluate("+input+")= "+ ExpressionEvaluator.evaluate(input));
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
