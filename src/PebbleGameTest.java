import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

import java.io.IOException;

@Runwith(TestRunner.class)
public class PebbleGameTest {

    static PebbleGame game = new PebbleGame();
    Bags bag1 = new Bags("bag1", new File("example_File_1.csv"));
    Bags bag2 = new Bags("bag2", new File("example_File_2.csv"));
    Bags bag3 = new Bags("bag3" , new File("example_file_3.csv"));

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void GetIfWinner() {
        game.winner = false;
        assert(game.getIfWinner() == false);
        
    }

    @Test
    public void setWinnerTrue() {
        game.setWinnerTrue();
        assert(game.getIfWinner() == true);
    }

    @Test
    public void createBlackBags() {
        int numberOfPlayers = 2;
        boolean error = false;
        try{
            game.createBlackBags(numberOfPlayers, bag1, bag2, bag3);
        }
        catch(IOException e){
            error = true;
        }
        assert(!error);
        assert(bag1.getBagPebbles().size() == 22);
        assert(bag2.getBagPebbles().size() == 22);
        assert(bag3.getBagPebbles().size() == 22);

        
    }

    @Test
    public void randomNumGenerator() {
        int randomNumber = game.randomNumGenerator(1,25);
        assert(randomNumber >= 1);
        assert(randomNumber <=25);
    }

    @Test
    public void checkFileInput() {
        Scanner scanCorrect = new Scanner("example_File_1.csv");
        game.checkFileInput(scanCorrect, 1);

        
    }



    @Test
    public void checkIntInput() {
        boolean test = false;
        Scanner scanCorrect = new Scanner("5");
        game.checkIntInput(scanCorrect);

    }


    @Test
    public void getNextPebble() {
        String data = "1,2,3,4,5,6,7,8,9";
        assert(data.contains(game.getNextPebble(data)));
    }

    public static class PlayersTests{
        PebbleGame.Player player = new PebbleGame.Player("name");
        @Test
        public void discard(){

        }
        @Test
        public void pickUp(){

        }
        @Test
        public void checkBags(){

        }
        @Test
        public void getHandSum(){

        }
        @Test
        public void updateFile(){

        }
    }
}