package parser;

import commands.*;
import java.util.ArrayList;

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 * 
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {
    public Parser(){}

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException{
        switch(tokens.get(0).getTokenType()){
            case USE:
            if(tokens.size() >= 4){
                return new Use(tokens.get(1).getValue(),tokens.get(3).getValue());
            }else if(tokens.size() == 3){
                return new Use(tokens.get(1).getValue(),null);
            }else{
                throw new CommandErrorException("This is an invalid USE command");
            }
            case DROP:
                if(tokens.size() > 1){
                    return new Drop(tokens.get(1).getValue());
                }else{
                    throw new CommandErrorException("This is an invalid DROP command");
                }
            case GET:
                if(tokens.size() > 1){
                    return new Get(tokens.get(1).getValue());
                }else{
                    throw new CommandErrorException("This is an invalid GET command");
                }
            case HELP:
                if(tokens.size()>2){
                    return new Help(tokens.get(1).getValue());
                }else{
                    return new Help(null);
                }
            case LOOK:
                if(tokens.size() > 2){
                    if(tokens.get(1).getTokenType() == TokenType.PREPOSITION){
                        return new Look(tokens.get(2).getValue()); 
                    }else{
                        return new Look(tokens.get(1).getValue()); 
                    }
                }else{
                    throw new CommandErrorException("This is an invalid DROP command");
                }
            case MOVE:
                return new Move(tokens.get(1).getValue());
            case QUIT:
                return new Quit();
            case STATUS:
                return new Status(tokens.get(1).getValue());
            case TALK:
                return new Talk(tokens.get(2).getValue());
            case COMBINE:
                return new Combine(tokens.get(1).getValue(),tokens.get(3).getValue());
            case VAR:
                if(tokens.size() == 3 && tokens.get(1).getValue().equals("status")){
                    return new Status(tokens.get(0).getValue());
                }
            default:
                return null;
        }
    }
}
