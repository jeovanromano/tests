/**
 * 
 */
package br.com.bb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.bb.model.Category;
import br.com.bb.repository.CategoryRepository;
import br.com.bb.service.CategoryService;

/**
 * @author Jeovan Romano
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

}
