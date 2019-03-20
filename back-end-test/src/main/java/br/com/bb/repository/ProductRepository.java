package br.com.bb.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.bb.model.Product;

/**
 * @author Jeovan Romano
 *
 */

public interface ProductRepository extends Repository<Product, Integer> {

	List<Product> findByCategoryId(int idCategory);
}
