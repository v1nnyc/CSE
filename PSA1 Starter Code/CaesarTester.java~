/*
 * Name:  Julius Caesar <--- Replace with your name
 * Login: cs8baXX <--- Use your cs8ba course-specific account name
 * Date:  January 8, 2016
 * File:  CaesarTester.java <-- Name of the file
 * Sources of Help: ... (for example: names of people/tutors/students, books, 
 *                       websites, etc.) 
 *
 * Tests Caesar.java using basic strings and rotation values. 
 *
 */


/*
 * Name:    CaesarTester
 * Purpose: To test Caesar.java for correct output.
 */
public class CaesarTester {

 /*
  * Name:       main
  * Purpose:    To call methods in Caesar and test them
  * Parameters: String[] args - command line arguments that are unused
  * Return:     void
  */
 public static void main(String[] args) {

  /** The main method. THIS IS WHERE YOU SHOULD ADD MORE TESTS
   * FOR encrypt and decrypt methods AND ANY OTHER METHOD
   * THAT YOU CREATE. BE SURE TO TEST YOUR CODE THOROUGHLY
   **/

  //The Caesar Cipher Tests
  int failCases = 0;

  //Test 1
  String message1 = "Cse8b: Programming in Java, Part 2";
  String encryptedAnswer = "Tjv8s: Gifxirddzex ze Armr, Grik 2";
  String encrypted1 = Caesar.encrypt(message1, 17);

  if (!encryptedAnswer.equals(encrypted1)) {
   System.out.println("Test 1 Failed(encryption)");
   System.out.println("Given message to encrypt is: " + message1);
   System.out.println("Your Answer is: " + encrypted1);
   System.out.println("The correct answer is: " + encryptedAnswer);
   failCases++;
  } else {
   System.out.println("Test 1 Passed!\n");
  }

  //Test 2
  String encrypted2 = "Byffi yhwlsjncih qilfx";
  String messageAnswer = "Hello encryption world";
  String message2 = Caesar.decrypt(encrypted2, -58);

  if (!messageAnswer.equals(message2)) {
   System.out.println("Test 2 Failed(decryption)");
   System.out.println("Given message to decrypt is: " + encrypted2);
   System.out.println("Your Answer is: " + message2);
   System.out.println("The correct answer is: " + messageAnswer);
   failCases++;
  } else {
   System.out.println("Test 2 Passed!\n");
  }

  //Messages that print whether tests were successful or not
  if (failCases == 0) {
   System.out.println("All Tests Passed!");
  } else {
   System.out.println("Number of Failed Test Cases : " + failCases);
  }

 }

}
