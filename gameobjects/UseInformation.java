package gameobjects;

public class UseInformation {
    protected boolean isUsed;
    protected String action;
    protected String target;
    protected String result;
    protected String message;
    public UseInformation(boolean isUsed,String action,String target,String result,String message){
        this.isUsed = isUsed;
        this.action = action;
        this.target = target;
        this.result = result;
        this.message = message;
    }

    /**
     * Returns a string representation of the usage information, including all attributes.
     *
     * @return a string describing the usage information
     */
    @Override
    public String toString() {
        return "UseInformation{" +
                "isUsed=" + isUsed +
                ", action='" + action + '\'' +
                ", target='" + target + '\'' +
                ", result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
    
    public boolean isUsed(){
        return isUsed;
    }
    public void setUsed(boolean isUsed){
        this.isUsed = isUsed;
    }
    public String getAction(){
        return action;
    }
    public void setAction(String action){
        this.action = action;
    }
    public String getTarget(){
        return target;
    }
    public void setTarget(String target){
        this.target = target;
    }
    public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result = result;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}