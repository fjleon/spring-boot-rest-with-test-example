package com.example.welcome.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.welcome.service.OrderingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderingServiceImplTest {

	@Autowired
	private OrderingService orderingService;
	
	@Test
	public void sort1Test() {
		List<Integer> expected = Arrays.asList(15,7,3,5,1);
		List<Integer> result = orderingService.sort(Arrays.asList(1,15,5,7,3));
		assertThat(result).containsExactlyElementsOf(expected);
	}
	
	@Test
	public void sort2Test() {
		List<Integer> expected = Arrays.asList(1,1,1,1,1);
		List<Integer> result = orderingService.sort(Arrays.asList(1,1,1,1,1));
		assertThat(result).containsExactlyElementsOf(expected);
	}
	
	@Test
	public void sortEmptyTest() {
		List<Integer> result = orderingService.sort(new ArrayList<>());
		assertThat(result).isEmpty();
	}
	
	@Test(expected = java.lang.NullPointerException.class)
	public void sortNullTest() {
		orderingService.sort(null);
	}
	
}
