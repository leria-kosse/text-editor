package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import net.jqwik.api.*;


public class SimpleStringBufferTests {
    /** TODO: fill me in with unit and property tests! */

    @Test
    public void testingItRightNow() {
        SimpleStringBuffer bufy = new SimpleStringBuffer();

        //Typing new words
        for (char ch : "Hello world!".toCharArray()) {
            bufy.insert(ch);
        }

        assertEquals("Hello world!", bufy.toString());
        assertEquals(12, bufy.getCursorPosition());

        //move it 9 times to the left
        for (int i = 0; i < 9; i++){
            bufy.moveLeft();
        }
        assertEquals(3, bufy.getCursorPosition());

        //delets 6 times 
        for (int i = 0; i < 3; i++){
            bufy.delete();
        }
        assertEquals("lo world!", bufy.toString());

        bufy.insert('W');
        bufy.insert('h');

        assertEquals("Whlo world!", bufy.toString());
        assertEquals(2, bufy.getCursorPosition());
   
    }

    /**
     * Test a newly made buffer is indeed empty
     */
    @Test
    public void testEmptyBuffer() {
         SimpleStringBuffer bufy = new SimpleStringBuffer();
         assertEquals("", bufy.toString());
         assertEquals(0, bufy.getCursorPosition());
         assertEquals(0, bufy.getSize());
    }

    /**
     * Test getSize method
     */

    @Test
    public void testGetSize() {
        SimpleStringBuffer bufy = new SimpleStringBuffer();

         assertEquals(0, bufy.getSize());

        bufy.insert('a');
        bufy.insert('b');
        
        assertEquals(2, bufy.getSize());

        bufy.delete();
        assertEquals(1, bufy.getSize());
    }

    /**
     * Test getChar gives returns correctly
     */

    @Test
    public void testGetChar() {
        SimpleStringBuffer bufy = new SimpleStringBuffer();

        bufy.insert('a');
        bufy.insert('b');
        bufy.insert('c');
        assertEquals('a', bufy.getChar(0));
        assertEquals('b', bufy.getChar(1));
        assertEquals('c', bufy.getChar(2));
    }

    /**
     * Testing a negative getChar value
     */
    @Test
    public void testNegativeGetCharIndex() {
        SimpleStringBuffer bufy = new SimpleStringBuffer();

        bufy.insert('a');

        assertThrows(IndexOutOfBoundsException.class, () -> bufy.getChar(-1));
    }

    /**
     * Testing instering in the middel of a word
     */
    @Test
    public void testInsertInMiddel() {
        SimpleStringBuffer bufy = new SimpleStringBuffer();

        bufy.insert('a');
        bufy.insert('c');
        bufy.moveLeft();
        bufy.insert('b');

        assertEquals("abc", bufy.toString());
        assertEquals(2, bufy.getCursorPosition());
    }


    /**
     * Test Delete on a new buffer
     */
    @Test
    public void testDeleteOnEmpty() {
        SimpleStringBuffer bufy = new SimpleStringBuffer();
        
        bufy.delete();
        assertEquals("", bufy.toString());
        assertEquals(0, bufy.getCursorPosition());
    }

    /**
     * Test move left at the beginning of a new buffer
     */
    @Test
    public void testMoveLeftAtBeginning() {
        SimpleStringBuffer bufy = new SimpleStringBuffer();
        
        bufy.moveLeft();
        assertEquals(0, bufy.getCursorPosition());
    }

    /**
     * Test Move right at the end of a buffer
     */

    @Test
    public void testMoveRightAtEnd () {
        SimpleStringBuffer bufy = new SimpleStringBuffer();

        bufy.insert('a');
        bufy.moveRight();

        assertEquals(1, bufy.getCursorPosition());
    }

    /**
     * Test that getChar throws IndexOutOfBoundsException for index >= size
     */

    @Test
    public void testGetCharOutOfBounds () {
        SimpleStringBuffer bufy = new SimpleStringBuffer();

        bufy.insert('a');

        assertThrows(IndexOutOfBoundsException.class, () -> bufy.getChar(1));
    }


    /**
     * 
     * Property: inserting 'n' characters should always get us a buffer that of size 'n'
     * and a corsor position at 'n'. 
     */

    @Property
    public void bufferSizeCursorPos (@ForAll String s) {
            SimpleStringBuffer bufy = new SimpleStringBuffer();

            for(char ch : s.toCharArray()) { 
                bufy.insert(ch);
            }

            assertEquals(s.length(), bufy.getSize());
            assertEquals(s.length(), bufy.getCursorPosition());
            assertEquals(s, bufy.toString());
    }
    
}
