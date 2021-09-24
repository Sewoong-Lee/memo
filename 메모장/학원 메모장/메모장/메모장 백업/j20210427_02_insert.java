package ex07_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class j20210427_02_insert {

	public static void main(String[] args) {
		//오라클에 데이터추가 :insert
		Connection conn = DBConn.getConn();
		//Statement stmt =null;
		//sql문을 간결하게, 보안에 우수
		PreparedStatement pstmt=null;  
		
		Scanner sc = new Scanner(System.in);
		System.out.print("상품코드?");
		String itemcode = sc.next();
		sc.nextLine(); //엔터값 처리 
		System.out.print("상품명?");
		String itemname = sc.nextLine();
		System.out.print("단가?");
		int price = sc.nextInt();
		
//		String sql = "INSERT INTO ITEM (ITEMCODE, ITEMNAME, PRICE) VALUES("  
//					+ "'" + itemcode +"', '" + itemname + "', " + price + ")";

		String sql = "INSERT INTO ITEM (ITEMCODE, ITEMNAME, PRICE) VALUES(?,?,?)";
		System.out.println(sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			//sql문의 ?에 값 대치
			pstmt.setString(1, itemcode);
			pstmt.setString(2,  itemname);
			pstmt.setInt(3, price);
			int cnt = pstmt.executeUpdate(); //적용된 건수를 반환
			System.out.println(cnt+"건 추가");
		} catch (SQLException e) {
			System.out.println("sql문 예외");
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");

	}

}
