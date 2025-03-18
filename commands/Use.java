package commands;

import gameobjects.*;

/**
 * Represents the use command, allowing the player to use equipment on a specific target in the game.
 * 
 * <p>
 * The use command checks if the player has the specified equipment and whether it can interact with
 * the target. The target can be a feature, item, or the current room, depending on the game context.
 * </p>
 */
public class Use extends Command {
    String equipmentName;
    public Use(String equipmentName, String target){
        this.equipmentName = equipmentName;
        value = target;
        commandType = CommandType.USE;
        System.out.println(equipmentName+value);
    }

    @Override
    public String toString(){
        return "You have attempted to use the "+equipmentName+ " on "+value;
    }

    @Override
    public String execute(GameState gameState){
        if(gameState.getPlayer().hasEquipment(equipmentName)){
            if(!gameState.getPlayer().getEquipment(equipmentName).getUseInformation().isUsed()){
                if(gameState.getMap().getCurrentRoom().getGameObjectbyName(value) != null && gameState.getPlayer().getEquipment(equipmentName).getUseInformation().getTarget().equals(gameState.getMap().getCurrentRoom().getGameObjectbyName(value).getId())){
                    return gameState.getPlayer().getEquipment(equipmentName).use(gameState.getMap().getCurrentRoom().getGameObjectbyName(value), gameState);
                }else if(gameState.getPlayer().getEquipment(equipmentName).getUseInformation().getTarget().equals(gameState.getMap().getCurrentRoom().getId())){
                    return gameState.getPlayer().getEquipment(equipmentName).use(gameState.getMap().getCurrentRoom(), gameState);
                }else{
                    return "Invalid use target";
                }
            }else{
                return "You have already used "+equipmentName;
            }
        }else{
            return "You do not have "+equipmentName;
        }
    }
}

