package by.tc.nb.view;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class View {
	static final String exit = "exit";
	static final String add = "add";
	static final String create = "create";
	static final String findContent = "find";
	static final String findDate = "date";
	static final String show = "show";
	static final String writeFile = "write";
	static final String readFile = "read";


	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			Calendar calendar = Calendar.getInstance();
			Date d = new Date();
			calendar.setTime (d);
			System.out.println (calendar.get(Calendar.YEAR));
			System.out.println (calendar.get(Calendar.DAY_OF_MONTH));
			System.out.println (calendar.get(Calendar.MONTH));

			System.out.print(exit + " ");
			System.out.print(add + " ");
			System.out.print(create + " ");
			System.out.print(findContent + " ");
			System.out.print(findDate + " ");
			System.out.print(show + " ");
			System.out.print(writeFile + " ");
			System.out.println(readFile);

			Controller controller = new Controller();
			System.out.println("Enter the command");
			String string = reader.readLine();
			switch (string) {
				case "exit": return;
				case "add": AddNoteRequest request = new AddNoteRequest();
					request.setCommandName("ADD_NEW_NOTE");
					System.out.println("Enter your note");
					String myNote = reader.readLine();
					request.setNote(myNote);
					Response response = controller.doRequest(request);
					if(response.isErrorStatus() ==  false){
						System.out.println(response.getErrorMessage());
					}else {
						System.out.println(response.getResultMessage());
					}
					break;
				case "show": Request request1 = new Request();
					request1.setCommandName("SHOW_NOTEBOOK");
					Response response1 = controller.doRequest(request1);
					if(response1.isErrorStatus() ==  false){
						System.out.println(response1.getErrorMessage());
					}else {
						ShowAllNotesResponse res = (ShowAllNotesResponse) response1;
						List<Note> book = res.getAllBook();
						if (!book.isEmpty()) {
							for (Note note : book) {
								System.out.println(note);
							}
						}
						System.out.println(response1.getResultMessage());
					}
					break;
				case "create": Request request2 = new Request();
					System.out.println("Are you sure you want to create a new notebook? Any unsaved " +
							"data will be lost !!! Y/N");
					String answer = reader.readLine();
					if (!(answer.equals("Y") || answer.equals("y"))) {
						break;
					}
					request2.setCommandName("CREATE_NOTEBOOK");
					Response response2 = controller.doRequest(request2);
					if(response2.isErrorStatus() ==  false){
						System.out.println(response2.getErrorMessage());
					}else {
						System.out.println(response2.getResultMessage());
					}
					break;
				case "find": FindNotesRequest request3 = new FindNotesRequest();
					System.out.println("Enter the search string!");
					String search = reader.readLine();
					request3.setFindString(search);
					request3.setCommandName("FIND_BY_NOTE");
					Response response3 = controller.doRequest(request3);
					if(response3.isErrorStatus() ==  false){
						System.out.println(response3.getErrorMessage());
					}else {
						FindNotesResponse res = (FindNotesResponse) response3;
						List<Note> noteFind = res.getFindBook();
						if (!noteFind.isEmpty()) {
							for (Note note : noteFind) {
								System.out.println(note);
							}
						}
						System.out.println(response3.getResultMessage());
					}
					break;
				case "write": Request request4 = new Request();
					request4.setCommandName("WRITE_FILE");
					Response response4 = controller.doRequest(request4);
					if(response4.isErrorStatus() ==  false){
						System.out.println(response4.getErrorMessage());
					}else {
						System.out.println(response4.getResultMessage());
					}
					break;
				case "read": Request request5 = new Request();
					request5.setCommandName("READ_FILE");
					Response response5 = controller.doRequest(request5);
					if(response5.isErrorStatus() ==  false){
						System.out.println(response5.getErrorMessage());
					}else {
						System.out.println(response5.getResultMessage());
					}
					break;
				case "date": Request request6 = new Request();
					System.out.println("Enter day of month! Example 29");
					String day = reader.readLine();
					System.out.println("Enter month! Example 8");
					String month = reader.readLine();
					System.out.println("Enter year! Example 2016");
					String year = reader.readLine();
					request4.setCommandName("WRITE_FILE");

//					request6.setFindString(search);
//					request3.setCommandName("FIND_NOTES");
				default: break;
			}

		}

		
		
	}

}
