/**
 * 
 */
package br.com.bb.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.bb.model.Category;

/**
 * @author Jeovan Romano
 *
 */
public interface CategoryRepository extends Repository<Category, Integer> {
	
	List<Category> findAll();

}
