import java.util.Iterator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.Runner;

public class TestRunner {
    public TestRunner() {
    };

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(new Class[]{BagsTest.class});
        Iterator var2 = result.getFailures().iterator();

        while(var2.hasNext()) {
            Failure failure = (Failure)var2.next();
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
