package edu.grinnell.csc207.texteditor;

/**
 * A buffer captures the backing data structure for our text editor.
 * It keeps a sequence of character and a cursor position
 */
public interface Buffer {

    /**
     * inserts into the buffer at the current positions of the cursor
     * 
     * @param ch the character to insert
     */
    public void insert(char ch);

    /**
     * Delets the character to the left of the current postition of the cursor, then
     * moves the cursor one position backwards. If at the begignin of the buffer, it 
     * does nothing
     */
    public void delete();

    /**
     * Returns the current posistion of the cursor
     * 
     * @return the zer-based index of the cursor 
     */
    public int getCursorPosition();

    /**
     * Moves the cursor one posistion to the left. Does nothing if at the begigning
     * of the buffer.
     */
    public void moveLeft();

    /**
     *  Moves the cursor one posistion to the right. Does nothing if at the begigning
     * of the buffer.
     */
    public void moveRight();

    /**
     * Returns the number of character currently in the Buffer
     * @return the size of the buffer
     */
    public int getSize();

    /**
     * return the character at the specifed index
     * 
     * @param i the zero-based index of the character to get
     * @return the character at the index given
     * @throws IndexOutOfBoundsException if it is negative or >= size of the buffer
     */
    public char getChar(int i);

    /**
     * Gets the contents of the buffer as a string
     * 
     * @return the buffer contents
     */
    public String toString();
}
