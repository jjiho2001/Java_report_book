package module;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class BookMethod {

	Scanner scan = new Scanner(System.in);
	//static String title_Tap = "";
	//static String author_Tap = "";
	static int title_tap = 0;
	static int author_tap = 0;
	public BookMethod() {
		
	}

	void bookList() {
		
		titlePrint();
		
		Collection<BookInfo> book = BookDataSet.bookList.values();
		Iterator<BookInfo> i = book.iterator();
		
		while(i.hasNext()) {
			//System.out.println(i.next().toString());
			i.next().viewList();
		}
	}
	
	void bookInsert() {
		
		BookInfo bi = new BookInfo();
		
		try {
			System.out.print("번호 : ");
			bi.setBn(Integer.parseInt(scan.nextLine()));
			
			System.out.print("제목 : ");
			bi.setTitle(scan.nextLine());
			
			System.out.print("저자 : ");
			bi.setAuthor(scan.nextLine());
			
			System.out.print("가격 : ");
			bi.setPrice(Integer.parseInt(scan.nextLine()));
			
			System.out.print("출판일 : ");
			bi.setPub_date(scan.nextLine());
			
			System.out.print("쪽수 : ");
			bi.setPage(Integer.parseInt(scan.nextLine()));
			
			System.out.print("출판사 : ");
			bi.setPublisher(scan.nextLine());
			
			BookDataSet.bookList.put(bi.getBn(), bi);
			
			System.out.println("등록 완료");
			
			BookDataSet.dataSave();
		
		} catch (NumberFormatException nfe) {
			System.out.println("숫자 입력하셈");
		}
	}
	
	void bookEdit() {
		int temp_bn = 0;
		int editMenu = 0;
		try {
			System.out.print("수정한 책의 번호 : ");
			temp_bn = Integer.parseInt(scan.nextLine());
			
			System.out.print("수정할 내용 선택 [1. 제목, 2. 저자, 3. 가격, 4. 출판일. 5. 쪽수. 6. 출판사] : ");
			editMenu = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println("숫자 입력해 임마!");
			bookEdit();
		}
		editExec(editMenu, temp_bn);
	}
	
	void editExec(int editMenu, int bn) {
		BookInfo bi = BookDataSet.bookList.get(bn);
		
		try {
			System.out.print("값을 입력하셈 : ");
			switch(editMenu) {
				case 1 : 
					bi.setTitle(scan.nextLine()); break;
				case 2 : 
					bi.setAuthor(scan.nextLine()); break;
				case 3 : 
					bi.setPage(Integer.parseInt(scan.nextLine())); break;
				case 4 :
					bi.setPub_date(scan.nextLine()); break;
				case 5 : 
					bi.setPage(Integer.parseInt(scan.nextLine())); break;
				case 6 : 
					bi.setPublisher(scan.nextLine()); break;
				default : 
					System.out.println("Menu에서 고르십쇼!"); bookEdit();
			}
			System.out.println("변경됨");
			BookDataSet.dataSave();
		} catch (NumberFormatException nfe) {
			System.out.println("숫자 입력해 임마!");
			bookEdit();
		}
	}
	
	/*
	void notice(String indexName, String data) {
		System.out.println(indexName + "가" + data + "로 변경되었습니다.");
	}
	*/
	
	void bookDelete() {
		System.out.print("삭제할 책 번호 : ");
		BookDataSet.bookList.remove(Integer.parseInt(scan.nextLine()));
		System.out.println("삭제");
		BookDataSet.dataSave();
	}
	
	void bookSearch() {
		
		//System.out.print("검색할 항목 [1. 제목, 2. 저자, 3. 가격, 4. 출판일. 5. 출판사] : ");
		//int searchMenu = Integer.parseInt(scan.nextLine());
		System.out.print("검색할 내용 : ");
		String str = scan.nextLine();
		
		titlePrint();
		
		for (Integer i : BookDataSet.bookList.keySet()) {
			if(BookDataSet.bookList.get(i).getAuthor().equals(str)
				||BookDataSet.bookList.get(i).getTitle().equals(str)
				||String.valueOf(BookDataSet.bookList.get(i).getPrice()).equals(str)
				||BookDataSet.bookList.get(i).getPub_date().equals(str)
				||BookDataSet.bookList.get(i).getPublisher().equals(str))
				System.out.println(BookDataSet.bookList.get(i).toString()); 
		}
	}
	
	void exit_bookMgr() {
		System.exit(0);
	}
	
	void titlePrint() {
		addTap("title");
		addTap("author");
		System.out.printf("%s\t%-25s\t%-20s\t%-15s\t%s\t%s\n", "번호","제목","저자","가격","출판일","쪽수","출판사");
		//System.out.println("번호\t제목" + title_Tap + "\t저자" + author_Tap + "\t가격\t출판일\t\t쪽수\t출판사");
	}
	
	public void addTap(String indexName) {
		int tap = 6;
		
		for(Integer i : BookDataSet.bookList.keySet()) {
			if(indexName.equals("title")) {
				if(BookDataSet.bookList.get(i).getTitle().length() >= tap){
					title_tap++;
					tap += 6;
				}
			} else if(indexName.equals("author")) {
				if(BookDataSet.bookList.get(i).getAuthor().length() >= tap){
					author_tap++;
					tap += 6;
				}
			} 
		}
		tap = 6;
	}
}
