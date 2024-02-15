package example.graduation.project;

import example.graduation.project.Model.Product;
import example.graduation.project.View.Repositories;
import example.graduation.project.View.ServiceProduct;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GraduationProjectApplicationTests {

	@Autowired
	private ServiceProduct serviceProduct;
	@Autowired
	private Repositories repositories;
	@Before
	public void setUp(){
		//чистка базы данных перед каждым тестом
		repositories.deleteAll();
	}
	@Test
	public void getAllProductIntegrationTest() {
		Product product = new Product();
		product.setTitle("water");
		product.setDescription("still water");
		repositories.save(product);


		List<Product> testProduct = serviceProduct.getAll();
		assertTrue(testProduct.size() > 0);
		assertEquals(product.getTitle(), testProduct.get(0).getTitle());
	}


}
