package com.ims.live;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ims.entity.Product;
import com.ims.sl.ProductService;
import com.ims.util.AppConstants;

@Controller
public class ProductController {

	ProductService productService = new ProductService();

	@RequestMapping("/")
	public String getHomePage() {
		return "index";
	}

	@RequestMapping("viewProducts")
	public String viewProducts(Model model) {

		List<Product> products = productService.getProducts();
		if (products.size() == 0) {
			model.addAttribute(AppConstants.MESSAGE, AppConstants.NO_RECORDS);
		}
		model.addAttribute("products", products);
		return "productsView";
	}

	@RequestMapping("addProductPage")
	public String addProductPage() {
		return "addProduct";
	}

	@RequestMapping("addProduct")
	public String addProduct(@ModelAttribute Product product, Model model) {

		if (product.getProductID() == 0) {
			model.addAttribute(AppConstants.MESSAGE, AppConstants.PRODUCT_ID_MANDATORY);
		} else if (product.getPrice() == 0 && product.getProductDescription().length() == 0
				&& product.getProductName().length() == 0 && product.getProductName().length() == 0) {
			model.addAttribute(AppConstants.MESSAGE, AppConstants.ALL_FIELDS_MANDATORY);
		} else if (productService.isDuplicateEntry(product.getProductID())) {
			model.addAttribute(AppConstants.MESSAGE, AppConstants.PRODUCT_ID_DUPLICATE);
		} else if (product.getPrice() == 0 || product.getPrice() < 0) {
			model.addAttribute(AppConstants.MESSAGE, AppConstants.INVALID_PRICE);
		} else if (product.getProductName().length() == 0) {
			model.addAttribute(AppConstants.MESSAGE, AppConstants.PRODUCT_NAME_MANDATORY);
		} else if (product.getProductDescription().length() == 0) {
			model.addAttribute(AppConstants.MESSAGE, AppConstants.PRODUCT_DESCRIPTION_MANDATORY);
		} else {
			productService.addProduct(product);
		}

		return "addProduct";
	}

	@RequestMapping("deleteProductPage")
	public String deleteProductPage(Model model) {

		List<Product> products = productService.getProducts();
		
		if (products.size() == 0) {
			model.addAttribute(AppConstants.MESSAGE, AppConstants.NO_RECORDS);
		}
		
		model.addAttribute("products", products);
		
		return "deleteProduct";
	}

	@RequestMapping("deleteProduct")
	public String deleteProduct(@RequestParam("productID") int productID, Model model) {
		
		if (productID == 0) {
			
			model.addAttribute(AppConstants.MESSAGE, AppConstants.PRODUCT_ID_MANDATORY);
			List<Product> products = productService.getProducts();
			model.addAttribute("products", products);
			
			return "deleteProduct";
			
		} else {
			productService.removeProduct(productID);
		}
		
		return "index";
	}

	@RequestMapping("addReport")
	public String viewAddedProducts(Model model) {

		model.addAttribute("products", productService.getAliveData().getAddedProductList());
		return "addReportView";
	}

	@RequestMapping("deleteReport")
	public String viewDeletedProducts(Model model) {

		model.addAttribute("products", productService.getAliveData().getRemovedProductList());
		return "addReportView";
	}
}
