import org.junit.Test;

public class readTest {
    @Test
    public void test1() {
        readReport sample = new readReport();
        System.out.println(" bytes)");
        System.out.println(sample);
        try {
            sample.main(null);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}