# tradeshift_challenge

Solution contains following interfaces and classes
## Interfaces
* **Dictionary** - Dictionary of words
* **Matrix** - Puzzle data holder
* **WordsFinder** - Its implementation will define ways to find all words in puzzle

## Implementations
### WordsFinder
* **WordsFinderBasic** - This implementation searches for words in following directions
    - horizontally right
    - vertically down
    - diagonally down
    > For Example following char matrix
    ```
    c a t 
    a t o 
    n e m
    ``` 
    > has words cat, can, tom, ate

* **WordsFinderNodeArray** :+1: - This implementation helps find words in _**Criss Cross**_ way in **any direction** (up, down, right, left, diagonal, combination of all ) This implementation is favored over Basic implementation.
    > Example char matrix
    ```
    a b c 
    x a u
    z s t
    ```
    > has words - abacus, cat, tab, cut, tax, cast ...

### Dictionary
* **DictionaryImpl** - This is Trie implementation of Dictionary interface. We will store all words a lower case letters in this Dictionary
* **DictionaryNode** - Represents a Dictionary Node in Trie implementation

### Matrix
* **MatrixImpl** - Simple 2D character array type implementation of Matrix Interface. This is used in WordsFinderBasic
* **MatrixNodeArray** - Matrix implementation to be used in WordsFinderNodeArray

# Junit Test classes
* **TestBase** - Base class for Junit tests. Here we first add words to dictionary so that they can be verified in the puzzle. If we don't add word to dictionary, it will not be printed out though the puzzle has the word. Also creates Default puzzles test cases.
* **TestMain** - Test class for WordsFinderBasic
* **WordsFinderCrissCross_Test** - Test class for WordsFinderCrissCross implementation

# Building and Running
* This project can be imported in eclipse as Gradle Project.
* After bulding with gradle there is a task for running app (_gradlew run_)
* It will show a GUI where we can enter matrix as list of strings and after clicking **Find words** we will get all the words in given matrix.

## Problem Statement
tradeshift offline challenge
/**
 *  Words Finder
 * 
 *  Given an input of a list of strings representing a matrix of characters find all the valid words in that matrix.
 *  A valid words is a vertical or horizontal sequence of characters that are present in a dictionary  
 *  
 *  The dictionary is defined by the following interface:
 *  public interface Dictionary {
 * 	   boolean isValidWord(String word);
 *  }
 *  
 *  
 *  Sample Input
 *  private static final String[] DEFAULT_PUZZLE = new String[] {
 *   	"akjbvaijdsbv_d_dbv",
 *   	"fjslkdfadsna_T_lfa",
 *      "asdfasdfsdfa_r_ads",
 *      "ckvsadfgfgjava_ajd",
 *      "akjbvaijdsbv_d_dbv",
 *      "cbvqiejdbfqi_e_qib",
 *      "asdjnaquekjdwdfabd",
 *      "asdk_word_kgrtuabd",
 *      "asdjnaquekjfghbdbd",
 *      "asewdfldfjdsfewrkf",
 *      "as_Shift_ejdccgabd",
 *   };
 *  
 *  Expectations:
 *   * Can parse a list of strings into a proper data structure: matrix? tree?
 *   * Realizes this is a DFS problem
 *   * Implements a DFS algorithm
 *   * Does not output repeated words
 *   * Has/Proposes a way to test it
 *   * Clear division of work between methods/classes/etc
 *   * 
 *   
 *  Bonus points:
 *   * Actually creates a dictionary implementation
 *   * Actually creates a dictionary implementation backed by a data store
 *   * Changes algorithm to search words diagonally 
 *   
 */
