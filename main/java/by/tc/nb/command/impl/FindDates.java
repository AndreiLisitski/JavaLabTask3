package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

import java.util.ArrayList;
import java.util.List;

public class FindDates implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        Response response = new FindDatesResponse();
        FindDatesResponse res;
        if (response instanceof FindDatesResponse) {
            res = (FindDatesResponse) response;
        } else {
            throw new CommandException("Wrong response");
        }
        FindDatesRequest req;
        if (request instanceof FindDatesRequest) {
            req = (FindDatesRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        List<Note> list = new ArrayList<Note>();

        return null;
    }
}
//    @Override
//    public Response execute(Request request) throws CommandException {
//        List<Note> list = new ArrayList<Note>();
//        for (Note note : noteBook.getNotes()) {
//            if (note.getNote().contains(req.getFindString())) {
//                list.add(note);
//            }
//        }
//        res.setErrorStatus(true);
//        if (list.isEmpty()) {
//            res.setResultMessage("There is no notes matched your request");
//        } else {
//            res.setFindBook(list);
//            res.setResultMessage("All OK!");
//        }
//        return res;
//    }