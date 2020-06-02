import eva.App;
import eva.service.IProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@TestPropertySource(locations = "classpath:app-test.properties")

public class ServiceTest {
    @Autowired
    IProductService service;
    @Test
    public void testService(){
        long count = service.getAllProductAsStream().count();
        System.out.println("AllProduct count - "+count+" Product");
        Assert.assertTrue(count>0);
    }
}

