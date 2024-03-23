package example.graduation.project.Service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import example.graduation.project.Model.Product;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ServiceProduct {
    /*Интерфейс взаимодействия с Базой Данных*/
    private final Repositories repositories;

    /*Получение всех товаров через БД*/
    public List<Product> getAll() {
        return repositories.findAll();
    }

    /* Создание продукта в БД*/
    public Product create(Product product) {
        return repositories.save(product);
    }
    /* Удаление продукта по id*/
    public void delete(long id) {
        repositories.deleteById(id);
    }

    /*Обновление продукта*/
    public void updateProduct(int id, String title, String description) {
        Product product = repositories.getById(id);
        if (product != null) {
            product.setTitle(title);
            product.setDescription(description);
            repositories.save(product);
        } else {
            throw new RuntimeException("error");
        }
    }

    /*Получение продукта по id в БД*/
    public Product getById(long id) {
        Product product;
        try {
            product = repositories.findById(id).orElseThrow(null);
            return product;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
    /*Редактирование продукта*/
    public Product update(Product product) {
        Product upProduct = getById(product.getId());
        upProduct.setTitle(product.getTitle());
        upProduct.setDescription(product.getDescription());
        return repositories.save(upProduct);
    }

}
