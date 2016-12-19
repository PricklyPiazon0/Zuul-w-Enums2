
/**
 * Write a description of class InteractiveRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InteractiveRoom extends Room
{
    //boolean variable to tell if room is locked
    private boolean isLocked;
    //arraylist to hold interactive items in room
    ArrayList<Item> itemList;
    //arrayList to hold NPC's in room
    ArrayList<Character> NPCList;
    /**
     * Constructor for objects of class InteractiveRoom
     */
    public InteractiveRoom()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
