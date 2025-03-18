package commands;

import gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 * 
 * <p>
 * The help command displays information on how to play the game, including details about 
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {
    public Help(String topic){
        if(topic == null){
            value = "null";
        }else{
            value = topic;
        }
        commandType = CommandType.HELP;
    }
    

    @Override
    public String execute(GameState gameState){
        switch(value){
            case "move":
                return "MOVE Command: Use the 'move' command to move between rooms.\n you specify the direction you want to move(north,west,east,south) after typing the 'move' command";
            case "null":
                return "Welcome to the game!\nHere are the options you can use for help\nto see this list again - Help\nTo move through the map - MOVE\nTo use and item - USE\nTo pick up an item or equipment from a room - GET\nTo remove an item or equipment from your inventory and leave it in a room - DROP\nTo see the description of an Object or literaly almost anything - LOOK\nTo a command to check the player's current status - STATUS\nTo quit the game - QUIT\nTo find help on a specific topic type - HELP";
            case "drop":
                return "DROP Command: the drop command allows you to drop an item in a room removing it from your inventroy and storing said item in the room";
            case "get":
                return "GET Command: the get command allows the user to pick up an item from a room and store it in their inventory";
            case "look":
                return "LOOK Command: the look command allows the user to get the description of a game object in the users in the current room";
            case "quit":
                return "QUIT Command: allows the user to quit the game";
            case "status":
                return "STATUS Command: allows the user to see the status of the player,map or specific item in their inventory";
            case "talk":
                return "TALK Command: allows the user to talk to a npc";
            case "USE":
                return "USE Command: allows the user to use a piece of equipment in their inventory on a gameObject in the current room that they are in";
            default:
                return "No help available for the topic: "+value;

        }
    }

    @Override
    public String toString(){
        return "The HELP method is called on topic "+value;
    }
  
}
