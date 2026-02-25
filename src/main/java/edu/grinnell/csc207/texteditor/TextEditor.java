package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

import com.googlecode.lanterna.screen.Screen;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        // TODO: fill me in with a text editor TUI!
        String path = args[0];

        GapBuffer bufy = new GapBuffer();

        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();



        System.out.format("Loading %s...\n", path);
    }

    public static void drawBufferr(GapBuffer buf, Screen screen){

        for(int i = 0; i < bufy..getSize(); i++) {
            screen.setCharacter(0, i, TextCharacter.fromCharacter(buf))
        }

    }
}
