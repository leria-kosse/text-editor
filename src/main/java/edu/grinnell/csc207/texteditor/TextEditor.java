package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * The helper method for the TextEditor application, that will draw the buffer.
     * 
     * @param GapBuffer and the screen we are drawing this on.
     * @throws IOException
     */
    public static void drawBuffer(GapBuffer bufy, Screen screen) throws IOException {
        screen.clear();

        for (int i = 0; i < bufy.getSize(); i++) {
            screen.setCharacter(i, 0, TextCharacter.fromCharacter(bufy.getChar(i))[0]);
        }

        screen.setCursorPosition(new TerminalPosition(bufy.getCursorPosition(), 0));
        screen.refresh();
    }

    /**
     * The main entry point for the TextEditor application.
     * 
     * @param args command-line arguments.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

 
        String path = args[0];
        GapBuffer bufy = new GapBuffer();

        

        // load file if its a thing
        Path filePath = Paths.get(path);
        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            String thingsStored = Files.readString(filePath);

            for (char ch : thingsStored.toCharArray()) {
                bufy.insert(ch);

            }

        }

        // step up screen
        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
        System.out.format("Loading %s...\n", path);

        // makes initial screen
        drawBuffer(bufy, screen);

        // input loop
        boolean isRunning = true;
        while (isRunning) {
            KeyStroke stroke = screen.readInput();
            // Processes the key stroke!
            if (stroke.getKeyType().equals(KeyType.Character)) {
                bufy.insert(stroke.getCharacter());
            } else if (stroke.getKeyType().equals(KeyType.ArrowLeft)) {
                bufy.moveLeft();
            } else if (stroke.getKeyType().equals(KeyType.ArrowRight)) {
                bufy.moveRight();
            } else if (stroke.getKeyType().equals(KeyType.Backspace)) {
                bufy.delete();
            } else if (stroke.getKeyType().equals(KeyType.Escape)) {
                isRunning = false;
            }
            drawBuffer(bufy, screen);
        }


        screen.stopScreen();
        Files.writeString(filePath, bufy.toString());

    }

}
