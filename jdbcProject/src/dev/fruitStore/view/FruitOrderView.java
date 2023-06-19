package dev.fruitStore.view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.fruitStore.model.Fruit;

public class FruitOrderView {

	public void findAll(List<Fruit> fruits) {
		for (Fruit fruit : fruits) {
            System.out.println(String.format("%s(%s산)은(는) %s에 %d원입니다.", fruit.getName(), fruit.getOrigin(), fruit.getUnit(), fruit.getPrice()));
            System.out.println(fruit.getStock().format(DateTimeFormatter.ofPattern("입고일은 yyyy년 MM월 dd일 입니다.")));
            System.out.println();
		}
	}
	
	public void save() {
	      System.out.println("판매 가능한 과일이 추가 되었습니다.");
	   }
	
	public void update(int affectedRows) {
	      System.out.println(affectedRows + "종류의 과일이 수정되었습니다. ");
	   }
	
	public void delete(int affectedRows) {
		System.out.println("판매기간이 지난 " + affectedRows +"종류의 과일이 삭제되었습니다.");
	}
	
	
	 public void errorPage(Exception error) {
	        System.out.println("문제가 발생하였습니다." + error.getMessage());
	    }
}
