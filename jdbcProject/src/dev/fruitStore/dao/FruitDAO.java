package dev.fruitStore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.fruitStore.model.Fruit;
import dev.fruitStore.util.DBUtil;


public class FruitDAO {

	// 전체 조회
	private Connection connection; // conn, con 으로 줄여서 표현
	private Statement statement;// DB로의 Query 전달 객체 생성 // stmt
	private ResultSet resultSet; // rs
	
	public List<Fruit> findAll() {
		List<Fruit> fruits = new ArrayList<>();
		
		// DB에 접근하는 코드 작성
		final String selectQuery = "SELECT * FROM fruit";
			
		try {
			// DB와의 연결 객체 생성
			// 필요한 라이브러리 파일 : Referenced Libraries/mysql-connector-j-8.0.33.jar
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectQuery); // 커서를 통해서 결과 데이터 꺼냄
			
			// ResultSet 객체 활용
			while (resultSet.next()) { // next() : 커서를 다음 행으로 이동시킴
				int id = resultSet.getInt("fruit_id");
				String name = resultSet.getString("fruit_name");
				// java.sql.date 패키지
				Date date = resultSet.getDate("stocking_date");
				LocalDate stock = date.toLocalDate();
				String unit = resultSet.getString("unit");
				int price = resultSet.getInt("price");
				String origin = resultSet.getString("origin");
				
				fruits.add(new Fruit(id, name, stock, unit, price, origin));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반납, 해제(순서는 역순으로 닫기)
				try {
					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		// 결과 데이터 출력(View)
		return fruits;
	}
	

	// 과일 추가
	
	public int insert(Fruit fruit) {		
		try (
			Connection connection = DBUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO fruit (fruit_name, stocking_date, unit, price, origin) VALUES (?, ?, ?, ?, ?)");
			){
			
			statement.setString(1, fruit.getName()); 
			// LocalDate -> Date 변환
			LocalDate localDate = fruit.getStock();
			Date date = Date.valueOf(localDate); 
			statement.setDate(2, date); // stocking_date
			statement.setString(3, fruit.getUnit());
			statement.setInt(4, fruit.getPrice());
			statement.setString(5, fruit.getOrigin());
			
			return statement.executeUpdate(); //executeUpdate()는 반영된 레코드의 건수를 반환
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}
		
	// 입고날짜 수정
	   public int updateStockDate(int id, LocalDate localDate) {
	      try (Connection connection = DBUtil.getConnection();
	            PreparedStatement statement = connection
	                  .prepareStatement("UPDATE fruit SET stocking_date = ? WHERE fruit_id = ?");) {

	         Date date = Date.valueOf(localDate);
	         statement.setDate(1, date);

	         statement.setInt(2, id);
	         
	         return statement.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return 0;
	   }
	   
	// 단위 수정
	   public int updateUnit(int id, String unit) {
		      try (Connection connection = DBUtil.getConnection();
		            PreparedStatement statement = connection
		                  .prepareStatement("UPDATE fruit SET unit = ? WHERE fruit_id = ?");) {

		         statement.setString(1, unit);

		         statement.setInt(2, id);
		         
		         return statement.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return 0;
		   }
	   
	 // 가격 수정
	   public int updatePrice(int id, int price) {
		      try (Connection connection = DBUtil.getConnection();
		            PreparedStatement statement = connection
		                  .prepareStatement("UPDATE fruit SET price = ? WHERE fruit_id = ?");) {

		         statement.setInt(1, price);

		         statement.setInt(2, id);
		         
		         return statement.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return 0;
		   }
	   
	 // 원산지 수정
	   public int updateOrigin(int id, String origin) {
		      try (Connection connection = DBUtil.getConnection();
		            PreparedStatement statement = connection
		                  .prepareStatement("UPDATE fruit SET origin = ? WHERE fruit_id = ?");) {

		         statement.setString(1, origin);

		         statement.setInt(2, id);
		         
		         return statement.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return 0;
		   }
	
	
	// 판매기간이 지난 과일 삭제
	public int delete() {		
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("DELETE FROM fruit WHERE stocking_date <= ?")) {
			LocalDate today = LocalDate.now();
			LocalDate endDate = today.minusDays(5);
			Date date = Date.valueOf(endDate); 
			statement.setDate(1, date);
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
