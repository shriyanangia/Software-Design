import java.util.Scanner;
/**
 * Main driver class that tests PostfixEvaluator.java
 *
 * @author snangia
 */
public class Driver
{
    public static void main(String[] args)
    {
        /**
         * This method will automatically be called when Driver is run.
         *
         * @param args Command line arguments.
         */
        Scanner sc = new Scanner(System.in);
        PostfixEvaluator evaluator = new PostfixEvaluator();

        StringBuffer postfixBuffer;
        postfixBuffer = new StringBuffer(sc.nextLine());
        postfixBuffer.append(" )");

        int result = evaluator.evaluatePostfixExpression(postfixBuffer);

        System.out.println(result);
    }
}
