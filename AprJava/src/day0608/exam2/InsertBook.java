package day0608.exam2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertBook {

	BookDao dao = new BookDao();

	public List<Book> readBookList(String filePath) {
		List<Book> bookList = new ArrayList<>();
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"euc-kr"));) {
			//Charset.forName("UTF-8");
			String message = "";
			while ((message = br.readLine()) != null) {
				String[] b = message.split(",");
				Book book = new Book(Integer.parseInt(b[0]), b[1], b[2], Integer.parseInt(b[3]));
				bookList.add(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	public void insertBook(List<Book> list) {

		for (Book b : list) {
			dao.insertBook(b);
		}
	}

}
