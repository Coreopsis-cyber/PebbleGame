import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

/**
 * Bag class that contains functionality for both black and white bags
 */
public class Bags {
    public volatile CopyOnWriteArrayList<Integer> bagPebbles = new CopyOnWriteArrayList<Integer>();
    private String name;
    private File fileName;

    /**
     * @param name Name of the bag
     * @param fileName Associated file
     */
     public Bags(String name, File fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    /**
     * Empty constructor
     */
    public Bags(){

    }

    /**
     * Removes the pebbles
     * @return the index of the pebble chosen
     */
    public int removeRandomPebble() {
        Random rand = new Random();
        int index =rand.nextInt(this.bagPebbles.size());
        bagPebbles.remove(index);
        return index;
    }
    /**
     * Removes the pebbles given an index
     * @param index index of the pebble to be removed
     */
    public void removePebble(int index){
        bagPebbles.remove(index);
    }

    /**
     * Adds the pebbles to the arraylist
     * @param weight integer value of a pebble
     */
    public void addPebble(Integer weight) {
        bagPebbles.add(weight);
    }

    /**
     * Check to see if the array list containing the current pebbles is empty.
     * @return boolean
     */
    public boolean isEmpty() {
        if (bagPebbles.size() == 0) {
            return true;
        }
        return false;
    }


    /**
     * Delete the contents of the file and rewrites the new array list of the pebbles
     * @param list list of pebbles in the bag
     */
    public void updateFile(CopyOnWriteArrayList<Integer> list) throws IOException {
        // some writer function here
        try {

            BufferedWriter buffer = new BufferedWriter(new FileWriter(this.fileName));

            buffer.write(list.toString().replaceAll("[\\[\\]]", "")); //adding arraylist to file
            buffer.close();
        } catch (IOException e) {
            System.out.println("Unable to write to bag file.");
        }
    }

    /**
     * Deletes the contents of the bag
     * @throws IOException if the file cannot be changed
     */
    public void updateFileRemove() throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, false));
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to remove contents from bag file.");
        }
    }


    /**
     * Getter for bagPebbles
     * @return an arraylist of integers
     */
    public CopyOnWriteArrayList<Integer> getBagPebbles() {
        return bagPebbles;
    }

}