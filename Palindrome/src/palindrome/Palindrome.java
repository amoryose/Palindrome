//Avraham Moryosef
// 7/20/14
// CSC 156

package palindrome;
import java.awt.*;
import javax.swing.*;
//import java.util.*;
import java.awt.event.*;
//import java.lang.*;

public class Palindrome extends JFrame implements ActionListener
{
    private JLabel introStr;
    private JLabel introNum;
    private JTextField optionStr;
    private JTextField optionNum;
    private JTextArea displayStr;
    private JTextArea displayNum;
    private JButton palindrome , quit;
    
    
   public Palindrome()
   {
        introStr       = new JLabel ("Enter a word", SwingConstants.RIGHT);
        introNum       = new JLabel ("Enter a number", SwingConstants.RIGHT);
        optionStr      = new JTextField(20);
        optionNum      = new JTextField(20);
        displayStr     = new JTextArea(20, 10);
        displayNum     = new JTextArea(20, 10);
        palindrome     = new JButton ("Palindrome");
        quit           = new JButton ("Quit");
        setTitle("PALINDROME FINDER");
        
        Container c = getContentPane();
        setSize(650, 400);
        c.setLayout(null);
        
        palindrome.addActionListener(this);
        quit.addActionListener(this);
        
        introStr.setSize(200, 30);
        introNum.setSize(200, 30);
        optionStr.setSize(200, 30);
        optionNum.setSize(200, 30);
        displayStr.setSize(400, 50);
        displayNum.setSize(400, 50);
        palindrome.setSize(150, 100);
        quit.setSize(150, 100);
        
        introStr.setLocation(10, 10);
        introNum.setLocation(10, 50);
        optionStr.setLocation(220, 10);
        optionNum.setLocation(220, 50);
        displayStr.setLocation(90, 100);
        displayNum.setLocation(90, 175);
        palindrome.setLocation(90, 250);
        quit.setLocation(350, 250);
        
        c.add(introStr);
        c.add(introNum);
        c.add(optionStr);
        c.add(optionNum);
        c.add(displayStr);
        c.add(displayNum);
        c.add(palindrome);
        c.add(quit);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
    
   public static void main (String [] args)
   {
	   Palindrome my_Palindrome = new Palindrome();
   }
    
   public void actionPerformed(ActionEvent e)
   {
        String word;
        int number;
        
      if(e.getActionCommand().equals("Palindrome"))
        {              
         word = optionStr.getText().toLowerCase();
         displayStr.setText(isPalindrome(word) + "");
         
         number = Integer.parseInt(optionNum.getText());
         displayNum.setText(isPalindrome(number) + "");
        
        }
        
        if(e.getActionCommand().equals("Quit"))
        {
            System.exit(0);
        }
   }
    
   public static boolean isPalindrome(String word)
   {
       int len = word.length();   
       int x, y;
         
       y = len - 1;
    
       // for loop to get the palindrome string
       for (x = 0; x <= (len - 1)/2; x++)
       {
           if (word.charAt(x) != word.charAt(y))
                return false;
                y--;
       }
        return true;
   }
   
   public static boolean isPalindrome(int number)
   {
        int palindrome = number;
        int reverseNumber = 0;
        
        // while loop to get the palindrome number
        // number being reduce while reverse number being increased
        while (palindrome != 0)
        {
            int remainder = palindrome % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and reverse numbers are equal -> it is a palindrome
        if (number == reverseNumber)
        {
            return true;
        }
        return false;
    }
}

