package command;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;
import org.junit.After;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestFindNotes {

    @Test
    public void testFindNotes1() {

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

    @Test
    public void testFindNotes2() {

        Controller controller = new Controller();

        FindNotesRequest request1 = new FindNotesRequest();
        request1.setFindString("");
        request1.setCommandName("FIND_BY_NOTE");
        Response response1 = controller.doRequest(request1);
        FindNotesResponse res = (FindNotesResponse) response1;
        List<Note> noteFind = res.getFindBook();
        System.out.println("Enter the search string!" + noteFind.size());

        assertTrue(noteFind.isEmpty());
    }

    @After
    public void afterFindNotes() {
        Controller controller = new Controller();
        Request request1 = new Request();
        request1.setCommandName("CREATE_NOTEBOOK");
        controller.doRequest(request1);
    }
}
