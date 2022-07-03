package module;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import DB.BookDAO;
import DB.BookDTO;

public class BookMethod {

	Scanner scan = new Scanner(System.in);
	BookDAO dao = new BookDAO();
	
	public BookMethod() {
		
	}

	void bookList() {
		String field = null;
		String input = null;
		
		titlePrint();
		Collection<BookDTO> book = dao.bookSelect(field, input).values();
		viewList(book);
	}
	
	void bookAdd() {
		
		BookDTO dto = new BookDTO();
		int result = 0;
		try {
			System.out.print("번호 : ");
			dto.setBn(Integer.parseInt(scan.nextLine()));
			
			System.out.print("제목 : ");
			dto.setTitle(scan.nextLine());
			
			System.out.print("저자 : ");
			dto.setAuthor(scan.nextLine());
			
			System.out.print("가격 : ");
			dto.setPrice(Integer.parseInt(scan.nextLine()));
			
			System.out.print("출판일 : ");
			dto.setPub_date(scan.nextLine());
			
			System.out.print("쪽수 : ");
			dto.setPage(Integer.parseInt(scan.nextLine()));
			
			System.out.print("출판사 : ");
			dto.setPublisher(scan.nextLine());
			
			result = dao.bookInsert(dto);
			
			if(result > 0) {
				System.out.println("등록 완료");
			} else {
				System.out.println("등록 실패");
			}
			
		
		} catch (NumberFormatException nfe) {
			System.out.println("숫자 입력해 임마!");
		}
	}
	
	void bookEdit() {
		int temp_bn = 0;
		int editMenu = 0;
		String field = "";
		String input = "";
		int result = 0;
		
		try {
			System.out.print("수정한 책의 번호 : ");
			temp_bn = Integer.parseInt(scan.nextLine());
			
			System.out.print("수정할 내용 선택 [1. 제목, 2. 저자, 3. 가격, 4. 출판일. 5. 쪽수. 6. 출판사] : ");
			editMenu = Integer.parseInt(scan.nextLine());
			
			switch(editMenu) {
				case 1 : field = "title"; break;
				case 2 : field = "author"; break;
				case 3 : field = "price"; break;
				case 4 : field = "pub_date"; break;
				case 5 : field = "page"; break;
				case 6 : field = "publisher"; break;
				default : System.out.println("Menu에서 고르십쇼!"); bookEdit();
			}
			
			System.out.print("값 입력하셈 : ");
			input = scan.nextLine();
			
		} catch (NumberFormatException nfe) {
			System.out.println("숫자 입력해 임마!");
			bookEdit();
		}
		
		result = dao.bookUpdate(temp_bn, field, input);
		
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
	
	void bookDel() {
		int result = 0;
		System.out.print("삭제할 책 번호 : ");
		try {
			result = dao.bookDelete(Integer.parseInt(scan.nextLine()));
		} catch (NumberFormatException nfe) {
			System.out.println("숫자 입력해 임마!");
			bookDel();
		}
		
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	void bookSearch() {
		int searchMenu = 0;
		String field = "";
		String input = "";
		
		System.out.print("검색 메뉴[1.번호, 2.제목, 3.저자, 4.가격, 5.출판사] : ");
		searchMenu = Integer.parseInt(scan.nextLine());
		
		switch(searchMenu) {
			case 1 : field = "bn"; break;
			case 2 : field = "title"; break;
			case 3 : field = "author"; break;
			case 4 : field = "price"; break;
			case 5 : field = "publisher"; break;
			default : System.out.println("Menu에서 고르십쇼!"); bookEdit();
		}
		
		System.out.print("뭐 검색할꺼임? : ");
		input = scan.nextLine();
		Collection<BookDTO> book = dao.bookSelect(field, input).values();
		
		titlePrint();
		viewList(book);
	}
	
	void viewList(Collection<BookDTO> book) {
		
		Iterator<BookDTO> i = book.iterator();
		
		while(i.hasNext()) {
			BookDTO dto = i.next();
			System.out.printf("%d\t%-25s\t%-20s\t%d\t%-15s\t%d\t%s\n", 
					dto.getBn(), dto.getTitle(), dto.getAuthor(), dto.getPrice(), dto.getPub_date(), dto.getPage(), dto.getPublisher());
		}
	}
	
	void exit_bookMgr() {
		System.exit(0);
	}
	
	void titlePrint() {
		System.out.printf("%s\t%-25s\t%-20s\t%s\t%-10s\t%s\t%s\n", "번호","제목","저자","가격","출판일","쪽수","출판사");
	}
}
