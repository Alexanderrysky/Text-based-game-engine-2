package gameobjects;

public class Container extends Feature {
    public Container(String id, String name, String description, boolean hidden){
        super(id,name,description,hidden);
    }

    
    /**
     * Returns a string representation of the container.
     *
     * @return a string containing the container's id, name, description, and hidden status
     */
    @Override
    public String toString() {
        return "Container {" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", hidden=" + getHidden() +
                '}';
    
    }

    @Override
    public String getName(){
        return name;
    }
 
}