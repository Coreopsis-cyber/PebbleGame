import org.junit.Test;
import java.util.*;
import java.io.*;
import java.io.IOException;
import org.junit.runner.RunWith;


@RunWith(TestRunner.class)
public class PebbleGameTest {

    static PebbleGame game = new PebbleGame();
    Bags bag1 = new Bags("bag1", new File("example_File_1.csv"));
    Bags bag2 = new Bags("bag2", new File("example_File_2.csv"));
    Bags bag3 = new Bags("bag3" , new File("example_file_3.csv"));


    @Test
    public void GetIfWinnerTest() {
        game.winner = false;
        assert(game.getIfWinner() == false);
        
    }

    @Test
    public void setWinnerTrueTest() {
        game.setWinnerTrue();
        assert(game.getIfWinner() == true);
    }

    @Test
    public void createBlackBagsTest() {
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
    public void randomNumGeneratorTest() {
        int randomNumber = game.randomNumGenerator(1,25);
        assert(randomNumber >= 1);
        assert(randomNumber <=25);
    }

    @Test
    public void checkFileInputTest() {
        Scanner scanCorrect = new Scanner("example_File_1.csv");
        game.checkFileInput(scanCorrect, 1);

        
    }



    @Test
    public void checkIntInputTest() {
        boolean test = false;
        Scanner scanCorrect = new Scanner("5");
        game.checkIntInput(scanCorrect);

    }


    public static class PlayersTests{
        PebbleGame.Player player = new PebbleGame.Player("name"); // this should run the thread and set up the current hand

        @Test
        public void discardTest(){
            try{
                int before = player.getCurrentHand().size();

                player.discard();
                int after = player.getCurrentHand().size();
                assert(before == after + 1);
            }
            catch(IOException e){

            }


        }
        @Test
        public void pickUpTest(){
            try {


                int before = player.getCurrentHand().size();

                player.discard();
                int after = player.getCurrentHand().size();
                assert (before == after - 1);
            }
            catch(IOException e){

            }
        }
    }
}