package commands;

import gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, 
 * provide details about a specific item, or show the player's general status.
 * </p>
 */
public class Status extends Command {
    public Status(String topic){
        value = topic;
        commandType = CommandType.STATUS;
    }

    @Override
    public String toString(){
        return "the command is of type: "+commandType+" and its topic is: "+value;
    }

    @Override
    public String execute(GameState gameState){
        String temp_string = "";
        if(value.equals("inventory")){
            for(Item i : gameState.getPlayer().getInventory()){
                temp_string += i.getName() + "\n";
            }
            for(Equipment i : gameState.getPlayer().getEquipment()){
                temp_string += i.getName() + "\n";
            }
            return temp_string;
        }else if(value.equals("player")){
            temp_string = "";
            for(Item i : gameState.getPlayer().getInventory()){
                temp_string += i.getName() + "\n";
            }
            if(gameState.getMap().getCurrentRoom() != null){
                return "the Player is currently in room "+gameState.getMap().getCurrentRoom().getName()+" and he is carrying the items:\n"+temp_string;
            }else{
                return "the Player is carrying the items:\n"+temp_string;
            }
        }else if(value.equals("map")){
            return mapper(gameState);
        }else if (value.equals("score")){
            return calculator(gameState);
        }else if(gameState.getPlayer().hasEquipment(value)){
            return gameState.getPlayer().getEquipment(value).getDescription();
        }else if(gameState.getPlayer().hasItem(value)){
            return gameState.getPlayer().getItem(value).getDescription();
        }else if(gameState.getMap().getCurrentRoom() != null && gameState.getMap().getCurrentRoom().hasNpc(value)){
            return gameState.getMap().getCurrentRoom().getNpcByName(value).getDescription();
        }else{
            return temp_string;
        }
    }

    private String mapper(GameState gameState){
        String builder = "|";
        int count = 0;
        for(Room i : gameState.getMap().getRooms()){
            if(count == 4){
                builder += "\n|";
                count = 0;
            }
            if(i==gameState.getMap().getCurrentRoom()){
                builder += "X|";
            }else{
                builder += i.getName().charAt(0)+"|";
            }
            count++;
        }
        return builder;
    }

    private String calculator(GameState gameState){
        int count = 0;
        for(Item i : gameState.getPlayer().getInventory()){
            count += 2;
        }
        for(Equipment i : gameState.getPlayer().getEquipment()){
            count += 1;
        }
        return String.valueOf(count);
    }
}
