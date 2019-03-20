/**
 * 
 */
package br.com.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bb.model.Category;

/**
 * @author Jeovan Romano
 *
 */
@Service
public interface CategoryService {
	
	List<Category> findAll();

}
