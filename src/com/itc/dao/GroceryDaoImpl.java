package com.itc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itc.bean.Grocery;

@Transactional
@Repository
public class GroceryDaoImpl implements GroceryDao {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Grocery getGrocery(int gid) {
		Grocery groc=null;
		groc = entityManager.find(Grocery.class, gid);
		return groc;
	}
	@Override
	public List<Grocery> getGroceryList() {
		List<Grocery> grocList = null;
		String jpql = "Select groc from Grocery groc";
		TypedQuery<Grocery> query = entityManager.createQuery(jpql, Grocery.class);
		grocList = query.getResultList();
		return grocList;
	}
	@Override
	public List<String> getCategoryList() {
		String sql = "select sahil.category from Category sahil";
		TypedQuery<String> query = entityManager.createQuery(sql,String.class);
		return query.getResultList();
	}

	@Override
	public Grocery addGroceryItem(Grocery groc) {
		try {
		entityManager.persist(groc);
		return groc;
		}catch (Exception e) {
		}
		return null;
	}
	@Override
	public boolean updateGrocery(Grocery groc) {
		boolean success=false;
		try {
			Grocery groc1 = entityManager.find(Grocery.class, groc.getId());
			groc1.copy(groc);
			entityManager.merge(groc1);
	        success = true;
		}catch (Exception e) {
		}
		return success;
	}
	@Override
	public boolean deleteGrocery(int gid) {
		boolean success=false;
	      try {
	         Grocery groc = entityManager.find(Grocery.class, gid);
	         entityManager.remove(groc);
	         success = true;
	      }
	      catch (Exception e) {
	      }
	      return success;
	}
	@Override
	public boolean buyGrocery(int gid) {
		boolean success=false;
	      try {
	         Grocery groc = entityManager.find(Grocery.class, gid);
	         entityManager.remove(groc);
	         success = true;
	      }
	      catch (Exception e) {
	      }
	      return success;
	}
	@Override
	public boolean confirmBuyGrocery(Grocery groc, int req) {
		boolean success=false;
	      try {
	    	  int id = groc.getId();
	         groc = entityManager.find(Grocery.class, id);
	         int unitsAvailable = groc.getQuantity();
	         groc.setQuantity(unitsAvailable-req);
	         entityManager.merge(groc);
	         // Code for storing Order. Use Order Entity for same
	         success = true;
	      }
	      catch (Exception e) {
	      }
	      return success;
	}
}
