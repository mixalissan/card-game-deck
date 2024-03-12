
public class card{

    String imagePath;
    String name;
    int ID;

    public card(String imagePath, String name, int ID){
        this.imagePath = imagePath;
        this.name = name;
        this.ID = ID;
    }


    int getID(){
        return this.ID;
    }

    String getName(){
        return this.name;
    }

    String getPath(){
        return this.imagePath;
    }

}

