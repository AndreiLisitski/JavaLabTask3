package command;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;
import org.junit.After;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class TestFindByDate {

    @Test
    public void testFindByDate1() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int dayNote = calendar.get(Calendar.DAY_OF_MONTH);
        int monthNote = calendar.get(Calendar.MONTH);
        int yearNote = calendar.get(Calendar.YEAR);

        FindByDateRequest request2 = new FindByDateRequest();
        request2.setDay(String.valueOf(dayNote));
        request2.setMonth(String.valueOf(monthNote));
        request2.setYear(String.valueOf(yearNote));
        request2.setCommandName("FIND_BY_DATE");
        Response response2 = controller.doRequest(request2);
        FindByDateResponse res = (FindByDateResponse) response2;
        List<Note> noteFind = res.getDateNotes();

        assertTrue(!noteFind.isEmpty());
    }

    @Test
    public void testFindByDate2() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int dayNote = calendar.get(Calendar.DAY_OF_MONTH);

        FindByDateRequest request2 = new FindByDateRequest();
        request2.setDay(String.valueOf(dayNote));
        request2.setMonth("");
        request2.setYear("");
        request2.setCommandName("FIND_BY_DATE");
        Response response2 = controller.doRequest(request2);
        FindByDateResponse res = (FindByDateResponse) response2;
        List<Note> noteFind = res.getDateNotes();

        assertTrue(!noteFind.isEmpty());
    }

    @Test
    public void testFindByDate3() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int monthNote = calendar.get(Calendar.MONTH);

        FindByDateRequest request2 = new FindByDateRequest();
        request2.setDay("");
        request2.setMonth(String.valueOf(monthNote));
        request2.setYear("");
        request2.setCommandName("FIND_BY_DATE");
        Response response2 = controller.doRequest(request2);
        FindByDateResponse res = (FindByDateResponse) response2;
        List<Note> noteFind = res.getDateNotes();

        assertTrue(!noteFind.isEmpty());
    }

    @Test
    public void testFindByDate4() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int yearNote = calendar.get(Calendar.YEAR);

        FindByDateRequest request2 = new FindByDateRequest();
        request2.setDay("");
        request2.setMonth("");
        request2.setYear(String.valueOf(yearNote));
        request2.setCommandName("FIND_BY_DATE");
        Response response2 = controller.doRequest(request2);
        FindByDateResponse res = (FindByDateResponse) response2;
        List<Note> noteFind = res.getDateNotes();

        assertTrue(!noteFind.isEmpty());
    }

    @Test
    public void testFindByDate5() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        FindByDateRequest request2 = new FindByDateRequest();
        request2.setDay("");
        request2.setMonth("");
        request2.setYear("");
        request2.setCommandName("FIND_BY_DATE");
        Response response2 = controller.doRequest(request2);
        FindByDateResponse res = (FindByDateResponse) response2;
        List<Note> noteFind = res.getDateNotes();

        assertTrue(noteFind.isEmpty());
    }

    @Test
    public void testFindByDate6() {

        Controller controller = new Controller();

        AddNoteRequest request1 = new AddNoteRequest();
        request1.setCommandName("ADD_NEW_NOTE");
        String myNote = "MyNote";
        request1.setNote(myNote);
        controller.doRequest(request1);

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int dayNote = calendar.get(Calendar.DAY_OF_MONTH);
        int monthNote = calendar.get(Calendar.MONTH) + 1;
        int yearNote = calendar.get(Calendar.YEAR);

        FindByDateRequest request2 = new FindByDateRequest();
        request2.setDay(String.valueOf(dayNote));
        request2.setMonth(String.valueOf(monthNote));
        request2.setYear(String.valueOf(yearNote));
        request2.setCommandName("FIND_BY_DATE");
        Response response2 = controller.doRequest(request2);
        FindByDateResponse res = (FindByDateResponse) response2;
        List<Note> noteFind = res.getDateNotes();

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