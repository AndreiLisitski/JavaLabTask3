package by.tc.nb.command.impl;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ReadFile implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        Response response = new Response();
        noteBook.cleanNoteBook();
        try(BufferedReader reader = new BufferedReader(new FileReader("notebook.txt")))
        {
            String line = reader.readLine();
            while (line != null) {
                String[] mas = line.split("\\|");
                System.out.println(mas[0]);
                System.out.println(mas[1]);
                String note = mas[0];
                long date = Long.parseLong(mas[1]);
                Note fileNote = new Note(note, new Date(date));
                noteBook.addNote(fileNote);
                line = reader.readLine();
            }
            response.setErrorStatus(true);
            response.setResultMessage("Notebook was written from file!");
        }
        catch(FileNotFoundException e){
            response.setErrorMessage("File not found!");
        } catch(IOException b){
        }

        return response;
    }
}
