package commands;

import gameobjects.*;

/**
 * Represents the quit command, allowing the player to exit the game.
 * 
 * <p>
 * The quit command signals the end of the game session and provides a summary of the player's
 * current status before termination.
 * </p>
 */
public class Quit extends Command {
    public Quit(){
        commandType = CommandType.QUIT;
    }

    @Override
    public String execute(GameState gameState){
        String temp_string = "Game over:\nin youre inventory you had;\n";
        for(Item i : gameState.getPlayer().getInventory()){
            temp_string += i.getName().toLowerCase()+"\n";
        }
        for(Equipment i : gameState.getPlayer().getEquipment()){
            temp_string += i.getName().toLowerCase()+"\n";
        }
        return temp_string;
    }
}
