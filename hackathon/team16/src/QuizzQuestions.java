public class QuizzQuestions
{
    final int numQuestions =7;
    private String[] listOfQuestions;
    private String[] ansArray;
    private int[] correctAnsArr;

    public QuizzQuestions()
    {
        //Media Type Qn

        //other qn types
        listOfQuestions[0] = "Which of these cities is NOT a national capital?";
        ansArray[0] = "1. Cairo\n" +
                "        2. Prague\n" +
                "        3. Bangkok\n" +
                "        4. Sydney";
        correctAnsArr[0] = 4;

        listOfQuestions[1] = "The Great Pyramid of Giza is the only one of the ancient Wonders of the World that still stands";
        ansArray[1] = " 1. True " +
                "2. False";
        correctAnsArr[1] = 1;

        listOfQuestions[2] = "How old is Crush in Finding Nemo?";
        ansArray[2] = " 1. 100 years\n" +
                "        2. 150 years\n" +
                "        3. 200 years\n" +
                "        4. 250 years";
        correctAnsArr[2] = 2;


        listOfQuestions[3] = "Which former Hawkeye basketball player won three NBA championships during his career as a point guard for the Chicago Bulls?";
        ansArray[3] = "  1. B.J. Armstrong\n" +
                "        2. Fred Brown\n" +
                "        3. Matt Bullard";
        correctAnsArr[3] = 1;


        listOfQuestions[4] = "The Van Allen Building is named after the professor who discovered the Van Allen Radiation Belts";
        ansArray[4] = "  1. True\n" +
                "        2. False";
        correctAnsArr[4] = 1;


        listOfQuestions[5] = "'It’s our choices that show who we are, far more than our abilities'";
        ansArray[5] = " 1. Gandalf\n" +
                "        2. Obi-Wan Kenobi\n" +
                "        3. Albus Dumbledore\n" +
                "        4. Yoda";
        correctAnsArr[5] = 3;

    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public String[] getListOfQuestions() {
        return listOfQuestions;
    }

    public String[] getAnsArray() {
        return ansArray;
    }
}
