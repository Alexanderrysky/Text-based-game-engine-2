package gameobjects;

import java.util.ArrayList;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {
    protected ArrayList<Room> rooms;
    protected Room current;
    public Map(){
        rooms = new ArrayList<>();
        Room current = null;
    }

  
    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }

    public Room getCurrentRoom(){
        return current;
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public void setCurrentRoom(String roomId){
        for (Room r : rooms){
            if(r.getId().equals(roomId)){
                current = r;
            }
        }
    }
    public ArrayList<Room> getRooms(){
        return rooms;
    }
}