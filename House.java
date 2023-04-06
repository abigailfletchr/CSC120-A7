import java.util.ArrayList;  
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for the House class extending the Building class.
   * @param name the name of the building
   * @param address the address of the building
   * @param nFloors the number of floors in the building
   * @param hasDiningRoom sets a dining room to a house
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  public House(String name, boolean hasDiningRoom, boolean hasElevator) {
    super(name, "No specified house address", 2);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
   * Manipulator that sets a dining room to a house.
   * @return hasDiningRoom sets a dining room to a house
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /**
   * Method that returns the amount of residents in a house.
   * @return the amount of residents
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * Method that moves a resident in by adding their name to the residents arraylist.
   * @param name the name of a resident
   */
  public void moveIn(String name){
    this.residents.add(name);
  }

  /**
   * Method that moves a resident out of a house if they were a resident. 
   * The method removes the name from the residents arraylist.
   * @param name the name of a resident
   * @return the name of the resident that was removed or the name with a message saying they were not a resident
   */
  public String moveOut(String name){
    for(int i = 0; i < residents.size(); i++){
      if(residents.get(i).equals(name)){
        String nm = name;
        residents.remove(i);
        return nm;
      }
    }
    return name + " was not found so they weren't removed.";
  }

  /**
   * Method that checks the residents of the house.
   * @param name the name of a resident
   * @return true if the resident is a resident of the house and false if they are not
   */
  public boolean isResident(String name){
    return this.residents.contains(name);
  }

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut()\n + goToFloor()\n + isResident(n)");
  }

// need to add boolean value bc not all houses have elevators
public void goToFloor(int floorNum) {
  if(this.hasElevator){
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }else{
    throw new RuntimeException("Sorry, this building does not have an elevator so you can't navigate floors.");
  }
}

  public static void main(String[] args) {
    new House("King House", "10 Elm Street", 4, true);
  }

}