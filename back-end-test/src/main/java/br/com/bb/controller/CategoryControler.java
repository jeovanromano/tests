/**
 * 
 */
package br.com.bb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.model.Category;
import br.com.bb.service.CategoryService;

/**
 * @author Jeovan Romano
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/category"})
public class CategoryControler {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(path = {"listAll"})
	public List<Category> findAll(){
		return categoryService.findAll();
	}
	
	@GetMapping(path = {"findByLetter/{letter}"})
	public Category findByLetter(@PathVariable("letter") CharSequence letter){
		List<Category> categorys = findAll();
		
		Map<Category, Integer> map = new HashMap<Category, Integer>();
		
		for (Category category : categorys) {
			if(category.getName().contains(letter)) {
				int countOccur = StringUtils.countOccurrencesOf(category.getName(), letter.toString());
				map.put(category, countOccur);
			}
		}
		
		Map.Entry<Category, Integer> maxEntry = null;
		for (Map.Entry<Category, Integer> entry : map.entrySet()) {
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
		        maxEntry = entry;
		    }
		}
		
		return maxEntry.getKey();
	}

}
