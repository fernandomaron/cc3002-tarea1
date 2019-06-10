package game.carta;

public abstract class ACartaEntrenador extends ACarta{
    private String Name;
    private String Description;

    public String getName(){
        return this.Name;
    }

    public String getDescription(){
        return  this.Description;
    }

    public void setName(String s){
        this.Name=s;
    }

    public void setDescription(String s){
        this.Description=s;
    }
}
