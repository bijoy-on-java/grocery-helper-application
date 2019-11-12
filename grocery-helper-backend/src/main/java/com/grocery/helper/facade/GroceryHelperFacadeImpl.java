package com.grocery.helper.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.helper.data.GroceryHelperData;
import com.grocery.helper.service.GroceryHelperService;

@Service
public class GroceryHelperFacadeImpl implements GroceryHelperFacade {
	
	@Autowired
	private GroceryHelperService groceryHelperService;

	@Override
	public List<GroceryHelperData> findAllGroceries() {
		// TODO Auto-generated method stub
		return groceryHelperService.findAllGroceries();
	}

	@Override
	public GroceryHelperData createGroceryItem(GroceryHelperData grocery) {
		// TODO Auto-generated method stub
		return groceryHelperService.createGroceryItem(grocery);
	}

	@Override
	public GroceryHelperData deleteGroceryItemById(long id) {
		// TODO Auto-generated method stub
		return groceryHelperService.deleteGroceryItemById(id);
	}

	@Override
	public GroceryHelperData findGroceryItemById(long id) {
		// TODO Auto-generated method stub
		return groceryHelperService.findGroceryItemById(id);
	}

	@Override
	public List<GroceryHelperData> findGroceriesByCategory(String category) {
		// TODO Auto-generated method stub
		return groceryHelperService.findGroceriesByCategory(category);
	}

	

}
