public class Collectibles extends Items{
    private int coinTotal, keyTotal;
    public Collectibles(double x, double y){
        super(x,y, 1);
    }

    //Coins
    public void collectCoin(){
        coinTotal++;
        this.pickupItem();
    }

    //Keys
    public void collectKey(){
        coinTotal++;
        this.pickupItem();
    }
    //Hearts
    public void collectHealth(){
       /*
       if(characters.currentHealth < characters.maxHealth){
            if(fullHeart){
                characters.currentHealth+fullHeart;
                if(characters.currentHealth>characters.maxHealth){
                    characters.currentHealth = characters.maxHealth;
                }
            }
            characters.currentHealth+halfHeart;
        }
        */
    }

}