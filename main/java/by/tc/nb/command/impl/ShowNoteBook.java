package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ShowAllNotesResponse;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class ShowNoteBook implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        Response response = new ShowAllNotesResponse();
        ShowAllNotesResponse res;
        if (response instanceof ShowAllNotesResponse) {
            res = (ShowAllNotesResponse) response;
        } else {
            throw new CommandException("Wrong response");
        }

        res.setAllBook(noteBook.getNotes());
        res.setErrorStatus(true);
        if (res.getAllBook().isEmpty()) {
            res.setResultMessage("Notebook is empty!");
        } else {
            res.setResultMessage("All OK!");
        }
        return res;
    }
}

//public class AddNewNote implements Command {
//
//    @Override
//    public Response execute(Request request) throws CommandException {
//        AddNoteRequest req = null;
//
//        if(request instanceof AddNoteRequest){
//            req = (AddNoteRequest)request;
//        }else{
//            throw new CommandException("Wrong request");
//        }
//
//        String note = req.getNote();
//
//        Note newNote = new Note(note);
//
//        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
//        noteBook.addNote(newNote);
//
//        Response response = new Response();
//        response.setErrorStatus(true);
//        response.setResultMessage("Note \"" + newNote + "\" is added!");
//
//        return response;
//    }
