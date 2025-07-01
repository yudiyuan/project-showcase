package Project;
//This is the best one I can do

import javax.swing.*;
import java.util.Random;
import java.util.regex.Pattern;

public class TextAdventureGame {

    //Use static to create class variable
    static String playerName;

    //Random will be used twice

    static Random random=new Random();

    public static void main(String[] args) {
        //Use 'do-while' to ensure once running at least
        do{
            //These two methods will be run by order
            getPlayerName();
            sceneOne();
            
            //Because sceneTwo will lead to different ways so use a variable and if to control the logic
            int choice=sceneTwo();
            if(choice==1){
                //In this condition, player will end the game 
                //Use continue to jump the remainder of 'do', then answer 'while' 
                continue;
            }
            if(choice==2){
                //Jump into sceneThree
                sceneThree();
                //Same as choice==1
                continue;
            }
            if(choice==3){
                //Jump into sceneFour
                sceneFour();
                //Because there is no more code so 'continue' is meaningless
            }
        }while (restartGame());//When user chooses to restart, back to the start of 'do while' loop

        //If restartGame is false, show message then end the main method
        JOptionPane.showMessageDialog(null,"See You");
    }

    private static int checkInputValidation(String input){
        //If user click cancel or close, they can exit directly
        if(input==null){
            JOptionPane.showMessageDialog(null,"See You");
            System.exit(0);
        }

        //These two variable will be used in more than one area
        int choice=0;
        boolean inputValid=true;

        //Check the type
        try{
            choice=Integer.parseInt(input);
        }catch (Exception e){
            inputValid=false;
        }

        //Check the range of number
        if(choice<1||choice>3){
            inputValid=false;
        }

        //Show notice message only in one code
        if(!inputValid) {
            JOptionPane.showMessageDialog(null, "Invalid input, please try again");
            return -1;
        }
        return choice;
    }

    private static void getPlayerName() {
        //I need the user to input endlessly until they match my request
        while (true){
            playerName=JOptionPane.showInputDialog("Welcome to the adventure game, please choose a name for your player,\n" +
                    "should contain only alphanumeric and/or underscore characters,\n " +
                    "with a minimum length of 2 and a maximum length of 15");

            //If they click the cancle or close button, they can exit directly
            if(playerName==null){
                JOptionPane.showMessageDialog(null,"See You");
                System.exit(0);
            }

            //Only playerName matches the RegEx, could 'break' the 'while(true)' loop
            if(Pattern.matches("^[a-zA-Z0-9_]{2,15}$",playerName)){
                break;
            }

            //Otherwise, I will show the notice to request a new input
            //PS: "" is here
            JOptionPane.showMessageDialog(null,"Invalid input, please try again");
        }
    }

    private static void sceneOne() {
        //Same as getPlayerName
        while (true) {
            //Get user input
            String input = JOptionPane.showInputDialog(null, "Scene One\n" + playerName + " finds yourself lost in a dense forest with no clear path forward.\n" +
                    "Choices:\n" +
                    "1 - Climb a tree to get a better view.\n" +
                    "2 - Bulid a shelter and wait for rescue.\n" +
                    "3 - Follow a stream to see if it leads to civillization.");

            //Use my 'checkInputValidation' to handle error input and parse 'input' to 'choice'
            int choice = checkInputValidation(input);

            //If input is invalid
            if (choice==-1) {
                //The input is invalid, so use 'continue' to back to the start of 'while' loop to get a new input
                continue;
            }

            //Otherwise every choice leads to a same result
            JOptionPane.showMessageDialog(null, playerName + " continues your journey");
            //When user input validly, break the 'while(true)' method and jump back to 'main' method ,run the remainder
            break;
        }
    }

    private static int sceneTwo() {
        while (true){
            String input = JOptionPane.showInputDialog(null, "Scene Two\n While wandering through the forest,\n" + playerName +
                    " encounters a mysterious stranger who offers them assistance.\n" +
                    "You must decide whether to trust the stranger.\n" +
                    "1 - Accept the stranger's help.\n" +
                    "2 - Politely decline and continue on your own.\n" +
                    "3 - Confront the stranger and demand answers.");

            //Use my 'checkInputValidation' to handle error input and parse 'input' to 'choice'
            int choice = checkInputValidation(input);

            //If input is invalid
            if (choice==-1) {
                //The input is invalid, so use 'continue' to back to the start of 'while' loop to get a new input
                continue;
            }

            if(choice==1){
                if(random.nextFloat()<0.7) {
                    JOptionPane.showMessageDialog(null, playerName + " is saved." +
                            "Game over.[Happy Ending]");
                }else {
                    JOptionPane.showMessageDialog(null, playerName + " is killed." +
                            "Game over.[Sad Ending]");
                }

                //Back to 'main' method and end this game
                return 1;
            }

            if(choice==2){
                JOptionPane.showMessageDialog(null, playerName + " continues your journey.");

                //Back to 'main' method and jump into sceneThree
                return 2;
            }
            if (choice==3) {
                JOptionPane.showMessageDialog(null, "The stranger offers you to play a game");

                //Back to 'main' method and jump into sceneFour
                return 3;
            }
        }
    }

    private static void sceneThree() {
        while(true){
            String input=JOptionPane.showInputDialog(null,"a river:1 swim 2 find shallow 3 raft");
            int choice=checkInputValidation(input);

            if(choice==-1){
                continue;
            }

            if(choice==1){
                JOptionPane.showMessageDialog(null,"drawn [SE]");
            }else{
                JOptionPane.showMessageDialog(null,"saved [HE]");
            }
            break;
        }
    }

    private static void sceneFour() {
        int randomNumber= random.nextInt(10)+1;
        int chance=3;
        boolean isWon=false;

        while (chance>0) {

            String message = "take a guess between 1 and 10 ";

            message += chance == 1 ? "ONE FINAL LEFT" : "still have " + chance + " tries";

            String input = JOptionPane.showInputDialog(null, message);

            //I can't use the 'checkInputValidation' because the method only think 1,2,3 are valid

            if (input==null){
                JOptionPane.showMessageDialog(null,"see you");
                System.exit(0);
            }

            int guessNumber=0;
            boolean inputValid=true;

            //Check the type
            try{
                guessNumber=Integer.parseInt(input);
            }catch (Exception e){
                inputValid=false;
            }

            //Check the range of number
            if(guessNumber<1||guessNumber>10){
                inputValid=false;
            }

            //Show notice message only in one code
            if(!inputValid) {
                JOptionPane.showMessageDialog(null, "Invalid input, please try again");
                continue;
            }

            if (guessNumber == randomNumber) {
                JOptionPane.showMessageDialog(null, "you win");
                isWon = true;
                break;
            }

            String hint = guessNumber < randomNumber ? "higher" : "lower";
            JOptionPane.showMessageDialog(null, hint);

            chance--;
        }

            if (!isWon){
                JOptionPane.showMessageDialog(null,"you died [SE]");
            }
    }

    private static boolean restartGame() {
        while (true){

            String input=JOptionPane.showInputDialog(null,"want again?[y/n]");

            if (input==null){
                JOptionPane.showMessageDialog(null,"see you");
                System.exit(0);
            }

            if (input.equals("y")||input.equals("Y")){
                return true;
            }else if (input.equals("n")||input.equals("N")){
                return false;
            }else {
                JOptionPane.showMessageDialog(null,"invalid input ,try again");
            }
        }
    }
}
