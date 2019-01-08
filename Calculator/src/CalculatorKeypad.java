/********************************************************************
 * Uses methods from JFrame and calls NumericKeypadPanel
 * in main method
 * 
 * @author Jamie Coulombe
 * @version 10/27/2018
 ********************************************************************/

import javax.swing.JFrame;

public class CalculatorKeypad
{
   //-----------------------------------------------------------------
   //  Creates and displays the application frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Numeric Keypad"); //creates new JFrame
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);//allows to close program completely

      frame.getContentPane().add (new CalculatorKeypadPanel());//adds NumericKeyPanel

      frame.pack();
      frame.setVisible(true);
   }
}
