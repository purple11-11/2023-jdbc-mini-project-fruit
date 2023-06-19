package dev.fruitStore;

import java.time.LocalDate;

import dev.fruitStore.controller.StoreController;
import dev.fruitStore.model.Fruit;

public class App {

	public static void main(String[] args) {
		
		// 전체 조회
		StoreController sc = new StoreController();
		sc.findAll();
		
		// 판매할 과일 추가
//		Fruit fruit = Fruit.builder()
//	            .name("귤")
//	            .stock(LocalDate.of(2023, 6, 11))
//	            .unit("1박스")
//	            .price(13000)
//	            .origin("제주")
//	            .build();
////	      
//	      sc.insert(fruit);
		
		// 테이블의 목록 수정
//		   sc.updateStockDate(6, LocalDate.of(2023, 6, 9));
//		   sc.updateUnit(3, "1kg");
//		   sc.updatePrice(1, 15000);
//		   sc.updateOrigin(4, "멕시코");

//		   
		// 판매기간 지난 과일 삭제
//		sc.delete();
		
		
	}

}
