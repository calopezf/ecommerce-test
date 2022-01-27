package com.tul.ecommerce.service;

import com.tul.ecommerce.model.Product;
import com.tul.ecommerce.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void whenCreateProduct_shouldReturnProduct() {
        Product product = new Product();
        product.setName("Pants");
        product.setDescription("Pants from Nordstrom");
        product.setId(UUID.fromString("123e4567-e89b-12d3-a456-426655440000"));
        product.setPrice(new BigDecimal(10.25));
        product.setSku(15);

        when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);

        Product created = productService.save(product);
        assertEquals(created.getName(),product.getName());
        verify(productRepository).save(product);
    }

    @Test
    public void whenUpdateProduct_shouldReturnProduct() {
        Product product = new Product();
        product.setName("Pants");
        product.setDescription("Pants from Nordstrom");
        product.setId(UUID.fromString("123e4567-e89b-12d3-a456-426655440000"));
        product.setPrice(new BigDecimal(10.25));
        product.setSku(15);

        when(productService.findOne(UUID.fromString("123e4567-e89b-12d3-a456-426655440000"))).thenReturn(Optional.of(product));

        Product newProduct = productService.findOne(UUID.fromString("123e4567-e89b-12d3-a456-426655440000")).get();
        newProduct.setName("Pants Updated");
        newProduct.setPrice(new BigDecimal(30));

        Product updated = productService.save(newProduct);
        verify(productRepository).save(product);
    }

    @Test
    public void getProducts() {
        List<Product> products = new ArrayList();
        products.add(new Product());

        when(productService.findAll()).thenReturn(products);

        List<Product> expected = productService.findAll();

        assertEquals(expected, products);
        verify(productRepository).findAll();
    }

    @Test
    public void whenGivenId_shouldDeleteProduct_ifFound(){
        Product product = new Product();
        product.setName("Test Name");
        product.setId(UUID.fromString("123e4567-e89b-12d3-a456-426655440000"));

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        productService.delete(product.getId());
        verify(productRepository).deleteById(product.getId());
    }
}
