package game.carta;

public abstract class CartaEntrenador extends ACarta{
    private String Name;
    private String Description;

    public CartaEntrenador(){
        this("","");
    }

    public CartaEntrenador(String name, String desc) {
        Name=name;
        Description=desc;
    }

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

    public void effect(){

    }

}
