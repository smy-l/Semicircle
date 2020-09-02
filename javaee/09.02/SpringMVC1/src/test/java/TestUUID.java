import org.junit.Test;

import java.util.UUID;

public class TestUUID {
    @Test
    public void testRandom(){
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
}
