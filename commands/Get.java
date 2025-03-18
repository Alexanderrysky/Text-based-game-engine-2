package commands;

import gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 * 
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
public class Get extends Command {
    public Get(String item){
        value = item;
        commandType = CommandType.GET;

    }

    @Override
    public String toString(){
        return "They type of command is: "+commandType+"\nThe target item is: "+value;
    }

    @Override
    public String execute(GameState gameState){
        if(gameState.getMap().getCurrentRoom().hasItem(value) && !gameState.getMap().getCurrentRoom().getItemByName(value).getHidden()){
            if(!gameState.getPlayer().hasItem(value)){
                Item temp_item = gameState.getMap().getCurrentRoom().getItemByName(value);
                gameState.getMap().getCurrentRoom().RemoveItem(temp_item);
                gameState.getPlayer().addItem(temp_item);
                return "You pick up: "+value;
            }else{
                return "You already have "+value;
            }
        }else if(gameState.getMap().getCurrentRoom().hasEquipment(value) && !gameState.getMap().getCurrentRoom().getEquipmentByName(value).getHidden()){
            if(!gameState.getPlayer().hasEquipment(value)){
                Equipment temp_equipment = gameState.getMap().getCurrentRoom().getEquipmentByName(value);
                gameState.getMap().getCurrentRoom().RemoveEquipment(temp_equipment);
                gameState.getPlayer().addEquipment(temp_equipment);
                return "You pick up: "+value;
            }else{
                return "You already have "+value;
            }
        }else{
            return "No "+value+" to get.";
        }
    }
   
}
