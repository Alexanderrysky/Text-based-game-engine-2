package gameobjects;

import java.util.ArrayList;

/**
 * Represents a room in the game, which is a type of {@code GameObject}.
 * 
 * <p>
 * Rooms can have items, equipment, features, and exits. They also manage navigation
 * and interactions within the game world.
 * </p>
 */
public class Room extends GameObject {
    protected ArrayList<Equipment> equipment;
    protected ArrayList<Item> items;
    protected ArrayList<Feature> features;
    protected ArrayList<Exit> exits;
    protected ArrayList<GameObject> gameobjects;
    protected ArrayList<NPC> npcs;
    public Room(String id, String name, String description, boolean hidden){
        super(id,name,description,hidden);
        equipment = new ArrayList<>();
        items = new ArrayList<>();
        features = new ArrayList<>();
        exits = new ArrayList<>();
        gameobjects = new ArrayList<>();
        npcs = new ArrayList<>();
    }
    public Room(){
        //i dont know what to put here
    }


    /**
     * Returns a string representation of the room, including its contents and description.
     *
     * @return a string describing the room
     */
    @Override
    public String toString() {
        String out = "[" + id + "] Room: " + name + "\nDescription: " + description + "\nIn the room there is: ";
        for (Item i : this.items) {
            out += i + "\n";
        }
        for (Equipment e : this.equipment) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exits) {
            out += e + "\n";
        }
        return out + "\n";
    }

    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setDescription(String description){
        this.description = description;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getDescription(){
        return description;
    }
    public ArrayList<Exit> getExits(){
        return exits;
    }
    public void addExit(Exit exit){
        exits.add(exit);
        gameobjects.add(exit);
    }
    public void addNpc(NPC npc){
        npcs.add(npc);
        gameobjects.add(npc);
    }
    public boolean hasNpc(String npcName){
        for(NPC i : npcs){
            if(i.getName().equals(npcName)){
                return true;
            }
        }
        return false;
    }
    public NPC getNpcByName(String npcName){
        for(NPC i : npcs){
            if(i.getName().equals(npcName)){
                return i;
            }
        }
        return null;
    }
    public ArrayList<NPC> getNpcs(){
        return npcs;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public Item getItem(String id){
        for(Item i : items){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    public Item getItemByName(String name){
        for(Item i : items){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
    public Feature getFeatureByName(String name){
        for(Feature i : features){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
    public ArrayList<Equipment> getEquipments(){
        return equipment;
    }
    public Equipment getEquipmentByName(String name){
        for(Equipment i : equipment){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
    public Equipment getEquipment(String id){
        for(Equipment i : equipment){
            if(i.getName().equals(id)){
                return i;
            }
        }
        return null;
    }
    public Exit getExit(String id){
        for(Exit i : exits){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    public void addEquipment(Equipment equipment){
        this.equipment.add(equipment);
        gameobjects.add(equipment);
    }
    public void RemoveEquipment(Equipment equipment){
        this.equipment.remove(equipment);
        gameobjects.remove(equipment);
    }
    public Feature getFeature(String id){
        for(Feature i : features){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    public void addItem(Item item){
        items.add(item);
        gameobjects.add(item);
    }
    public void RemoveItem(Item item){
        items.remove(item);
        gameobjects.remove(item);
    }
    public ArrayList<Feature> getFeatures(){
        return features;
    }
    public ArrayList<GameObject> getAll(){
        return gameobjects;
    }
    public GameObject getGameObjectbyName(String gameObject){
        for(GameObject i : gameobjects){
            if(i.getName().equals(gameObject)){
                return i;
            }
        }
        return null;
    }
    public GameObject getGameObjectbyId(String gameObject){
        for(GameObject i : gameobjects){
            if(i.getId().equals(gameObject)){
                return i;
            }
        }
        return null;
    }
    public void addFeature(Feature feature){
        features.add(feature);
        gameobjects.add(feature);
    }

    public boolean hasItem(String itemName){
        for(Item i : items){
            if(i.getName().equals(itemName)){
                return true;
            }
        }
        return false;
    }
    public boolean hasEquipment(String name){
        for(Equipment i : equipment){
            if(i.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
