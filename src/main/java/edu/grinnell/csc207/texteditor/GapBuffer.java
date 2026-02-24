package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {

    private static final int INITIAL_SIZE = 8;
    private char[] data;
    private int sz;
    private int cursor_first;
    private int cursor_last;
    
    
    /**
     * Makes a new and empty GapBuffer with an intital size
     */
    public GapBuffer() {
        data = new char[INITIAL_SIZE]; 
        cursor_first = 0;
        cursor_last = data.length;
        sz = 0;
    }

    /** 
     * Ensures that the backing array has room for atleast one more element
    */
    private void ensureCapacity() {
            char[] newData = new char[data.length * 2];
            for(int i = 0; i < cursor_first; i++)
            {
                newData[i] = data[i];
            }
            for (int i = newData.length - 1; i > cursor_last; i--)
            {
                newData[i] = data[i - (newData.length - data.length)];
            }
            cursor_last = cursor_last + (newData.length - data.length);
            data = newData;
    }
    
    /**
     * Inserts a character into the buffer at the position of the cursor_first(beginning of the gap).
     * If the array is full, we first expand it by callind esureCapacity and then proceed with 
     * insertion.
     * 
     * @param ch the character to insert
     */
    public void insert(char ch) {
       if (cursor_first==cursor_last)
        {
            ensureCapacity();
        }

        data[cursor_first] = ch;
        cursor_first++;
    }

    
    public void delete() {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public int getCursorPosition() {
        throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
    }

    public void moveLeft() {
        throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    public void moveRight() {
        throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    public int getSize() {
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    public char getChar(int i) {
        throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
