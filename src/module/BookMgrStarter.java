package module;

import java.util.Scanner;

public class BookMgrStarter {

	Scanner scan = new Scanner(System.in);
	BookMethod bm = new BookMethod();
	
	public BookMgrStarter() {
		
		BookDataSet.dataLoad();
		
		do {
			try {
				System.out.print(menu());
				int bookMenu = Integer.parseInt(scan.nextLine());
				
				switch(bookMenu){
					case 1 : bm.bookList(); break;
					case 2 : bm.bookInsert(); break;
					case 3 : bm.bookEdit(); break;
					case 4 : bm.bookDelete(); break;
					case 5 : bm.bookSearch(); break;
					case 6 : bm.exit_bookMgr(); break;
					default : throw new NumberFormatException();
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Menu내 숫자를 입력하세요");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while(true);
		
		
	}

	String menu() {
		return "메뉴 책 관리 [1.목록, 2.등록, 3.정보 수정, 4.삭제, 5. 검색, 6. 종료] : ";
	}
}
