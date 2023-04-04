public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * The constructor for the Cafe class extending the Building class
     * @param name the name of the building
     * @param address the address of the building
     * @param nFloors the number of the floors of the building
     */
    public Cafe(String name, String address, int nFloors) {
        // System.out.println("You have built a cafe: ☕");
        super(name, address, nFloors);
        this.nCoffeeOunces = 60;
        this.nSugarPackets = 35;
        this.nCreams = 35;
        this.nCups = 75;
    }
    
    /**
     * Method that decreases the amount of sugar packets, ounces of coffee, 
     * creamer, and coffee cups as a cup of coffee is sold. The method calls 
     * to the restock method as well.
     * @param size the coffee size (in oz.)
     * @param nSugarPackets the amount of sugar packets used
     * @param nCreams the amount of creamer used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces-size > 0 && this.nSugarPackets-nSugarPackets > 0 && this.nCreams-nCreams > 0 && this.nCups-1 > 0){
            // then i can make a coffee
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups = nCups - 1;
        } else{
            this.restock(60, 35, 35, 75);
        }
    }

    /**
     * Method that restocks the coffee, sugar packets, creamer, and cups when it gets to 0. 
     * This method is called from the sellCoffee() method
     * @param nCoffeeOunces the amount of coffee
     * @param nSugarPackets the amount of sugar packets
     * @param nCreams the amount of creamer
     * @param nCups the amount of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    public static void main(String[] args) {
        new Cafe("Compass Cafe", "1 Chapin Way", 3);
    }
    
}
