package br.com.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bb.model.Product;

/**
 * @author Jeovan Romano
 *
 */
@Service
public interface ProductService {
	
	List<Product> findByCategoryId(int idCategory) ;
}
