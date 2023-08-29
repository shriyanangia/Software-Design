import java.util.Random;
public class Questions {
    private String[] questions = {"what color is a robin","what is the name of the horse like animal with black and white stripes",
            "what color is the sky","who invented the scientific method","what language was this quiz coded in","what company invented the iphone",
            "whats 2+2","what objects are stored in libraries"};
    private String[] correctAnswers = {"Red","Zebra","Blue","Sir Francis Bacon","Java","Apple","4","Books"};
    private String[][] answers = new String[5][3];//5 questions, three players
    private int[] usedQuestions = new int[5];
    private int questionsAnswered = 0;
    private int playersAnswered = 0;
    private int[] points = new int[3];
    private int currentQuestion;
    Random rand = new Random();

    /**
     * returns a question to be asked
     * @return the question to be asked
     */
    public String getQuestion(){
        int n = rand.nextInt(7);
        currentQuestion = n;
        usedQuestions[questionsAnswered] = currentQuestion;
        return questions[n];
    }

    /**
     * submits a guess for a player
     * @param guess the guess that is being submitted by the player
     * @param player the player who is submitting the guess
     */
    public void playerGuess(String guess,int player){
        if(answers[currentQuestion][player].equals("")){
            playersAnswered++;
        }
        answers[currentQuestion][player] = guess;
    }

    /**
     * checks if all players have submitted an answer, and if so then grades all the answers and returns true so the server can ask a new question
     * @return whether all players have submitted an answer yet or not
     */
    public boolean finishQuestion(){
        if(playersAnswered != 3){
            return false;
        }
        for(int i = 0;i<3;i++) {
            if (answers[questionsAnswered][i].equals(correctAnswers[currentQuestion])) {
                points[i]++;
            }
            questionsAnswered++;
        }
        return true;
    }


}
