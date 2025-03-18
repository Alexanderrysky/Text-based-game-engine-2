package commands;

import gameobjects.*;

/**
 * Represents the look command, allowing the player to examine various elements of the game world.
 * 
 * <p>
 * The look command can provide details about the current room, its exits, features, or specific items and equipment.
 * Hidden objects are not included in the output unless explicitly revealed.
 * </p>
 */
public class Look extends Command {
    public Look(String target){
        value = target;
        commandType = CommandType.LOOK;
    }

    @Override
    public String toString(){
        return "This look command is "+commandType+"\nThe target is "+value;
    }

    @Override
    public String execute(GameState gameState){
        String temp_string = "";
        switch(value){
            case "room":
                temp_string = "The Room Description:\n";
                temp_string += gameState.getMap().getCurrentRoom().getDescription();
                temp_string += " This is everything you see in the room:\n";
                for(GameObject i : gameState.getMap().getCurrentRoom().getAll()){
                    if(!i.getHidden()){
                        temp_string += i.getName()+": "+i.getDescription()+"\n";
                    }
                }
                break;
            case "exits":
                temp_string = "The available exits are:\n";
                for(Exit i : gameState.getMap().getCurrentRoom().getExits()){
                    if(!i.getHidden()){
                        temp_string += i.getDescription()+"\n";
                    }
                }
                break;
            case "features":
                temp_string = "You also see:";
                for(Feature i : gameState.getMap().getCurrentRoom().getFeatures()){
                    if(!i.getHidden()){
                        temp_string += "a "+i.getName().toLowerCase()+"\n";
                    }
                }
                break;
            default:
            for(GameObject i : gameState.getMap().getCurrentRoom().getAll()){
                if(i.getName().equals(value) && !i.getHidden()){
                    return i.getDescription();
                }
            }
        }
        return temp_string;
    }
}
