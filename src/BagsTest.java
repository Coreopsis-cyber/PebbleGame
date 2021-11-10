import junit.textui.TestRunner;
import org.junit.Test;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;
import org.junit.runner.RunWith;

//@RunWith(TestRunner.class)
public class BagsTest {
    File file = new File("testFile.csv");
    Bags bag = new Bags("Bag", file);
    CopyOnWriteArrayList<Integer> temp = new CopyOnWriteArrayList<Integer>();


    @Test
    public void removeRandomPebbleTest() {
        temp = new CopyOnWriteArrayList<Integer>();
        temp.add(1);
        temp.add(3);
        temp.add(2);

        bag.setBagPebbles(temp);
        int pebble = bag.removeRandomPebble();
        assert(pebble == 1 || pebble ==2 || pebble == 3);
    }

    @Test
    public void removePebbleTest() {
        bag.emptyBagPebbles();
        temp = new CopyOnWriteArrayList<Integer>();
        temp.add(1);
        bag.setBagPebbles(temp);

        bag.removePebble(0);
        assert(bag.isEmpty());
    }

    @Test
    public void isEmptyTest() {
        if(bag.bagPebbles.size() == 0){
            assert(bag.isEmpty());
        }
        else{
            assert(!bag.isEmpty());
        }
    }

    @Test
    public void updateFileTest() {
        boolean test = true;
        bag.emptyBagPebbles();
        temp = new CopyOnWriteArrayList<Integer>();
        temp.add(1);
        try{
            bag.updateFile(temp);
        }
        catch(IOException e){
            test = false;
        }
        if(file.length() == 0){
            test = false;
        }
        assert(test);
        

    }

    @Test
    public void updateFileRemoveTest() {
        boolean test = true;
        try{
            bag.updateFileRemove();
        }
        catch(IOException e){
            test = false;
        }
        assert(file.length() == 0);

    }
}