import java.util.ArrayList;
import java.util.Hashtable;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        myMap.addBuilding(new Library("Forbes", "20 West St Northampton, MA  01060", 5));
        Hashtable<String, Boolean> col = new Hashtable<String, Boolean>();
        col.putIfAbsent("The Key to Theatre", true);
        col.putIfAbsent("Theory of Evolution", true);
        col.putIfAbsent("Organic Chemistry II", true);
        myMap.addBuilding(new Library("Josten Library", "100 Elm St Northampton, MA  01063", 6, col));
        myMap.addBuilding(new Library("Young Library", "4 Tyler Ct, Northampton, MA 01060", 4, 50));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm St, Northampton, MA 01063", 2, 35));

        myMap.addBuilding(new House("Franklin King House", true, true));
        myMap.addBuilding(new House("Laura Scales House", "Northampton, MA 01060", 4, true, true));
        myMap.addBuilding(new House("Jordan House", "Northampton, MA 01063", 3, false));
        myMap.addBuilding(new House("Emerson House", "Northampton, MA 01063", 3, false));

        myMap.addBuilding(new Cafe("Compass Cafe"));
        myMap.addBuilding(new Cafe("Shelbourne Falls Coffee Roasters", "273 Main St, Northampton, MA 01060", 1));
        myMap.addBuilding(new Cafe("Woodstar Cafe", "60 Masonic St STE B, Northampton, MA 01060", 2, 50, 100, 100, 50));


        System.out.println(myMap);
    }
    
}
