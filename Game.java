
import commands.*;
import gameobjects.*;
import java.util.Scanner;
import parser.*;
import utils.*;


public class Game {
    static GameState gameState;
    static Scanner user_input;
    static Parser parser;
    static Tokeniser tokeniser;
    public Game(){
    }
    public static void main(String[] args){
        setup();
        start();
    }

    public static void setup(){
        gameState = GameStateFileParser.parse("Game.txt");
        gameState.getMap().setCurrentRoom("r1");
        user_input = new Scanner(System.in);
        parser = new Parser();
        tokeniser = new Tokeniser();
    }

    public static void start(){
        System.out.println("Welcome to the game. Lets start your adventure");
        String choice = "";
        while(!choice.equals("quit")){
            try{
            choice = user_input.nextLine();
            tokeniser.tokenise(choice);
            Command command = parser.parse(tokeniser.getTokens());
            if(command == null){
                System.out.println("Invalid command");
            }else{
                turn(command);
            }
            if(gameState.getPlayer().hasItem("ectoplasm")){
                System.out.println("Good job adventurer youve solved every puzzle you total score was:\n"+(new Status("score")).execute(gameState)+"\n.... well see you");
                choice = "quit";
            }
            } catch (CommandErrorException e){
                System.out.println("Invalid commant");
            }
        }
    }

    public static void turn(Command command){
        System.out.println(command.execute(gameState));
    }
}
