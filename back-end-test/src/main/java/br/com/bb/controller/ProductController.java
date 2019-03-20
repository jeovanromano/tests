package br.com.bb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.model.Product;
import br.com.bb.service.ProductService;
import br.com.bb.viewmodel.ProductViewModel;

/**
 * @author Jeovan Romano
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/product"})
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(path = {"listByCategory/{idCategory}"})
    public List<ProductViewModel> findByCategoryId(@PathVariable("idCategory") int idCategory){
		
		List<Product> products = productService.findByCategoryId(idCategory);
		List<ProductViewModel> productsVM = new ArrayList<ProductViewModel>();
		
		for (Product p : products) {
			ProductViewModel pvm = new ProductViewModel();
			pvm.setId(p.getId());
			pvm.setName(p.getName());
			productsVM.add(pvm);
		}
		
        return productsVM;
    }
}
