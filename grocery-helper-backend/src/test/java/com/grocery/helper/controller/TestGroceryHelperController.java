package com.grocery.helper.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.grocery.helper.data.GroceryHelperData;
import com.grocery.helper.facade.GroceryHelperFacade;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGroceryHelperController {

	@InjectMocks
	final GroceryHelperController GroceryHelperController = new GroceryHelperController();

	@Mock
	GroceryHelperFacade groceryHelperFacade;
	
	@Mock
	List<GroceryHelperData> groceries;
	
	@Mock
	GroceryHelperData groceryItem;

	@Test
	public void testGetAllGroceries() {
		given(groceries.add(groceryItem)).willReturn(Boolean.TRUE);
		given(groceryHelperFacade.findAllGroceries()).willReturn(groceries);
		List<GroceryHelperData> retrievedGroceries = GroceryHelperController.getAllGroceries();
		assertThat(retrievedGroceries).isNotNull();
	}
	
	@Test
	public void testGetAllGroceriesNoItemFound() {
		given(groceryHelperFacade.findAllGroceries()).willReturn(null);
		List<GroceryHelperData> retrievedGroceries = GroceryHelperController.getAllGroceries();
		assertThat(retrievedGroceries).isNull();
	}

}
