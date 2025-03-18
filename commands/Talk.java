package commands;

import gameobjects.*;

public class Talk extends Command {
    public Talk(String topic){
        value = topic;
    }

    @Override
    public String toString(){
        return "the command is of type: "+commandType+" and its topic is: "+value;
    }

    @Override
    public String execute(GameState gameState){
        if(gameState.getMap().getCurrentRoom().hasNpc(value) && !gameState.getMap().getCurrentRoom().getNpcByName(value).getHidden()){
            return gameState.getMap().getCurrentRoom().getNpcByName(value).getDialogue();
        }
        return value + " isnt in this room";
    }
}