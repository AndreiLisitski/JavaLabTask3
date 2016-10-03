package command;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestShowNoteBook {

    @Test
    public void testShowNoteBook() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        Request request2 = new Request();
        request2.setCommandName("SHOW_NOTEBOOK");
        Response response2 = controller.doRequest(request2);
        ShowAllNotesResponse res = (ShowAllNotesResponse) response2;
        List<Note> book = res.getAllBook();

        assertEquals(book.get(0).getNote(), myNote);
    }
}
