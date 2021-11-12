import org.junit.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)

@Suite.SuiteClasses({BagsTest.class, PebbleGameTest.class})

public class TestSuite {
}
