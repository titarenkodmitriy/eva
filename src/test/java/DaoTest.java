import eva.App;
import eva.dao.IProductDAO;
import eva.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
//@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:app-test.properties")
public class DaoTest {
    @Autowired
    IProductDAO dao;

    @Test
    public void testDbAccess() {
        Product byId = dao.getById(1);
        Assert.assertNotNull(byId);
    }
}
