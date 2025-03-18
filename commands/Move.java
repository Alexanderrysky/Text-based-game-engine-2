package commands;
import gameobjects.*;

/**
 * Represents the move command, allowing the player to navigate to a different room in the game world.
 * 
 * <p>
 * The move command checks if the specified direction corresponds to an available exit in the current room.
 * If a matching exit is found, the player's location is updated to the connected room.
 * </p>
 */
public class Move extends Command {
    public Move(String direction){
        value = direction;
        commandType = CommandType.MOVE;
    }

    @Override
    public String toString(){
        return "The command is of type "+commandType+" in the direction "+value;
    }

    @Override
    public String execute(GameState gameState){
        for(Exit i : gameState.getMap().getCurrentRoom().getExits()){
            if(i.getName().equals(value)){
                String id = i.getId();
                if(!gameState.getMap().getCurrentRoom().getExit(id).getHidden()){
                    gameState.getMap().setCurrentRoom(gameState.getMap().getCurrentRoom().getExit(id) .getNextRoom());
                    return "Moving towards "+value+"\n";
                }else{
                    return "No exit found in that direction.";
                }
            }
        }
        return "No exit found in that direction.";
    }
  
}
