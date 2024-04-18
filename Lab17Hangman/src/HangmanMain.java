public class HangmanMain {
    
    /**
     * Your main method must do the following:
     * * Create a new HangmanGame object
     * * Call the printScreen() method (remember how to call methods on different objects!)
     * * Call initializeWords(), passing in a fileName, which requires the input from the user
     * * Call wordSelect().
     * * Print the initial hangman gallows by calling getZero().
     * * Call printWordProgress()
     * * While the game is not finished, get input from the user on what letter they guess 
     * using getInput("Guess a letter: ") and call guess(), passing in the guess input.
     * @param args
     */
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        HangmanView view = new HangmanView();
        view.printScreen();
        game.initializeWords(view.getInput("Enter file name: "));
        game.wordSelect();
        view.getZero();
        game.printWordProgress();
        while (!game.finished) {
            String guess = view.getInput("Guess a letter: ");
            game.guess(guess);
        }
    }
}
