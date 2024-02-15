package example.graduation.project.Controller;

import example.graduation.project.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import example.graduation.project.View.ServiceProduct;
import org.springframework.web.bind.annotation.PostMapping;


/*
* Контроллер обрабатывает поступающие запросы */
/*
* Аннотация @Controller  нужна для автоматической регистрации класса ProductController
* Компонент класса будет создан и зарегистрирован автоматически при запуске приложения.*/
@Controller
@RequiredArgsConstructor
public class ProductsController {

    /**
     * Инкапсулируем управление продуктами в бд
     */
    private final ServiceProduct serviceProduct;

    /**
     * Получить главную страницу
     */
    @GetMapping("/main")
    public String getMain(Model model) {
        model.addAttribute("product", serviceProduct.getAll());
        return "product";
    }



    /**
     * Удалить продукт
     */
    @GetMapping("/deleteproduct")
    public String turnToDelete( int id) {
        serviceProduct.delete(id);
        return "deleteproduct";
    }


    /**
     * Редактирование продукта в базе данных
     */
    @PostMapping("/editproduct")
    public String updateProduct(Product product, int id) {
        if (product != null) {
            serviceProduct.updateProduct(id, product.getTitle(), product.getDescription());
        } else {
            return "error";
        }
        return "product";
    }



    /**
     * Создание нового продукта
     */
    @PostMapping("/productcreate")
    public String createProduct(Product product) {
        serviceProduct.create(product);
        return "productcreate";
    }
}

