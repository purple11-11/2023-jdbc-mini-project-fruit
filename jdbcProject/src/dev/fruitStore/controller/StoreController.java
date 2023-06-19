package dev.fruitStore.controller;

import java.time.LocalDate;
import java.util.List;

import dev.fruitStore.dao.FruitDAO;
import dev.fruitStore.model.Fruit;
import dev.fruitStore.view.FruitOrderView;

public class StoreController {

	private final FruitDAO dao;
	private final FruitOrderView view;
	
	public StoreController() {
		dao = new FruitDAO();
		view = new FruitOrderView();
	}
	
	
	// 전체 Fruit 조회
	public void findAll() {
		List<Fruit> fruits = dao.findAll();
		
		if(fruits != null && fruits.size() != 0) {
			view.findAll(fruits);			
		} else {
			Exception errorObject = new Exception("Fruit 데이터가 존재하지 않습니다.");
			view.errorPage(errorObject);
		}
	}
	
	// Fruit 추가
	public void insert(Fruit fruit) {
	      int isSuccess = dao.insert(fruit);
	      if (isSuccess == 1) {
	         view.save();
	      } else {
	         Exception errorObject = new Exception("새로운 Fruit 데이터가 저장되지 않았습니다.");
	         view.errorPage(errorObject);
	      }
	   }
	
	// 입고날짜 수정
	   public void updateStockDate(int id, LocalDate localDate) {
	      int isSuccess = dao.updateStockDate(id, localDate);
	      if (isSuccess >= 1) {
	         view.update(isSuccess);
	      } else {
	         Exception errorObject = new Exception("Fruit 데이터가 수정되지 않았습니다.");
	         view.errorPage(errorObject);
	      }
	   }
	// 단위 수정
	   public void updateUnit(int id, String unit) {
	      int isSuccess = dao.updateUnit(id, unit);
	      if (isSuccess >= 1) {
	         view.update(isSuccess);
	      } else {
	         Exception errorObject = new Exception("Fruit 데이터가 수정되지 않았습니다.");
	         view.errorPage(errorObject);
	      }
	   }
	
	// 가격 수정
	   public void updatePrice(int id, int price) {
		      int isSuccess = dao.updatePrice(id, price);
		      if (isSuccess >= 1) {
		         view.update(isSuccess);
		      } else {
		         Exception errorObject = new Exception("Fruit 데이터가 수정되지 않았습니다.");
		         view.errorPage(errorObject);
		      }
		   }
	   
	// 원산지 수정
	   public void updateOrigin(int id, String origin) {
		      int isSuccess = dao.updateOrigin(id, origin);
		      if (isSuccess >= 1) {
		         view.update(isSuccess);
		      } else {
		         Exception errorObject = new Exception("Fruit 데이터가 수정되지 않았습니다.");
		         view.errorPage(errorObject);
		      }
		   }
	   	   
	   
	
	// 판매기간이 지난 Fruit 삭제
	public void delete() {
		int isSuccess = dao.delete();
		if(isSuccess > 0) {
			view.delete(isSuccess);
		} else {
			Exception errorObject = new Exception("판매기간이 지난 과일이 없습니다.");
			view.errorPage(errorObject);
		}
			
	}
}
