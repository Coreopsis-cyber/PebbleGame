import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.management.BadBinaryOpValueExpException;

import java.io.*;

import static org.junit.Assert.*;

public class BagsTestSkeleton {
    File file = new File("testFile.csv");
    Bags bag = new Bags("Bag", file);
    CopyOnWriteArrayList<Integer> temp = new CopyOnWriteArrayList<Integer>();
    
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void removeRandomPebble() {
        temp = new CopyOnWriteArrayList<Integer>();
        temp.add(1);
        temp.add(3);
        temp.add(2);

        bag.setBagPebbles(temp);
        int pebble = bag.removeRandomPebble();
        assert(pebble == 1 || pebble ==2 || pebble == 3);
    }

    @Test
    public void removePebble() {
        bag.emptyBagPebbles();
        temp = new CopyOnWriteArrayList<Integer>();
        temp.add(1);
        bag.setBagPebbles(temp);

        bag.removePebble(0);
        assert(bag.isEmpty());
    }

    @Test
    public void isEmpty() {
        if(bag.bagPebbles.size() == 0){
            assert(bag.isEmpty());
        }
        else{
            assert(!bag.isEmpty());
        }
    }

    @Test
    public void updateFile() {
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
    public void updateFileRemove() {
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