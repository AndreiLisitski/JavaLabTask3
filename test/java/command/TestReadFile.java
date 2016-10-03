package command;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestReadFile {

    @Test
    public void testReadFile() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        Request request2 = new Request();
        request2.setCommandName("WRITE_FILE");
        controller.doRequest(request2);

        Request request3 = new Request();
        request3.setCommandName("CREATE_NOTEBOOK");
        controller.doRequest(request3);

        Request request4 = new Request();
        request4.setCommandName("READ_FILE");
        controller.doRequest(request4);

        FindNotesRequest request5 = new FindNotesRequest();
        request5.setFindString(myNote);
        request5.setCommandName("FIND_BY_NOTE");
        Response response5 = controller.doRequest(request5);
        FindNotesResponse res = (FindNotesResponse) response5;
        List<Note> noteFind = res.getFindBook();

        assertEquals(noteFind.get(0).getNote(), myNote);
    }
}
