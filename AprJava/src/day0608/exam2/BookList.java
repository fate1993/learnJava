package day0608.exam2;

import java.util.List;

public class BookList {
	public static void main(String[] args) {
		String filePath = "E:\\book_list.csv";
		
		InsertBook ib = new InsertBook();
		
		List<Book> bookList = ib.readBookList(filePath);
		ib.insertBook(bookList);
		
		
		  for(Book book : bookList) { System.out.println(book); }
		 
	}	
}







