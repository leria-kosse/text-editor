package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {

    private static final int INITIAL_SIZE = 8;
    private char[] data;
    private int cursor_first;
    private int cursor_last;

    /**
     * Makes a new and empty GapBuffer with an intital size
     */
    public GapBuffer() {
        data = new char[INITIAL_SIZE];
        cursor_first = 0;
        cursor_last = data.length;
    }

    /**
     * Ensures that the backing array has room for atleast one more element
     */
    private void ensureCapacity() {
        char[] newData = new char[data.length * 2];
        for (int i = 0; i < cursor_first; i++) {
            newData[i] = data[i];
        }
        for (int i = newData.length - 1; i >= cursor_last; i--) {
            newData[i] = data[i - (newData.length - data.length)];
        }
        cursor_last = cursor_last + (newData.length - data.length);
        data = newData;
    }

    /**
     * Inserts a character into the buffer at the position of the
     * cursor_first(beginning of the gap).
     * If the array is full, we first expand it by callind esureCapacity and then
     * proceed with
     * insertion.
     * 
     * @param ch the character to insert
     */
    public void insert(char ch) {
        if (cursor_first == cursor_last) {
            ensureCapacity();
        }

        data[cursor_first] = ch;
        cursor_first++;
    }

    /**
     * Deletes a character from the buffer at the position of the
     * cursor_first(beginning of the gap).
     * 
     */
    public void delete() {
        if (cursor_first > 0) {
            cursor_first--;
        }
    }

    /**
     * Returns the position of the cursor_first(beginning of the gap).
     * 
     * @return int indexed location of the cursor
     */
    public int getCursorPosition() {
        return cursor_first;
    }

    /**
     * Moves the cursor one position to the left by taking the character
     * at cursor_first - 1 and moving it to cursor_last - 1.
     * 
     */
    public void moveLeft() {
        if (cursor_first > 0) {
            data[cursor_last - 1] = data[cursor_first - 1];
            cursor_first--;
            cursor_last--;
        }
    }

    /**
     * Moves the cursor one position to the right by taking the character
     * at cursor_last and moving it to cursor_first.
     * 
     */
    public void moveRight() {
        if (cursor_last < data.length) {
            data[cursor_first] = data[cursor_last];
            cursor_first++;
            cursor_last++;
        }
    }

    /**
     * Returns the size of the String stored in the data (omitting the gap).
     * 
     * @return int size of the String
     */
    public int getSize() {
        return cursor_first + (data.length - cursor_last);
    }

    /**
     * return the character at the specified index (omitting the gap)
     * 
     * @param i the zero-based index of the character to get
     * @return the character at the index given
     * @throws IndexOutOfBoundsException if it is negative or >= size of the buffer
     */
    public char getChar(int i) {
        if (i < 0 || i >= getSize()) {
            throw new IndexOutOfBoundsException();
        } else if (i < cursor_first) {
            return data[i];
        } else {
            return data[cursor_last + (i - cursor_first)];
        }
    }


    /**
     * Returns the contents of the buffer as a string by linking the 
     * before cursor and after cursor areas into one skipping the gap
     */

    

    public String toString() {
        return new String(data, 0, cursor_first) + new String(data, cursor_last, data.length - cursor_last);
    }

}