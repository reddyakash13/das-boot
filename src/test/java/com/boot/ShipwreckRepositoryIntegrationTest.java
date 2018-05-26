package com.boot;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class ShipwreckRepositoryIntegrationTest {

	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	@Test
	public void testFindAll() {
		List<Shipwreck> wrecks = shipwreckRepository.findAll();
		
		MatcherAssert.assertThat(wrecks.size(), Matchers.greaterThan(-1));
	}
}
