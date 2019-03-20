/**
 * 
 */
package br.com.bb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.bb.model.Product;
import br.com.bb.repository.ProductRepository;
import br.com.bb.service.ProductService;

/**
 * @author Jeovan Romano
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Override
	public List<Product> findByCategoryId(int idCategory) {
		List<Product> findByCategoryId = productRepository.findByCategoryId(idCategory);
		return findByCategoryId;
	}

}
