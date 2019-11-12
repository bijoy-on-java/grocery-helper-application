package com.grocery.helper.facade;

import java.util.List;

import com.grocery.helper.data.GroceryHelperData;

public interface GroceryHelperFacade {

	/**
	 * 
	 * Method is responsible to get all groceries based on user action.
	 * 
	 * @return List<GroceryHelperData>
	 */
	public List<GroceryHelperData> findAllGroceries();

	/**
	 * Method is responsible to create an grocery item based on input.
	 * 
	 * @param grocery
	 * @return GroceryHelperData
	 */
	public GroceryHelperData createGroceryItem(final GroceryHelperData grocery);

	/**
	 * Method is responsible to delete an grocery item based on particular id.
	 * 
	 * @param id
	 * @return GroceryHelperData
	 */
	public GroceryHelperData deleteGroceryItemById(final long id);

	/**
	 * Method is responsible to get grocery item based on particular id.
	 * 
	 * @param id
	 * @return GroceryHelperData
	 */
	public GroceryHelperData findGroceryItemById(final long id);

	/**
	 * Method is responsible to get all groceries based on particular category.
	 * 
	 * @param category
	 * @return List<GroceryHelperData>
	 */
	public List<GroceryHelperData> findGroceriesByCategory(final String category);

}
