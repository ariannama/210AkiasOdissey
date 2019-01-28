import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class Character extends Sprite 
{
    
    private Texture skin;
    private int maxHealth;
    private int currentHealth;
    private int baseDamage;
    private int moveSpeed;

    //Constructor with preset stats
    public Character(Texture t) 
    {
        maxHealth = 10;
        baseDamage = 10;
        moveSpeed = 50;
    }

    //Constructor to set your own stats
    public Character(int moveSpeed, int baseDamage, int currentHealth, double percentageLuck) {
        this.moveSpeed = moveSpeed;
        this.baseDamage = baseDamage;
        this.currentHealth = currentHealth;
    }

    public void increaseHealth(int healthGain) {
        currentHealth += healthGain;
    }
    public void loseHealth(int healthLoss){
        currentHealth -= healthLoss;
    }
    public void increaseDamage(int dmgIncrease){
        baseDamage += dmgIncrease;
    }
    public void increaseMoveSpeed(int moveSpeedIncrease){
        moveSpeed += moveSpeedIncrease;
    }
    public void increaseLuck(double luckIncrease) {
        percentageLuck += luckIncrease;
    }
    
    /* Implemented later
    public void setWeapon(Weapon w){
        currentWeapon = w;
    }
    public void addItem(Item i){
        itemList.add(i);
    }
    */
    public int getCurrentHealth(){
        return currentHealth;
    }
    public int getMaxHealth(){return maxHealth;}
    public int getBaseDamage(){
        return baseDamage;
    }
    public int getMoveSpeed(){
        return moveSpeed;
    }
    public double getLuck(){
        return percentageLuck;
    }

    @Override
    public String toString(){
      return "Name: "+ charName + "\nLuck: " + percentageLuck + "\nCurrent Health: "+ currentHealth + "\nMove Speed " + moveSpeed + "\nBase Damage: " + baseDamage;
    }
}
