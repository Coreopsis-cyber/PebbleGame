import java.util.Iterator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.Runner;
import org.junit.runner.*;
import org.junit.runner.notification.RunNotifier;

public class TestRunner extends Runner{
    private Class testClass;
    public TestRunner(Class testClass){
        super();
        this.testClass = testClass;
    }
    @Override
    public Description getDescription() {
        return Description.createTestDescription(testClass, "My runner description");
    }
    @Override
    public void run(RunNotifier notifier) {
        Result result = JUnitCore.runClasses(new Class[]{BagsTest.class});
        Iterator var2 = result.getFailures().iterator();
        while(var2.hasNext()) {
            Failure failure = (Failure)var2.next();
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

}
