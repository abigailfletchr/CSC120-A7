public class Cafe extends Building {

    /**
     * nCoffeeOunces is number of ounces of coffee in the cafe stock
     * nSugarPackets is number of sugar packets in the cafe stock
     * nCreams is the number of creamers in the cafe stock
     * nCups is the number of cups in the cafe stock
     */
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
        super(name, address, nFloors);
        this.nCoffeeOunces = 60;
        this.nSugarPackets = 35;
        this.nCreams = 35;
        this.nCups = 75;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * An overloaded constructor for the Cafe class
     * @param name the name of the building
     */
    public Cafe(String name) {
        super(name, "No specified cafe address", 3);
        this.nCoffeeOunces = 60;
        this.nSugarPackets = 35;
        this.nCreams = 35;
        this.nCups = 75;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * An overloaded constructor for the Cafe class
     * @param name the name of the building
     * @param address the address of the building
     * @param nFloors the number of floors in the building
     * @param nCoffeeOunces the amount of coffee ounces in stock at the cafe
     * @param nSugarPackets the amount of sugar packets in stock at the cafe
     * @param nCreams the amount of creamers in stock at the cafe
     * @param nCups the number of cups in stock at the cafe
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
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
        if(this.nCoffeeOunces-size < 0 && this.nSugarPackets-nSugarPackets < 0 && this.nCreams-nCreams < 0 && this.nCups-1 < 0){
            this.restock(60, 35, 35, 75);
        } else{
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups = nCups - 1;
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

    /**
     * Method that displays the options the Cafe class provides.
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee(s, sp, c) \n + restock(o, sp, c, cu)");
    }

    public static void main(String[] args) {
        new Cafe("Compass Cafe", "1 Chapin Way", 3);
    }
    
}
