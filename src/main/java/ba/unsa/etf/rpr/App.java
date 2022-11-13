package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class App 
{
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
                    input += args[i];
                }
                System.out.println(input);
                //String input =args[1];
               System.out.println("evaluate("+input+")= "+ ExpressionEvaluator.evaluate(input));
            }catch (Exception e){
                System.err.println("Nevalidan drugi argument, mora biti string");
            }
        }
    }
}
