package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FindByDate implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        Response response = new FindByDateResponse();
        FindByDateResponse res;
        if (response instanceof FindByDateResponse) {
            res = (FindByDateResponse) response;
        } else {
            throw new CommandException("Wrong response");
        }
        FindByDateRequest req;
        if (request instanceof FindByDateRequest) {
            req = (FindByDateRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }
        List<Note> list = new ArrayList<Note>();
        int day = 0,  month = 0, year = 0;
        if (!req.getDay().equals("")) {
            day = Integer.parseInt(req.getDay());
        }
        if (!req.getMonth().equals("")) {
            month = Integer.parseInt(req.getMonth());
        }
        if (!req.getYear().equals("")) {
            year = Integer.parseInt(req.getYear());
        }
        for (Note note : noteBook.getNotes()) {
            Calendar calendar = Calendar.getInstance();
            Date date = note.getDate();
            calendar.setTime(date);
            int dayNote = calendar.get(Calendar.DAY_OF_MONTH);
            int monthNote = calendar.get(Calendar.MONTH);
            int yearNote = calendar.get(Calendar.YEAR);
            if (day != 0 && month != 0 && year != 0) {
                if (day == dayNote && month == monthNote && year == yearNote) {
                    list.add(note);
                }
            } else if (day != 0 && month == 0 && year == 0) {
                if (day == dayNote) {
                    list.add(note);
                }
            } else if (day == 0 && month != 0 && year == 0) {
                if (month == monthNote) {
                    list.add(note);
                }
            } else if (day == 0 && month == 0 && year != 0) {
                if (year == yearNote) {
                    list.add(note);
                }
            } else if (day != 0 && month != 0 && year == 0) {
                if (day == dayNote && month == monthNote) {
                    list.add(note);
                }
            } else if (day != 0 && month == 0 && year != 0) {
                if (day == dayNote && year == yearNote) {
                    list.add(note);
                }
            } else if (day == 0 && month != 0 && year != 0) {
                if (month == monthNote && year ==yearNote) {
                    list.add(note);
                }
            }
            res.setErrorStatus(true);
            if (list.isEmpty()) {
                res.setResultMessage("There is no notes matched your request");
            } else {
                res.setDateNotes(list);
                res.setResultMessage("All OK!");
            }
            return res;
        }

        return null;
    }
}
