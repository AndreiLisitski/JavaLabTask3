package command;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TestAddNewNote {

    @Test
    public void testAddNewNote() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        FindNotesRequest request2 = new FindNotesRequest();
        request2.setFindString(myNote);
        request2.setCommandName("FIND_BY_NOTE");
        Response response2 = controller.doRequest(request2);

        FindNotesResponse res = (FindNotesResponse) response2;
        List<Note> noteFind = res.getFindBook();

        assertEquals(noteFind.get(0).getNote(), myNote);
    }

    @After
    public void afterAddNewNote() {
        Controller controller = new Controller();
        Request request1 = new Request();
        request1.setCommandName("CREATE_NOTEBOOK");
        controller.doRequest(request1);
    }

}

