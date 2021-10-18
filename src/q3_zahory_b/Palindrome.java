//---------------------------------------------------------------------
// Palindrome.java           by Dale/Joyce/Weems              Chapter 4
//
// Provides a method to test whether a string is a palindrome. 
// Non letters are skipped.
//---------------------------------------------------------------------
package q3_zahory_b;

public class Palindrome {
  public static boolean test(String candidate)
// Returns true if candidate is a palindrome, false otherwise.
  {
    char ch; // current candidate character being processed
    int length; // length of candidate string

// initialize variables and structures
    length = candidate.length();
    DLinkedList<Character> queue = new DLinkedList<Character>();

// obtain and handle characters
    for (int i = 0; i < length; i++) {
      ch = candidate.charAt(i);
      if (Character.isLetter(ch)) {
        ch = Character.toLowerCase(ch);
        queue.addEnd(ch);
      }
    }

// determine if palindrome
    return testPalindromeRecur(queue);
  }

  public static boolean testPalindromeRecur(DLinkedList<Character> q) {
    if(q==null || q.numElements==1)
      return true;
    if(q.front.getInfo().equals(q.rear.getInfo())){
      q.removeFront();
      q.rear = q.rear.getBack();
      q.numElements--;
      return testPalindromeRecur(q);
    }else{
      return false;
    }
  }

}