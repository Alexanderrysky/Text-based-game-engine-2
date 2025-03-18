package commands;

import gameobjects.*;

/**
 * Represents an abstract command that can be executed within the game.
 * 
 * <p>
 * Subclasses should define specific types of commands and their behavior by 
 * implementing the {@link #execute(GameState)} method.
 * </p>
 */
public abstract class Command {
    public CommandType commandType;
    public String value;
    public Command(){}

    public abstract String execute(GameState gameState);

}
