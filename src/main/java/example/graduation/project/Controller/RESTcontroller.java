package example.graduation.project.Controller;

import example.graduation.project.View.ServiceProduct;
import example.graduation.project.Model.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/product")
public class RESTcontroller {

    private final ServiceProduct serviceProduct;

    /**
     * Получение всех товаров
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(serviceProduct.getAll(), HttpStatus.OK);
    }

    /**
     * Создане нового товара
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(serviceProduct.create(product), HttpStatus.CREATED);
    }

    /**
     * Обновление товара
     */
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(serviceProduct.update(product), HttpStatus.OK);
    }

    /**
     * Удаление товара по id
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") long id) {
        serviceProduct.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Получить товар по id
     */
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        return new ResponseEntity<>(serviceProduct.getById(id), HttpStatus.OK);
    }
}
