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
			System.out.print("��ȣ : ");
			dto.setBn(Integer.parseInt(scan.nextLine()));
			
			System.out.print("���� : ");
			dto.setTitle(scan.nextLine());
			
			System.out.print("���� : ");
			dto.setAuthor(scan.nextLine());
			
			System.out.print("���� : ");
			dto.setPrice(Integer.parseInt(scan.nextLine()));
			
			System.out.print("������ : ");
			dto.setPub_date(scan.nextLine());
			
			System.out.print("�ʼ� : ");
			dto.setPage(Integer.parseInt(scan.nextLine()));
			
			System.out.print("���ǻ� : ");
			dto.setPublisher(scan.nextLine());
			
			result = dao.bookInsert(dto);
			
			if(result > 0) {
				System.out.println("��� �Ϸ�");
			} else {
				System.out.println("��� ����");
			}
			
		
		} catch (NumberFormatException nfe) {
			System.out.println("���� �Է��� �Ӹ�!");
		}
	}
	
	void bookEdit() {
		int temp_bn = 0;
		int editMenu = 0;
		String field = "";
		String input = "";
		int result = 0;
		
		try {
			System.out.print("������ å�� ��ȣ : ");
			temp_bn = Integer.parseInt(scan.nextLine());
			
			System.out.print("������ ���� ���� [1. ����, 2. ����, 3. ����, 4. ������. 5. �ʼ�. 6. ���ǻ�] : ");
			editMenu = Integer.parseInt(scan.nextLine());
			
			switch(editMenu) {
				case 1 : field = "title"; break;
				case 2 : field = "author"; break;
				case 3 : field = "price"; break;
				case 4 : field = "pub_date"; break;
				case 5 : field = "page"; break;
				case 6 : field = "publisher"; break;
				default : System.out.println("Menu���� ���ʼ�!"); bookEdit();
			}
			
			System.out.print("�� �Է��ϼ� : ");
			input = scan.nextLine();
			
		} catch (NumberFormatException nfe) {
			System.out.println("���� �Է��� �Ӹ�!");
			bookEdit();
		}
		
		result = dao.bookUpdate(temp_bn, field, input);
		
		if(result > 0) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}
	
	void bookDel() {
		int result = 0;
		System.out.print("������ å ��ȣ : ");
		try {
			result = dao.bookDelete(Integer.parseInt(scan.nextLine()));
		} catch (NumberFormatException nfe) {
			System.out.println("���� �Է��� �Ӹ�!");
			bookDel();
		}
		
		if(result > 0) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}
	
	void bookSearch() {
		int searchMenu = 0;
		String field = "";
		String input = "";
		
		System.out.print("�˻� �޴�[1.��ȣ, 2.����, 3.����, 4.����, 5.���ǻ�] : ");
		searchMenu = Integer.parseInt(scan.nextLine());
		
		switch(searchMenu) {
			case 1 : field = "bn"; break;
			case 2 : field = "title"; break;
			case 3 : field = "author"; break;
			case 4 : field = "price"; break;
			case 5 : field = "publisher"; break;
			default : System.out.println("Menu���� ���ʼ�!"); bookEdit();
		}
		
		System.out.print("�� �˻��Ҳ���? : ");
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
		System.out.printf("%s\t%-25s\t%-20s\t%s\t%-10s\t%s\t%s\n", "��ȣ","����","����","����","������","�ʼ�","���ǻ�");
	}
}
