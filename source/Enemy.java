import org.jsfml.graphics.Texture;

public class Enemy extends Character {
        protected final String ID;
        protected int x;
        protected int y;
        protected int range;
        protected Player player;
		protected boolean alive = true;

        public Enemy(Texture t, String ID, int dmg, int mS, int maxH)
        {
            super(t, dmg, mS, maxH);
            this.ID = ID;
            this.range = range;
            //this.player = player;
        }

        //if PLAYER within SIGHT move within RANGE to ATTACK,
        //else WANDER(move to random adjacent tile)

        //Enemy can always see player and will move within range to attack

        public void updatePos()
        {
            //updates pos of enemys within the arean
        }

        public void takeDamage() {
            currentHealth = currentHealth - player.getPlayerDamage();
           // getSprite().setTexture(Paths.get("../images/");
            // getSprite().setTexture(texture)
            if(currentHealth == 0) {
				alive = false;
                getSprite().setPosition(4000,4000);
            }
        }


		public boolean getAlive(){
			return alive;
		}
		
        public void attack(){}

        public void move(){}

        public void collision(){
        }

}