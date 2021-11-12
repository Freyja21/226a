package ch.tbz;

import java.util.Scanner;

public class Menu {
   private boolean exit = false;
   private int score = 0;
    private String name = "";
    private final Animal animal = new Animal("","");
    private final Language language = new Language("","");
    private final Switzerland switzerland = new Switzerland("","");
    private final Ranking ranking = new Ranking();
    private final TimeAPI time = new TimeAPI();

    private void useSelected(int selected){
        switch (selected) {
            case 1 -> score += animal.quiz(Quiz.animalQuiz);
            case 2 -> score += language.quiz(Quiz.languageQuiz);
            case 3 -> score += switzerland.quiz(Quiz.switzerlandQuiz);
            case 4 -> {
                ranking.addNewScore(name, score);
                ranking.printScore();
            }
            case 5 -> {
                ranking.saveScore();
                exit = true;
            }
            default -> System.out.println("wrong input");
        }
    }


    public void menu(){
        Scanner input = new Scanner(System.in);
        try{
            time.getFromApi();
            System.out.println("Enter your name");
            name = input.nextLine();
            while (!exit){
                System.out.println("***************************\n" +time.showAPIInfo()+ "\n1. Animal Quiz\n2. Language Quiz\n3. Switzerland Quiz\n4. show Scoreboard\n5. Quit");
                useSelected(input.nextInt());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            input.close();
        }
    }
}
