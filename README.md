# CSC 207: Text Editor

**Author**: Robel Gebeyehu, Valeriia Kosse

## Resources Used

+ Project descripton: https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
+ VS Code + Quick Fix for IOException
+ 

## Changelog

commit 625418f889b0b1659b9a978255a9b3f43c26b5f1 (HEAD -> main, origin/main, origin/HEAD)
Author: leria-kosse <leria.kosse@gmail.com>
Date:   Sun Mar 1 14:27:34 2026 -0600

    Stylistic changes

commit 98fcb2e7f21e2ee2c32ca80a3393970410069801
Author: leria-kosse <leria.kosse@gmail.com>
Date:   Sun Mar 1 14:07:26 2026 -0600

    Changes from a different repository pasted

commit 5046d0b1d24a11969647f1dba7aa8a4f0e26dafe
Merge: 15814e8 6516bc9
Author: leria-kosse <leria.kosse@gmail.com>
Date:   Sun Mar 1 13:55:21 2026 -0600

    Merge branch 'main' of github.com:leria-kosse/tex
t-editor

commit 15814e8e40b548fa9b3df3c3af006bf7b56303c7
Author: leria-kosse <leria.kosse@gmail.com>
Date:   Sun Mar 1 13:51:51 2026 -0600

    new changes

commit 6516bc9729938cc7e2b9cf6c6948e11cb74eb69c
Author: Mac Book <robelg@Robels-MBP.grinnell.edu>
Date:   Wed Feb 25 23:12:57 2026 -0600

    Project done for most part

commit 6ac39dc350aaf12faf34dfc566b4bdf8846b1fcc
Author: Mac Book <robelg@Robels-MBP.grinnell.edu>
Date:   Wed Feb 25 11:26:39 2026 -0600

    cntl c, cntlr v -done

commit b9cf3e549b3996a16f18f5719968f501e5da1882
Author: leria-kosse <leria.kosse@gmail.com>
Date:   Tue Feb 24 22:13:48 2026 -0600

    part 3 done, part 1 tests completed

commit 6b4f466deb6310d46178e7980a4b4becff68a838
Author: leria-kosse <leria.kosse@gmail.com>
Date:   Mon Feb 23 21:38:55 2026 -0600

    Part 3 done-ish

commit 91dcdf18a5fa95fa4e174e97bd544eaf462f538f
Author: leria-kosse <leria.kosse@gmail.com>
Date:   Mon Feb 23 21:14:33 2026 -0600

    Part 1 and 2 Done

commit 7ded0c02e68a1328a95626c345af254fc4cf6e94
Author: leria-kosse <49876281+leria-kosse@users.norep
ly.github.com>
Date:   Mon Feb 23 20:13:43 2026 -0600

    Initial commit

## Part 2: Analyzing the Simple String Buffer
Relevant input: data.length() because it depends on the length of the string how many characters are going to copied every time;
Critical operation: character copying, which occurs when substring constructs new strings;
Mathematical model: each call to insert performs two substring operations. Worst case is always, because we want to copy all characters. Thus, T(n) = n;
Big-O: O(n);

The inefficiency comes from the fact that string is immutable in Java, thus we have to create a copy of characters every time we want to insert a character at a specific index. Same thing is happening with the remove method as we create two substrings. This is quite an efficient and we think it would be better to create a dynamic area of characters to store them and make these modifications less time consuming and more efficient.

