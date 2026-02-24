package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer implements Buffer {

    private String data;
    private int cursor;

    /**
     * Makes a new and empty SimpleStringBuffer with the currsor at the index 0
     */
    public SimpleStringBuffer() {
        data = "";
        cursor = 0;
    }

    /**
     * Inserts 'ch' into the buffer at the currsor position, moves the cursor
     * one postiosn forward
     * 
     * @param ch the character to insert
     */
    public void insert(char ch) {
        data = data.substring(0, cursor) + ch + data.substring(cursor);
        cursor++;
    }

    /**
     * Delets the character to the left of the current postition of the cursor, then
     * moves the cursor one position backwards. If at the begignin of the buffer, it 
     * does nothing
     */
    public void delete() {
        if (cursor > 0) {
            data = data.substring(0, cursor - 1) + data.substring(cursor);
            cursor--;
        }
    }

    /**
     * return the current posistion of the cursor
     * 
     * @return the zero-based index of the cursor
     */
    public int getCursorPosition() {
        return cursor;
    }

    /**
     * moves the cursor one position to the left, does nothing if it is at the 
     * beginning of the buffer
     */
    public void moveLeft() {
        if (cursor > 0) {
            cursor--;
        }
    }
    /**
     * Moves the cursor one position to the left, does nothing if it is at the 
     * beginning of the buffer
     */

    public void moveRight() {
        if (cursor < data.length()) {
            cursor++;
        }
    }
    
    /**
     * return the number of character currently in the buffer
     * 
     * @return the size of the buffer
     */
    public int getSize() {
        return data.length();
    }

    /**
     * return the charachter at the specified index
     * 
     * @param i the zero-based index of the character to get
     * @return the character at the index given
     * @throws IndexOutOfBoundsException if it is negative or >= size of the buffer
     */
    
    public char getChar(int i) {
        if (i > data.length() || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data.charAt(i);
    }

    /**
     * Return the contents of the buffer as a string
     * @return the buffer contents
     */
    @Override
    public String toString() {
        return data;
    }
}
