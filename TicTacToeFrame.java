package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;
import domain.model.PlayingPiece;

public class TicTacToeFrame extends JFrame
{
   // Panels
   private JPanel gamePanel;
   private JPanel generalPanel;
   private JPanel matchupPanel;

   // Labels
   private JLabel matchupLabel;
   
   //controller
   private Controller controller;

   // !!! MAYBE TEMPORARY !!!//
   private JButton testEndButton; // TEMPORARY TEST GAME END BUTTON !!!
   int roleNumber = -1; // Variable that manages if u can pick role 'X' or 'O'
   // !!! MAYBE TEMPORARY !!!//
   
   private int[] coordinates = new int[2];

   // Role Select Combo-Box
   private String[] choices = { "", "Playing as 'X'", "Playing as 'O'" };
   final JComboBox<String> playerSelectBox = new JComboBox<String>(choices);
   private JButton[][] buttons = new JButton[3][3];

   public TicTacToeFrame()
   {
      super("Tic-Tac-Toe");
      controller = new Controller(null, this);
      initializeComponents();
      initializeButtons();
      registerEventHandlers();
   }

   public void initializeComponents()
   {
      playerSelectBox.setSelectedIndex(0); // the combo box will start empty

      playerSelectBox.setBorder(BorderFactory.createTitledBorder(
            "<HTML><I>Please select your role here: </I></HTML>"));

      testEndButton = new JButton("TEMPORARY BUTTON TO END THE GAME"); // TEMPORARY
                                                                       // END
                                                                       // GAME
                                                                       // BUTTON
                                                                       // TO
                                                                       // TEST
                                                                       // THE
                                                                       // RESET
      testEndButton.setFont(new Font("Impact", Font.PLAIN, 15)); // TEMPORARY
                                                                 // END GAME
                                                                 // BUTTON
                                                                 // TO TEST THE
                                                                 // RESET

      matchupLabel = new JLabel(
            "<HTML><I><font size=3 color=red> Current Match:</font></I> "
                  + "<font size=4>" + "PLACEHOLDER1" + "</font>"
                  + " <font size=2 color=blue>vs</font> " + "<font size=4>"
                  + "PLACEHOLDER2" + "</font></HTML>");
   }

   public void initializeButtons()
   {
      // Panel with the player's names
      matchupPanel = new JPanel(new BorderLayout(0, 15));
      matchupPanel.add(matchupLabel, BorderLayout.NORTH);
      matchupPanel.add(playerSelectBox);

      // The Game Panel
      gamePanel = new JPanel(new GridLayout(3, 3));

      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            buttons[i][j] = new JButton();
            buttons[i][j].setText("");
            buttons[i][j].setFont(new Font("Tahoma", Font.PLAIN, 55));
            gamePanel.add(buttons[i][j]);
         }
      }

      // GENERAL FRAME PANEL
      generalPanel = new JPanel(new BorderLayout(0, 15));
      generalPanel.add(matchupPanel, BorderLayout.NORTH);
      generalPanel.add(gamePanel);
      generalPanel.add(testEndButton, BorderLayout.SOUTH);

      setContentPane(generalPanel);
   }

   private void registerEventHandlers()
   {
      ButtonHandler buttonHandler = new ButtonHandler();
      ListHandler listHandler = new ListHandler();
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            buttons[i][j].addActionListener(buttonHandler);
         }
      }
      testEndButton.addActionListener(buttonHandler);

      playerSelectBox.addActionListener(listHandler);
   }

   // Reseting buttons at the end of the game
   public void resetButtons()
   {
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            buttons[i][j].setText("");
            buttons[i][j].setEnabled(true);
         }
      }
      roleNumber = -1;
      playerSelectBox.setEnabled(true);
      playerSelectBox.setSelectedIndex(0);
   }

   private class ButtonHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JButton buttonClicked = (JButton) e.getSource(); // get the particular
                                                          // button that was
                                                          // clicked

         if (buttonClicked != testEndButton)
         {

        	 //DEFINITELY find a petter solution in the future
        	 
        	 for (int i = 0; i < 3; i++)
             {
                for (int j = 0; j < 3; j++)
                {
                   if(buttons[i][j] == buttonClicked)
                   {
                	   coordinates[0] = i;
                	   coordinates[1] = j;
                   }
                }
             }
        	 
        	 
        	 
            controller.Execute("click");
         }
         
         else if (buttonClicked == testEndButton)
         {
            JOptionPane.showMessageDialog(null,
                  "THE GAME ENDED AND NOW WILL RESET, TEST BUTTON WORKING !!!");
            resetButtons();
         }
      }
   }

   private class ListHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         Object selected = playerSelectBox.getSelectedItem();
         if (selected.toString().equals("Playing as 'X'"))
         {
            roleNumber = 1;
            playerSelectBox.setEnabled(false);
         }
         else if (selected.toString().equals("Playing as 'O'"))
         {
            roleNumber = 0;
            playerSelectBox.setEnabled(false);
         }
      }
   }

   public int[] get(String what)
   {
	   
	   return coordinates;
   }
   
   public void update(PlayingPiece piece) 
   {
		buttons[piece.getCoordinates()[0]][piece.getCoordinates()[1]].setText(piece.getType());
		buttons[piece.getCoordinates()[0]][piece.getCoordinates()[1]].setEnabled(false);
   }
   
   public static void main(String[] args)
   {
      TicTacToeFrame tictactoe = new TicTacToeFrame();
      
      tictactoe.setVisible(true);
      tictactoe.setResizable(false);
      tictactoe.setSize(350, 475);
      tictactoe.setLocationRelativeTo(null);
      tictactoe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }


}