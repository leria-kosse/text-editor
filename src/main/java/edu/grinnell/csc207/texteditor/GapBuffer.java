package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {

    private static final int INITIAL_SIZE = 8;
    private char[] data;
    private int cursorFirst;
    private int cursorLast;

    /**
     * Makes a new and empty GapBuffer with an initial size.
     */
    public GapBuffer() {
        data = new char[INITIAL_SIZE];
        cursorFirst = 0;
        cursorLast = data.length;
    }

    /**
     * Ensures that the backing array has room for at least one more element.
     */
    private void ensureCapacity() {
        char[] newData = new char[data.length * 2];
        for (int i = 0; i < cursorFirst; i++) {
            newData[i] = data[i];
        }
        for (int i = newData.length - 1; i >= cursorLast; i--) {
            newData[i] = data[i - (newData.length - data.length)];
        }
        cursorLast = cursorLast + (newData.length - data.length);
        data = newData;
    }

    /**
     * Inserts a character into the buffer at the position of the
     * cursorFirst (beginning of the gap).
     * If the array is full, we first expand it by calling ensureCapacity and then
     * proceed with insertion.
     *
     * @param ch the character to insert
     */
    public void insert(char ch) {
        if (cursorFirst == cursorLast) {
            ensureCapacity();
        }
        data[cursorFirst] = ch;
        cursorFirst++;
    }

    /**
     * Deletes a character from the buffer at the position of the
     * cursorFirst (beginning of the gap).
     */
    public void delete() {
        if (cursorFirst > 0) {
            cursorFirst--;
        }
    }

    /**
     * Returns the position of the cursorFirst (beginning of the gap).
     *
     * @return int indexed location of the cursor
     */
    public int getCursorPosition() {
        return cursorFirst;
    }

    /**
     * Moves the cursor one position to the left by taking the character
     * at cursorFirst - 1 and moving it to cursorLast - 1.
     */
    public void moveLeft() {
        if (cursorFirst > 0) {
            data[cursorLast - 1] = data[cursorFirst - 1];
            cursorFirst--;
            cursorLast--;
        }
    }

    /**
     * Moves the cursor one position to the right by taking the character
     * at cursorLast and moving it to cursorFirst.
     */
    public void moveRight() {
        if (cursorLast < data.length) {
            data[cursorFirst] = data[cursorLast];
            cursorFirst++;
            cursorLast++;
        }
    }

    /**
     * Returns the size of the String stored in the data (omitting the gap).
     *
     * @return int size of the String
     */
    public int getSize() {
        return cursorFirst + (data.length - cursorLast);
    }

    /**
     * Returns the character at the specified index (omitting the gap).
     *
     * @param i the zero-based index of the character to get
     * @return the character at the index given
     * @throws IndexOutOfBoundsException if it is negative or >= size of the buffer
     */
    public char getChar(int i) {
        if (i < 0 || i >= getSize()) {
            throw new IndexOutOfBoundsException();
        } else if (i < cursorFirst) {
            return data[i];
        } else {
            return data[cursorLast + (i - cursorFirst)];
        }
    }

    /**
     * Returns the contents of the buffer as a string by linking the
     * before cursor and after cursor areas into one, skipping the gap.
     *
     * @return a string representation of the buffer contents
     */
    public String toString() {
        return new String(data, 0, cursorFirst)
                + new String(data, cursorLast, data.length - cursorLast);
    }
}