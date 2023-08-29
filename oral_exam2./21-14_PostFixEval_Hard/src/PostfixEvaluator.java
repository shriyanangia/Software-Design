import java.util.Stack;

/**
 * This class has 4 public methods 
 *
 * @author snangia
 */

public class PostfixEvaluator
{
    Stack<Integer> integerStack;

    public PostfixEvaluator()
    {
        integerStack = new Stack<>();
    }


    /**
     * This method evaluates the postfix expression
     * @param input StringBuffer variable to hold the postfix expression
     * @return int result of postfix expression
     */
    public int evaluatePostfixExpression(StringBuffer input)
    {
        String currentInputElement = "";
        int result = 0;

        String arrOfStr[] = splittingString(input);

        for (int i=0; i<arrOfStr.length; i++)
        {
                //currentInputElement = input.charAt(i);
                currentInputElement = arrOfStr[i];

                if (currentInputElement.equals(")"))
                {
                    break;
                }

                //if a numeric is encountered
                if (isNumeric(currentInputElement))
                {
                    integerStack.push((Integer.parseInt(currentInputElement)));
                }
                //if an operator is encountered
                else if ((currentInputElement.equals("+")) || (currentInputElement.equals("-")) || (currentInputElement.equals("*")) ||
                        (currentInputElement.equals("/")) || (currentInputElement.equals("^")) || (currentInputElement.equals("%")))
                {
                    result = calculate(currentInputElement);
                    integerStack.push(result);
                }
                else
                {
                    System.out.println("invalid");
                }
        }
        return integerStack.pop();
    }

    /**
     * This method evaluates the expression op1 operator op2
     * @param input String variable
     * @return int result after calculation
     */
    public int calculate(String input)
    {
        //first number in stack when operand is encountered
        int digit1 =  integerStack.pop();
        //second number in stack when operand is encountered
        int digit2 = integerStack.pop();

        //calculation based on operand encountered
        if (input.equals("+"))
        {
            return (digit1+digit2);
        }
        else if (input.equals("-"))
        {
            return (digit2-digit1);
        }
        else if (input.equals("*"))
        {
            return (digit1*digit2);
        }
        else if (input.equals("/"))
        {
            return (digit2/digit1);
        }
        else if (input.equals("^"))
        {
            return (digit2^digit1);
        }
        else if (input.equals("%"))
        {
            return (digit2 % digit1);
        }
        else
        {
            return 0;
        }
    }

    /**
     * This method splits the string at each space
     * @param input StringBuffer input
     * @return String array containing each character excluding spaces
     */
    public String[] splittingString(StringBuffer input)
    {
        String temp = input.toString();
        return (temp.split(" "));
    }

    /**
     * This method checks if input is numeric
     * @param input String input
     * @return boolean
     */
    public boolean isNumeric(String input) {

        if (input == null || input.length() == 0) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

