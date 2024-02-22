package example.graduation.project.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import example.graduation.project.Model.Product;

import java.util.List;


/*
* Аннотация @Repository нужна для автоматической регистрации класса Repositories */
@Repository
public interface Repositories extends JpaRepository<Product, Long> {
    /**
     * Поиск по названию продукта
     */
    List<Product> getByTitle(String title);

    Product getById(int id);

}
