package jaegojaego.back.web.domain.product.repository;

import jaegojaego.back.web.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
