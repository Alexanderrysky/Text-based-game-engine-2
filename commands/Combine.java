package commands;

import gameobjects.*;

public class Combine extends Command{
    protected String item1;
    protected String item2;

    static String[] item1_combine = {"ruby","string"};
    static String[] item2_combine = {"flashlight","stick"};
    static Equipment[] result = {(new Equipment("rgb1", "rgb", "a flashlight with a ruby attatched to it", false, (new UseInformation(false, "light", "r10", "ghost1", "Using the light on the room all objects become revealed to you")))),(new Equipment("fsh1","fishingrod","a fishing rod for catching fish", false,(new UseInformation(false,"fish", "lk1", "fish1","you cast your reel and after a minut feel a tugging at the rod.you quickly pull having to use more force then expected.you pull out a fish and see it flopping on the floor"))))};
    public Combine(String item1, String item2){
        this.item1 = item1;
        this.item2 = item2;
        commandType = CommandType.COMBINE;
    }

    @Override
    public String toString(){
        return "The command is of type "+commandType+" And tries to combine "+item1+" with "+item2;
    }

    @Override
    public String execute(GameState gameState){
        int count = 0;
        if(gameState.getPlayer().hasItem(item1) && gameState.getPlayer().hasItem(item2)){
            for(String i : item1_combine){
                if((i.equals(item1) && item2_combine[count].equals(item2)) || (i.equals(item2) && item2_combine[count].equals(item1))){
                    gameState.getPlayer().addEquipment(result[count]);
                    gameState.getPlayer().RemoveItemFromInventory(gameState.getPlayer().getItem(item1));
                    gameState.getPlayer().RemoveItemFromInventory(gameState.getPlayer().getItem(item2));
                    return "Equipment: "+result[count].getName()+" created by combining "+item1+" and "+item2;
                }
                count++;
            }
            return "you cannot combine "+item1+" and "+item2;
        }else{
            return "You do not have the neccesary items";
        }
    }
}
