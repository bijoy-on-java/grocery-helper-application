package com.grocery.helper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grocery.helper.data.GroceryHelperData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GroceryHelperServiceImpl implements GroceryHelperService {

	private Logger LOGGER = LoggerFactory.getLogger(GroceryHelperServiceImpl.class);

	private static List<GroceryHelperData> groceryHelpers = new ArrayList<>();
	private static long idCounter = 0;

	static {
		groceryHelpers.add(new GroceryHelperData(++idCounter, "Beverages", "coffee/tea"));
		groceryHelpers.add(new GroceryHelperData(++idCounter, "Beverages", "juice, soda"));
		groceryHelpers.add(new GroceryHelperData(++idCounter, "Dairy", "cheeses, eggs, milk, yogurt, butter"));
		groceryHelpers.add(
				new GroceryHelperData(++idCounter, "Frozen Foods", "waffles, vegetables, individual meals, ice cream"));
	}

	@Override
	public List<GroceryHelperData> findAllGroceries() {
		// TODO Auto-generated method stub
		LOGGER.info("GroceryHelperServiceImpl:findAllGroceries ## All Groceries method service method got called");
		return groceryHelpers;
	}

	@Override
	public List<GroceryHelperData> findGroceriesByCategory(String category) {
		// TODO Auto-generated method stub
		LOGGER.info(
				"GroceryHelperServiceImpl:findGroceriesByCategory ## All Groceries method service method got called based on category");
		final List<GroceryHelperData> groceries = new ArrayList<>();
		for (GroceryHelperData grocery : groceryHelpers) {
			if (null != category && grocery.getCategory().equalsIgnoreCase(category)) {
				groceries.add(grocery);
			}
		}
		return groceries;
	}

	@Override
	public GroceryHelperData createGroceryItem(GroceryHelperData grocery) {
		// TODO Auto-generated method stub
		LOGGER.info("GroceryHelperServiceImpl:createGroceryItem ## create grocery service method got called");
		if (grocery.getId() == -1 || grocery.getId() == 0) {
			grocery.setId(++idCounter);
			groceryHelpers.add(grocery);
		} else {
			deleteGroceryItemById(grocery.getId());
			groceryHelpers.add(grocery);
		}
		return grocery;
	}

	@Override
	public GroceryHelperData deleteGroceryItemById(long id) {
		// TODO Auto-generated method stub
		LOGGER.info(
				"GroceryHelperServiceImpl:deleteGroceryItemById ## delete grocery service method got called based on id:"
						+ id);
		GroceryHelperData grocery = findGroceryItemById(id);

		if (grocery == null)
			return null;

		if (groceryHelpers.remove(grocery)) {
			return grocery;
		}

		return null;
	}

	@Override
	public GroceryHelperData findGroceryItemById(long id) {
		// TODO Auto-generated method stub
		LOGGER.info(
				"GroceryHelperServiceImpl:findGroceryItemById ## find grocery service method got called based on id:"
						+ id);
		for (GroceryHelperData grocery : groceryHelpers) {
			if (grocery.getId() == id) {
				return grocery;
			}
		}

		return null;
	}

}
