package example.graduation.project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")

public class Product {
    /* Автоматический индефикатор для наших товаров*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /* Наименование товара*/
    @Column(nullable = false)
    private String title;
    /* Описание товара*/
    @Column(nullable = false)
    String description;
}

