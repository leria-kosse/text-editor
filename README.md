# CSC 207: Text Editor

**Author**: Robel Gebeyehu, Valeriia Kosse

## Resources Used

+ Project descripton: https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
+ VS Code
+ 

## Changelog

_(TODO: fill me in with a log of your committed changes)_

## Part 2: Analyzing the Simple String Buffer
Relevant input: data.length() because it depends on the length of the string how many characters are going to copied every time;
Critical operation: character copying, which occurs when substring constructs new strings;
Mathematical model: each call to insert performs two substring operations. Worst case is always, because we want to copy all characters. Thus, T(n) = n;
Big-O: O(n) = n;

The inefficiency comes from the fact that string is immutable in Java, thus we have to create a copy of characters every time we want to insert a character at a specific index. Same thing is happening with the remove method as we create two substrings. This is quite an efficient and we think it would be better to create a dynamic area of characters to store them and make these modifications less time consuming and more efficient.

