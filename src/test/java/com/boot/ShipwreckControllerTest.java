package com.boot;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		Mockito.when(shipwreckRepository.findOne(1L)).thenReturn(sw);
		
		Shipwreck shipwreck = sc.get(1L);
		
		Mockito.verify(shipwreckRepository).findOne(1L);
		
		Assert.assertEquals(shipwreck.getId().longValue(), 1L);
		
		MatcherAssert.assertThat(shipwreck.getId(), Matchers.is(1L));
	}
}
