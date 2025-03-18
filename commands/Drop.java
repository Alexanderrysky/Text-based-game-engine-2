package commands;
import gameobjects.*;

/**
 * Represents the drop command, allowing the player to drop an item from their inventory into the current room.
 * 
 * <p>
 * This command checks if the player possesses the specified item and, if so, removes it from their inventory
 * and adds it to the current room. If the player does not have the item, an error message is returned.
 * </p>
 */
public class Drop extends Command{
    public Drop(String item){
        value = item;
        commandType = CommandType.DROP;
    }
    @Override
    public String execute(GameState gameState){
        if(gameState.getPlayer().hasItem(value)){
            Item temp_item = gameState.getPlayer().getItem(value);
            gameState.getPlayer().RemoveItemFromInventory(temp_item);
            gameState.getMap().getCurrentRoom().addItem(temp_item);
            return "You drop: "+value;
        }else if(gameState.getPlayer().hasEquipment(value)){
            Equipment temp_equipment = gameState.getPlayer().getEquipment(value);
            gameState.getPlayer().RemoveEquipment(temp_equipment);
            gameState.getMap().getCurrentRoom().addEquipment(temp_equipment);
            return "You drop: "+value;
        }else{
            return "You cannot drop "+value;
        }
    }

    @Override
    public String toString(){
        return "Type of drop command: "+commandType+"\nthe current item to be dropped is: "+value;
    }

   
}
