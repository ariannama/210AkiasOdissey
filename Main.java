public class Main {
    public static void main(String[] args) {
        for(int floor = 1; floor < 5; floor++){
            System.out.println("Floor " + floor);
            room r = new StandardRoom(floor);
            r.init();
            System.out.println();
        }
    }  
}
