
package com.playstore.webplaystore.configs;

import com.playstore.webplaystore.entities.Category;
import com.playstore.webplaystore.entities.Pedido;
import com.playstore.webplaystore.entities.Product;
import com.playstore.webplaystore.entities.User;
import com.playstore.webplaystore.repositories.CategoryRepository;
import com.playstore.webplaystore.repositories.PedidoRepository;
import com.playstore.webplaystore.repositories.ProductRepository;
import com.playstore.webplaystore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
@Profile("test") // garante que roda só no profile test
public class TestConfig implements CommandLineRunner {

    @Autowired private UserRepository userRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        // ---- USERS (mantém os seus)
        User u1 = new User(null, "Adélcio Almeida", "adelcio@gmail.com", "043998081247", "123456");
        User u2 = new User(null, "Patricia Ferreira", "patricia@gmail.com", "043991222344", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));

        // ---- CATEGORIES
        Category c1 = new Category(null, "Eletrônicos");
        Category c2 = new Category(null, "Livros");
        categoryRepository.saveAll(Arrays.asList(c1, c2));

        // ---- PRODUCTS
        Product p1 = new Product(null, "Notebook", "i5, 8GB, SSD", 3500.00, "https://img/nb.png");
        Product p2 = new Product(null, "Mouse", "Sem fio", 80.00, "https://img/mouse.png");
        Product p3 = new Product(null, "Livro Java", "POO e Spring", 120.00, "https://img/java.png");
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        // ---- PEDIDOS
        Pedido ped1 = new Pedido(null, new Date(), "em preparo");
        Pedido ped2 = new Pedido(null, new Date(), "saiu para entrega");
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

        // (opcional) log de validação
        List<Product> carrinho = Arrays.asList(p1, p2, p3);
        System.out.println("TOTAL PEDIDO 1 = " + ped1.totalDaCompra(carrinho)); // 3700.0
    }
}
