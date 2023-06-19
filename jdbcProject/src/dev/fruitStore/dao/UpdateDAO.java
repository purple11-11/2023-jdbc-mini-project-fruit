package dev.fruitStore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import dev.fruitStore.util.DBUtil;

public class UpdateDAO {
	
	// 전체 조회
	private Connection connection; // conn, con 으로 줄여서 표현
	private Statement statement;// DB로의 Query 전달 객체 생성 // stmt
	
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
}
