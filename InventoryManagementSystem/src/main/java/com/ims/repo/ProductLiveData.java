package com.ims.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class ProductLiveData {

	List<ProductData> productList = new ArrayList<ProductData>();
	List<ProductData> addedList = new ArrayList<ProductData>();
	List<ProductData> removedList = new ArrayList<ProductData>();

	public List<ProductData> getProductDataList() {
		return productList;
	}
	
	public List<ProductData> getRemovedProductList() {
		return removedList;
	}
	
	public List<ProductData> getAddedProductList() {
		return addedList;
	}

}
