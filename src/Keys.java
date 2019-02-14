public class Keys extends Collectibles{
    private String imagePath="whatever the fuck it is";
    private int id;

    public String getImagePath(){
        return imagePath;
    }

    public int getID(){
        return id;
    }

    public void keyIncrease(){
        inventory.addKey();
        this.pickupItem();
    }

    public Keys(int x, int y){
        super(x,y);
        id = 1; //whatever the fuck this one is
    }
}
