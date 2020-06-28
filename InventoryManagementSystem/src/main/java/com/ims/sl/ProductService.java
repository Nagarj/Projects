package com.ims.sl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ims.entity.Product;
import com.ims.repo.ProductData;
import com.ims.repo.ProductLiveData;

@Service
public class ProductService {

	ProductLiveData productLiveData = new ProductLiveData();
	
	/**
	 * returns the Product Data that is Alive in the Application scope.
	 * @return ProductLiveData
	 */
	public ProductLiveData getAliveData() {
		return productLiveData;
	}
	
	/**
	 * Returns List of added and not deleted products.
	 * @return Product list
	 */
	public List<Product> getProducts() {
		 
		List<Product> products = new ArrayList<Product>();
		for (ProductData productData : productLiveData.getProductDataList()) {
			products.add(productData.getProduct());
		}
		return products;
	}
	
	/**
	 * Validates and returns true if product ID is already present in the Application scope object.
	 * @param productID
	 * @return boolean
	 */
	public boolean isDuplicateEntry(int productID) {
		
		boolean duplicate = false;
		for (Product product : getProducts()) {
			if (product.getProductID() == productID) {
				duplicate = true;
				break;
			}
		}
		return duplicate;
	}
	
	/**
	 * Adds the product to the Application Scope object list.
	 * @param product
	 */
	public void addProduct(Product product) {
		
		ProductData productData = new ProductData();
		productData.setProduct(product);
		productData.setDate(new Date());
		productLiveData.getProductDataList().add(productData);
		productLiveData.getAddedProductList().add(productData);
		
	}
	
	/**
	 * Removes product from the Application Scope object list.
	 * @param productID
	 */
	public void removeProduct(int productID) {
		
		Product product = searchProductByID(productID);
		List<ProductData> productList = productLiveData.getProductDataList();
		ProductData productDataToRemove = null;
		for (ProductData productData : productList) {
			if (productData.getProduct().getProductID() == product.getProductID()) {
				productDataToRemove = productData;
				break;
			}
		}
		if (null != productDataToRemove) {
			productLiveData.getProductDataList().remove(productDataToRemove);
			productDataToRemove.setDate(new Date());
			productLiveData.getRemovedProductList().add(productDataToRemove);
		}
	}
	
	/**
	 * Performs search by product ID.
	 * @param productID
	 * @return Product {@link Product}
	 */
	private Product searchProductByID(int productID) {
		
		Product matchedProduct = null;
		List<Product> products = getProducts();
		for (Product product : products) {
			if (product.getProductID() == productID) {
				matchedProduct = product;
				break;
			}
		}
		return matchedProduct;
	}
}
