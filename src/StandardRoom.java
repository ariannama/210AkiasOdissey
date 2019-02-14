import java.util.Random;

public class StandardRoom extends room{

    private int enemyCount, rockCount, chestCount, coinCount, fireCount, keyCount, halfHeart, fullHeart, heartCount;
    private int maxEnemy = 2, maxChest = 1, maxCoin = 4, maxKey = 1, floor;
    private Random rand;
    private int holder, heart;
    private String[][] roomTile;
    private String Path = "  ", Chest = "ch", Enemy = "e ", Coin = "c ", Fire = "f ", Key = "k ", HalfHeart = "hh", FullHeart = "fh", Rock = "r ";
    public StandardRoom(int floor){
        super();
        roomTile = super.getRoomTile();
        maxEnemy += floor;
        spawn();
    }

    public void spawn(){
            for(int y = 0; y < 7; y++){
                for(int x = 0; x < 11; x++){
                    if(x != 5 && y != 3){
                        rand = new Random();
                        holder = rand.nextInt(1000) + 1;
                        if(holder <= 700){
                            roomTile[x][y] = Path;
                        }
                        else if(holder > 700 && holder < 750){
                            if(enemyCount < maxEnemy){
                                roomTile[x][y] = Enemy;
                                enemyCount++;
                            }
                            else
                                roomTile[x][y] = "  ";
                        }
                        else if(holder >= 750 && holder < 850){
                            roomTile[x][y] = Rock;
                            rockCount++;
                        }
                        else if(holder >= 850 && holder < 950){
                            roomTile[x][y] = Fire;
                            fireCount++;
                        }
                        else if(holder >= 950 && holder <= 990){
                            if(coinCount < maxCoin){
                                roomTile[x][y] = Coin;
                                coinCount++;
                            }
                            else
                                roomTile[x][y] = Path;
                        }
                        else if (holder >990 && holder < 999){
                            if(heartCount < 1){
                                Random heartRand = new Random();
                                heart = heartRand.nextInt(100) + 1;
                                if(heart <= 30){
                                    roomTile[x][y] = FullHeart;
                                    fullHeart++;
                                }
                                else{
                                    roomTile[x][y] = HalfHeart;
                                    halfHeart++;
                                }
                                heartCount++;
                            }
                            else
                                roomTile[x][y] = Path;
                        }
                        else if(holder == 999){
                            if(keyCount < maxKey){
                                roomTile[x][y] = Key;
                                keyCount++;
                            }
                            else
                                roomTile[x][y] = Path;
                        }
                        else{
                            if(chestCount < maxChest){
                                roomTile[x][y] = Chest;
                                chestCount++;
                            }
                            else
                                roomTile[x][y] = Path;
                        }
                    }
                    else
                        roomTile[x][y] = Path;
                }
            }
        }

    @Override
    public void init(){
        for(int y = 0; y < 7; y++){
            for(int x = 0; x < 11; x++){
                System.out.print(roomTile[x][y]);
            }
            System.out.println();
        }
    }
}


    

