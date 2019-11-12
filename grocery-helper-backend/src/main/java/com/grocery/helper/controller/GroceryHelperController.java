package com.grocery.helper.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grocery.helper.data.GroceryHelperData;
import com.grocery.helper.facade.GroceryHelperFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Controller class is responsible to create/ update /list grocery item(s) based on user action.
 * 
 * @author Bijoy Baral
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class GroceryHelperController {

	private Logger LOGGER = LoggerFactory.getLogger(GroceryHelperController.class);

	@Autowired
	private GroceryHelperFacade groceryHelperFacade;

	/**
	 * 
	 * Method is responsible to get all groceries based on user action.
	 * 
	 * @return List<GroceryHelperData>
	 */
	@GetMapping("/grocery-helpers/groceries")
	public List<GroceryHelperData> getAllGroceries() {
		LOGGER.info("GroceryHelperController:getAllGroceries ## All Groceries method controller method got called");
		return groceryHelperFacade.findAllGroceries();
	}

	/**
	 * Method is responsible to get all groceries based on particular category.
	 * 
	 * @param category
	 * @return List<GroceryHelperData>
	 */
	@GetMapping("/grocery-helpers/groceries/{category}")
	public List<GroceryHelperData> getAllGroceriesByCategory(@PathVariable String category) {
		LOGGER.info(
				"GroceryHelperController:getAllGroceries ## All Groceries method controller method got called based on category");
		return groceryHelperFacade.findGroceriesByCategory(category);
	}

	/**
	 * Method is responsible to get grocery item based on particular id.
	 * 
	 * @param id
	 * @return GroceryHelperData
	 */
	@GetMapping("/grocery-helpers/grocery/{id}")
	public GroceryHelperData getGrocery(@PathVariable long id) {
		LOGGER.info(
				"GroceryHelperController:getGrocery ## fetch grocery controller method got called based on id:" + id);
		return groceryHelperFacade.findGroceryItemById(id);
	}

	/**
	 * Method is responsible to delete an grocery item based on particular id.
	 * @param id
	 * @return ResponseEntity<Void>
	 */ 
	@DeleteMapping("/grocery-helpers/groceries/{id}/delete")
	public ResponseEntity<Void> deleteGrocery(@PathVariable long id) {
		LOGGER.info("GroceryHelperController:deleteGrocery ## delete grocery controller method got called based on id:"
				+ id);
		GroceryHelperData groceryHelperData = groceryHelperFacade.deleteGroceryItemById(id);
		if (groceryHelperData != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Method is responsible to update an grocery item based on particular id.
	 * 
	 * @param id
	 * @param groceryHelperData
	 * @return ResponseEntity<GroceryHelperData>
	 */
	//@PutMapping("/grocery-helpers/{category}/groceries/{id}")
	@PutMapping("/grocery-helpers/groceries/{id}/update")
	public ResponseEntity<GroceryHelperData> updateGrocery(@PathVariable long id, @RequestBody GroceryHelperData groceryHelperData) {
		LOGGER.info("GroceryHelperController:updateGrocery ## update grocery controller method got called based on id:"
				+ id);
		groceryHelperFacade.createGroceryItem(groceryHelperData);
		return new ResponseEntity<GroceryHelperData>(groceryHelperData, HttpStatus.OK);
	}

	/**
	 * Method is responsible to create an grocery item based on input.
	 * 
	 * @param category
	 * @param groceryData
	 * @return ResponseEntity<Void>
	 */
	@PostMapping("/grocery-helpers/grocery/create")
	public ResponseEntity<Void> createGrocery(@RequestBody GroceryHelperData groceryData) {
		LOGGER.info(
				"GroceryHelperController:createGrocery ## create grocery controller method got called with category:"
						+ groceryData.getCategory());
		GroceryHelperData groceryHelperData = groceryHelperFacade.createGroceryItem(groceryData);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(groceryHelperData.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}