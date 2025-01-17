import java.util.Hashtable;
public class Library extends Building{

  /**
   * Hastable<String, Boolean> collection is the hashtable that represents/stores the books in the library
   * nAvailableStudySpaces is the number of availabel study spaces in the library
   */
  private Hashtable<String, Boolean> collection;
  private int nAvailableStudySpaces;

  /**
   * Constructor for the Library class extending the Building class.
   * @param name the name of the building
   * @param address the address of the building
   * @param nFloors the number of floors in the building
   */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      // System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
      this.nAvailableStudySpaces = 0;
    }

    /**
     * An overloaded constructor for the Library class
     * @param name the name of the building
     * @param address the address of the building
     * @param nFloors the amount of floors in the building
     * @param collection a library of books already created when the library is created
     */
    public Library(String name, String address, int nFloors, Hashtable<String, Boolean> collection) {
      super(name, address, nFloors);
      // System.out.println("You have built a library: 📖");
      this.collection = collection;
    }

    /**
     * An overloaded constructor for the Library class
     * @param name the name of the building
     * @param address the address of the building
     * @param nFloors the amount of floors in the building
     * @param nAvailableStudySpaces the number of study spaces available in the library
     */
    public Library(String name, String address, int nFloors, int nAvailableStudySpaces) {
      super(name, address, nFloors);
      // System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
      this.nAvailableStudySpaces = nAvailableStudySpaces;
    }

  /**
   * Method that adds a book title to the Library's collection of books.
   * @param title the title of a book
   */
    public void addTitle(String title){
      this.collection.put(title, true);
    }

    /**
     * Method that removes a book title from the Library's collection of books.
     * @param title the title of a book
     */
    public String removeTitle(String title){
      try{
        this.collection.remove(title);
        return title;
      }catch(Exception e){
        return "No title was removed. Title not found.";
      }
    }
    
    /**
     * Method that checks a book out and changes the key value to false when checked out.
     * @param title the title of a book
     */
    public void checkOut(String title){
      this.collection.replace(title, true, false); 
    }

    /**
     * Method that retusn a book and changes the key value to true once returned.
     * @param title the title of a book
     */
    public void returnBook(String title){
      this.collection.replace(title, false, true);
    }

    /**
     * 
     * @param title
     * @return
     */
    public boolean containsTitle(String title){
      return this.collection.contains(title);
    }

    /**
     * Method that checks is a book title is available and returns the value true if it is available.
     * @param title the title of a book
     * @return this.collection.get(title) it will return true if the book is available, or false if it is not
     */
    public boolean isAvailable(String title){
      return this.collection.get(title);
    }

    /**
     * Method that checks the number of available study spaces
     * @return this.nAvailableStudySpaces returns number of available study spaces
     */
    public int nAvailableStudySpaces(){
      return this.nAvailableStudySpaces;
    }

    /**
     * Method that prints out the Library's entire book collection and check out status.
     */
    public void printCollection(){
      for(String title: this.collection.keySet()){
        System.out.println(title + " available: " + this.collection.get(title));
      }
    }

    /**
     * Method that shows the options the class Library provided
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + addTitle(t) \n + removeTitle(t) \n + checkOut(t) \n + returnBook(t)\n + isAvailable(t)\n + printCollection()\n + goToFloor(n)\n + containsTitle(t) + nAvailableStudySpaces(n)\n");
  }

  /**
   * Method that acts as an elevator and goes up and down floors
   * @param floorNum the floor number it is on
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
}


    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "1 Chapin Way", 4);
      neilson.printCollection();

      // Hashtable<String, Boolean> col = new Hashtable<String, Boolean>();
      // col.putIfAbsent("The Key to Theatre", true);
      // col.putIfAbsent("Theory of Evolution", true);
      // col.putIfAbsent("Organic Chemistry II", true);
      // Library josten = new Library("Josten", "123 by Ainsworth", 3, col);
      // josten.printCollection();

      // Library young = new Library("Young", "456 in Bass", 4, 100);
      // young.printCollection();

    
    }
  
  }