twitch coding challenge
======
INSTALL DETAILS
------
To run SpellChecker "java -jar SpellChecker/SpellChecker.jar"
To pipe test output to SpellChecker run "java -jar Tester/Tester.jar | java -jar SpellChecker/SpellChecker.jar"

Approach
-------

I start by precomputing a prefix tree with the dictionary provided. Because this should be strictly precomputed, I didn't count this as a violation of the O(n) runtime restriction.

Then I can search this prefix tree for words that I input in my SpellChecker file by doing a simple DFS. Because this techinique prunes the search space by not continuing the search prefixes that do not exist in the tree it is much faster than computing all possible solutions and looking each one up in the dictionary.

The runtime of looking a word up in the dictionary obviously will depend on the number of repeated blocks in the word. (IE aboooooouuuuu will take much longer than abcdefgihjklmn because of the repeats). However, if on average there are 2 possible repeats then the runtime should be O(2^m) where m is the number of "blocks" in the word. For example aabbccdee has 5 blocks.
