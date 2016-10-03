package command;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TestCreateBook {

    @Test
    public void testCreateBook() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        Request request2 = new Request();
        request2.setCommandName("CREATE_NOTEBOOK");
        controller.doRequest(request2);

        Request request3 = new Request();
        request3.setCommandName("SHOW_NOTEBOOK");
        Response response3 = controller.doRequest(request3);
        ShowAllNotesResponse res = (ShowAllNotesResponse) response3;
        List<Note> book = res.getAllBook();

        assertTrue(book.isEmpty());
    }
}