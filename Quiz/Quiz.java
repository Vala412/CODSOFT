import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;
    private int currentQuestionIndex;
    private Scanner scanner;
    private Timer timer;
    private boolean timeUp;


    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.currentQuestionIndex = 0;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (currentQuestionIndex < questions.size()) {
            displayQuestion();
            startTimer(10);
            String userAnswer = getUserAnswer();
            evaluateAnswer(userAnswer);
            currentQuestionIndex++;
        }
        displayResult();
    }

    private void displayQuestion() {
        Question question = questions.get(currentQuestionIndex);
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ": " + options[i]);
        }
    }

    private void startTimer(int seconds) {
        timeUp = false;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("\nTime's up!");
            }
        }, seconds * 1000);
    }

    private String getUserAnswer() {
        String answer = null;
        while (answer == null && !timeUp) {
            System.out.print("Your answer: ");
            if (scanner.hasNextLine()) {
                answer = scanner.nextLine().trim().toUpperCase();
                if (answer.isEmpty() || answer.length() != 1 || answer.charAt(0) < 'A' || answer.charAt(0) >= 'A' + questions.get(currentQuestionIndex).getOptions().length) {
                    System.out.println("Invalid input. Please enter a valid option.");
                    answer = null;
                }
            }
        }
        timer.cancel();
        return answer;
    }

    private void evaluateAnswer(String userAnswer) {
        if (userAnswer == null) return;
        int answerIndex = userAnswer.charAt(0) - 'A';
        if (answerIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
        }
    }

    private void displayResult() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You will have 10 seconds to answer each question.");
        System.out.println("Let's get started!\n");
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("Which of the following is NOT an anti-virus software?", new String[]{"Avast", "Linux", "Norton", "Kaspersky"}, 1));
        questions.add(new Question("Which unit of the computer is considered as the brain of the computer?", new String[]{"Memory Unit", "Input Unit", "CPU", "Output Unit"}, 2));
        questions.add(new Question("Which of the following is NOT a programming language?", new String[]{"Python", "Java", "Linux", "C++"}, 2));
        questions.add(new Question("Which of the following is NOT a web browser?", new String[]{"Chrome", "Firefox", "Opera", "Linux"}, 3));
        questions.add(new Question("What is the full form of PROM?", new String[]{"Program read-only memory", "Primary read-only memory", "Programmable read-only memory", "Program read-output memory"}, 2));

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
