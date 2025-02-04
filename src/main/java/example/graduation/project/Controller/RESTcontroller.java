package example.graduation.project.Controller;

import example.graduation.project.Service.FileGateway;
import example.graduation.project.Service.ServiceProduct;
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
    private final FileGateway fileGateway;
    private final ServiceProduct serviceProduct;

    /*Получение всех продуктов*/
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(serviceProduct.getAll(), HttpStatus.OK);
    }

    /*Создание нового продукта*/
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        fileGateway.writeToFile(product.getTitle() + ".txt", product.toString());
        return new ResponseEntity<>(serviceProduct.create(product), HttpStatus.CREATED);
    }

    /*Обновление продукта*/
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(serviceProduct.update(product), HttpStatus.OK);
    }

    /*Удаление продукта по id*/
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") long id) {
        serviceProduct.delete(id);
        return ResponseEntity.ok().build();
    }

    /*Получение продукта по id*/
    @GetMapping("/p/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        return new ResponseEntity<>(serviceProduct.getById(id), HttpStatus.OK);
    }
}
