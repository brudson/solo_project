package com.bradlarsenfinal.springboot.daoTest;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.bradlarsenfinal.springboot.dao.FoodDao;
import com.bradlarsenfinal.springboot.entities.Food;

public class FoodDaoTest {

	private FoodDao foodDao;
	private EntityManager entityManager;
	private Food food;
	
	@Before
	public void setup(){
		
		foodDao = new FoodDao();
		entityManager = mock(EntityManager.class);
		foodDao.setEm(entityManager);
		food = mock(Food.class);
		
	}
	
	@Test
	public void getAllFoodsTest(){
		
		TypedQuery<Food> mockTypedQuery = mock(TypedQuery.class);
		
		List<Food> expected = new ArrayList<Food>();
		
		when(entityManager.createQuery(anyString(), eq(Food.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		foodDao.getAllFood();
		
		verify(mockTypedQuery).getResultList();
		
	}
	
	@Test
	public void newFoodTest(){
		
		foodDao.newFood(food);
		verify(entityManager).persist(food);
		
	}
	
	@Test
	public void editFoodTest(){
		
		foodDao.editFood(food);
		verify(entityManager).merge(food);
		
	}
	
	@Test
	public void deleteFoodTest(){
		
		foodDao.deleteFood(null);
		verify(entityManager).remove(null);
		
	}
	
}
