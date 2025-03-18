package gameobjects;

public class Equipment extends GameObject implements Usable {
    protected UseInformation useInformation;
    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation){
        super(id,name,description,hidden);
        this.useInformation = useInformation;
    }
   
    /**
        * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
        * and the associated use information.
        *
        * @return a string describing the equipment
        */
    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }

    @Override
    public void setUseInformation(UseInformation useInformation){
        this.useInformation = useInformation;
    }

    @Override
    public UseInformation getUseInformation(){
        return this.useInformation;
    }

    public String use(GameObject target, GameState gameState){
        useInformation.setUsed(true);
        for(GameObject i : gameState.getMap().getCurrentRoom().getAll()){
            if(i.getId().equals(useInformation.getResult())){
                i.setHidden(false);
                for(NPC j : gameState.getMap().getCurrentRoom().getNpcs()){
                    if(j.getRelatedObjectId().equals(target.getId())){
                        j.setHelped(true);
                    }
                }
            }
        }
        return useInformation.getMessage();
    }
}


