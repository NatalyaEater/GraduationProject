package example.graduation.project;


import example.graduation.project.Model.Product;
import example.graduation.project.View.Repositories;
import example.graduation.project.View.ServiceProduct;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;


/**
 * Аннотация @ExtendWith активирует работу библиотеки Mockito в unit-тестах.*/
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    /*Аннотация @InjectMocks используется для создания экземпляра класса и внедрения в него макетов, созданных с помощью аннотации @Mock.
    Это позволяет легко интегрировать макеты в тестируемый класс.*/
    @InjectMocks
    private ServiceProduct serviceProduct;
    /**
     * Аннотация @Mock
     * используется для создания и внедрения макета или стаба (mock object)
     * Макет — это объект, который имитирует реальное поведение объекта, но в упрощенной или контролируемой форме.
     * * MockitoExtension сам проанализирует код класса и создаст нужные заглушки
     * */
    @Mock
    private Repositories repositories;


    /*Подготовка тестовых данных ,выполняется до запуска тестов */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    /**
     * Библиотека Mockito позволяет добавить мок-объекту нужное поведение.
     * Определение поведения - when(mock).thenReturn(value)
     * Этот метод позволяет определить возвращаемое значение при вызове метода mock с заданными параметрами.
     * Если будет указано более одного возвращаемого значения, то они будут возвращены методом последовательно,
     * пока не вернётся последнее; после этого при последующих вызовах будет возвращаться только последнее значение.
     * Таким образом, чтобы метод всегда возвращал одно и то же значение, следует просто определить одно условие.
     * @when создаем правило -(thenReturn)вернуть  @testProduct при вызове метода repositories.findAll())
     * @assertEquals сравнивает два созданных объекта (testProduct,actualProduct);
     */
    public void getAllProduct (){
        Product product=new Product();
        product.setTitle("water");
        product.setDescription("still water");
        List<Product> testProduct= Collections.singletonList(product);
        when(repositories.findAll()).thenReturn(testProduct);
        List<Product> actualProduct=serviceProduct.getAll();
        assertEquals(testProduct,actualProduct);

    }
}
