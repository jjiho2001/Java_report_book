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
			System.out.print("��ȣ : ");
			bi.setBn(Integer.parseInt(scan.nextLine()));
			
			System.out.print("���� : ");
			bi.setTitle(scan.nextLine());
			
			System.out.print("���� : ");
			bi.setAuthor(scan.nextLine());
			
			System.out.print("���� : ");
			bi.setPrice(Integer.parseInt(scan.nextLine()));
			
			System.out.print("������ : ");
			bi.setPub_date(scan.nextLine());
			
			System.out.print("�ʼ� : ");
			bi.setPage(Integer.parseInt(scan.nextLine()));
			
			System.out.print("���ǻ� : ");
			bi.setPublisher(scan.nextLine());
			
			BookDataSet.bookList.put(bi.getBn(), bi);
			
			System.out.println("��� �Ϸ�");
			
			BookDataSet.dataSave();
		
		} catch (NumberFormatException nfe) {
			System.out.println("���� �Է��ϼ�");
		}
	}
	
	void bookEdit() {
		int temp_bn = 0;
		int editMenu = 0;
		try {
			System.out.print("������ å�� ��ȣ : ");
			temp_bn = Integer.parseInt(scan.nextLine());
			
			System.out.print("������ ���� ���� [1. ����, 2. ����, 3. ����, 4. ������. 5. �ʼ�. 6. ���ǻ�] : ");
			editMenu = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println("���� �Է��� �Ӹ�!");
			bookEdit();
		}
		editExec(editMenu, temp_bn);
	}
	
	void editExec(int editMenu, int bn) {
		BookInfo bi = BookDataSet.bookList.get(bn);
		
		try {
			System.out.print("���� �Է��ϼ� : ");
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
					System.out.println("Menu���� ���ʼ�!"); bookEdit();
			}
			System.out.println("�����");
			BookDataSet.dataSave();
		} catch (NumberFormatException nfe) {
			System.out.println("���� �Է��� �Ӹ�!");
			bookEdit();
		}
	}
	
	/*
	void notice(String indexName, String data) {
		System.out.println(indexName + "��" + data + "�� ����Ǿ����ϴ�.");
	}
	*/
	
	void bookDelete() {
		System.out.print("������ å ��ȣ : ");
		BookDataSet.bookList.remove(Integer.parseInt(scan.nextLine()));
		System.out.println("����");
		BookDataSet.dataSave();
	}
	
	void bookSearch() {
		
		//System.out.print("�˻��� �׸� [1. ����, 2. ����, 3. ����, 4. ������. 5. ���ǻ�] : ");
		//int searchMenu = Integer.parseInt(scan.nextLine());
		System.out.print("�˻��� ���� : ");
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
		System.out.printf("%s\t%-25s\t%-20s\t%-15s\t%s\t%s\n", "��ȣ","����","����","����","������","�ʼ�","���ǻ�");
		//System.out.println("��ȣ\t����" + title_Tap + "\t����" + author_Tap + "\t����\t������\t\t�ʼ�\t���ǻ�");
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
