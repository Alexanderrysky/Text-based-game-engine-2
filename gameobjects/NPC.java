package gameobjects;

public class NPC extends GameObject {
    protected String dialogue;
    protected boolean helped;
    protected String helped_dialogue;
    protected String relatedObjectId;
    public NPC(String id, String name, String description, boolean hidden,String dialogue,boolean helped,String helped_dialogue,String relatedObjectId){
        super(id,name,description,hidden);
        this.dialogue = dialogue;
        this.helped = helped;
        this.helped_dialogue = helped_dialogue;
        this.relatedObjectId = relatedObjectId;
    }

    @Override
    public String toString(){
        return "This NPC: "+name+". Hidden: "+hidden;
    }

    @Override
    public String getName(){
        return name;
    }

    public String getDialogue(){
        if(helped){
            return helped_dialogue;
        }else{
            return dialogue;
        }
    }

    public void setHelped(boolean bool){
        helped = bool;
    }

    public String getRelatedObjectId(){
        return relatedObjectId;
    }
}