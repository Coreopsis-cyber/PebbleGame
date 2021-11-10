import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

import java.io.IOException;

public class PebbleGameTestSkeleton {

    static PebbleGame game = new PebbleGame();
    Bags bag1 = new Bags();
    Bags bag2 = new Bags();
    Bags bag3 = new Bags();

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
        assert(error = false);
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
        Scanner scanCorrect = new Scanner("exampleFile1.csv");
        game.checkFileInput(scanCorrect, 1);
        Scanner scanIncorrect = new Scanner("player1.txt");
        game.checkFileInput(scanIncorrect, 1);
        
    }

    @Test
    public void checkIntInput() {
        Scanner scanCorrect = new Scanner("5");
        game.checkIntInput(scanCorrect);
        Scanner scanIncorrect = new Scanner("Five");
        game.checkIntInput(scanIncorrect);
    }

    @Test
    public void gameMain() {
        try{
            PebbleGame.Player[] players = game.gameMain();
            assert(players.length == 2);
        }
        catch(IOException e){
            
        }
    }

    @Test
    public void readFile() {
        try{
            File file = new File("exampleFile1");
            assert(game.readFile(file) == "");
        }
        catch(IOException e){

        }
    }

    @Test
    public void getNextPebble() {
        String data = "1,2,3,4,5,6,7,8,9";
        assert(data.contains(game.getNextPebble(data)));
    }

    @Test
    public static void main(String args[]) {
        System.out.println("Yay?");
    }
}