package utils;

import gameobjects.*;
import java.io.*;
import java.nio.file.*;

/**
 * Utility class for parsing a game state from a file.
 * 
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, rooms, items, equipment, features, and exits.
 * </p>
 */
public class GameStateFileParser {
    public GameStateFileParser(){}

    public static GameState parse(String filename){
        Path file = Paths.get(filename);
        String s = "";
        String line;
        try{
            InputStream input = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.READ));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            while((line = reader.readLine()) != null) {
                s += line + "\n";
            }
            s = s.substring(0,s.length() - 1);
            reader.close();
            input.close();
        }catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return switching(s);
    }
    
    public static GameState switching(String s){
        //s = s.replaceAll("\\s+", " ");
        String[] lines = s.split("\n");
        Map map = new Map();
        Player player = new Player();
        for(String i : lines){
            System.out.println(i);
            i = i.trim();
            String[] contents = i.split(":");
            if(contents.length < 2){
                return new GameState(map, player);
            }
            String[] field = contents[1].split(",");
            switch(contents[0]){
                case "player":
                    player = new Player(contents[1]);
                    break;
                case "map":
                    map = new Map();
                    break;
                case "room":
                    Room room = new Room(field[0],field[1],field[2],booleaniser(field[3]));
                    map.addRoom(room);
                    map.setCurrentRoom(field[0]);
                    break;
                case "item":
                    Item item = new Item(field[0],field[1],field[2],booleaniser(field[3]));
                    map.getCurrentRoom().addItem(item);
                    break;
                case "container":
                    Container container = new Container(field[0],field[1],field[2],booleaniser(field[3]));
                    map.getCurrentRoom().addFeature(container);
                    break;
                case "exit":
                    Exit exit = new Exit(field[0],field[1],field[2],field[3],booleaniser(field[4]));
                    map.getCurrentRoom().addExit(exit);
                    break;
                case "equipment":
                    Equipment equipment = new Equipment(field[0], field[1], field[2],booleaniser(field[3]), new UseInformation(false, field[4], field[5], field[6], field[7]));
                    map.getCurrentRoom().addEquipment(equipment);
                    break;
                case "npc":
                    NPC npc = new NPC(field[0],field[1],field[2],booleaniser(field[3]), field[4],booleaniser(field[5]),field[6],field[7]);
                    map.getCurrentRoom().addNpc(npc);
                    break;
                case "feature":
                    Feature feature = new Feature(field[0],field[1],field[2],booleaniser(field[3]));
                    map.getCurrentRoom().addFeature(feature);
                    break;
                default:
                    System.out.println("this is used");
                    return new GameState(map,player);
            }
        }
        return new GameState(map,player);
    }

    public static boolean booleaniser(String value){
        if(value.equals("false")){
            return false;
        }else{
            return true;
        }
    }
   
}
