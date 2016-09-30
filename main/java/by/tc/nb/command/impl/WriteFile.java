package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

import java.io.BufferedOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        Response response = new Response();
        try(FileWriter writer = new FileWriter("notebook.txt"))
        {
            for (Note note : noteBook.getNotes()) {
                String string = note.getNote() + "|" + note.getDate().getTime() + "\n";
                writer.write(string);
            }
        }
        catch(IOException e){
        }
        response.setErrorStatus(true);
        response.setResultMessage("Notebook was saved to file!");
        return response;
    }
}