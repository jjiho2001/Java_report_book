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
				System.out.println("Menu�� ���ڸ� �Է��ϼ���");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while(true);
		
		
	}

	String menu() {
		return "�޴� å ���� [1.���, 2.���, 3.���� ����, 4.����, 5. �˻�, 6. ����] : ";
	}
}
