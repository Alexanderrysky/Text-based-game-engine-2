package parser;

import java.util.ArrayList;

/**
 * The {@code Tokeniser} class is responsible for converting a string input into a list of tokens
 * that can be parsed into commands by the game.
 * 
 * <p>
 * The tokeniser identifies keywords, variables, and special symbols, assigning each a {@code TokenType}.
 * </p>
 */
public class Tokeniser {
    protected ArrayList<Token> tokens;
    public Tokeniser(){
        tokens = new ArrayList<>();
    }

    public ArrayList<Token> getTokens(){
        return tokens;
    }

    public String sanitise(String s){
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return s;
    }
    public void tokenise(String s){
        tokens.clear();
        s = sanitise(s);
        String[] s_split = s.split(" ");
        for (String value : s_split) {
            tokens.add(new Token(typer(value),value));
            }
        tokens.add(new Token(TokenType.EOL));
    }

    public static TokenType typer(String value){
        switch(value){
            case "on" -> {
                return TokenType.PREPOSITION;
            }
            case "with" -> {
                return TokenType.PREPOSITION;
            }
            case "using" -> {
                return TokenType.PREPOSITION;
            }
            case "at" -> {
                return TokenType.PREPOSITION;
            }
            case "use" -> {
                return TokenType.USE;
            }
            case "drop" -> {
                return TokenType.DROP;
            }
            case "get" -> {
                return TokenType.GET;
            }
            case "look" -> {
                return TokenType.LOOK;
            }
            case "status" -> {
                return TokenType.STATUS;
            }
            case "help" -> {
                return TokenType.HELP;
            }
            case "quit" -> {
                return TokenType.QUIT;
            }
            case "move" -> {
                return TokenType.MOVE;
            }
            case "talk" -> {
                return TokenType.TALK;
            }
            case "combine" ->{
                return TokenType.COMBINE;
            }
            default -> {
                return TokenType.VAR;
            }
        }

    } 
}

