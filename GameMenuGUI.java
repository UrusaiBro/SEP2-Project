package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.Controller;

public class GameMenuGUI extends JFrame
{
   // Labels
   private JLabel nicknameLabel;

   // Text Fields
   private JTextField nicknameField;

   // Buttons
   private JButton buttonGames;
   private JButton buttonHighScores;
   private JButton buttonBack;
   private JButton buttonTTT;
   private JButton buttonChess;
   private JButton buttonCheckers;
   private JButton buttonOtherGames;
   private JButton buttonExit;

   // Panels
   private JPanel mainPanel;
   private JPanel buttonPanel;
   private JPanel logoPanel;
   private JPanel nicknamePanel;
   private JPanel buttonPanel2;
   
   
   //controller
   private Controller controller;

   public GameMenuGUI()
   {
      super("Board Games Menu");
      super.getContentPane().setBackground(Color.CYAN);
      createComponents();
      addComponentsToFrame();
      registerEventHandlers();
      controller = new Controller(this, null); //idk wat I'm doing.
      
   }

   private void createComponents()
   {
      nicknameLabel = new JLabel(
            "<html><i><font color=blue>What's your name?: </font></i></html>");
      nicknameField = new JTextField(16);

      buttonTTT = new JButton("Play Tic-Tac-Toe");
      buttonBack = new JButton("<= Back");
      buttonChess = new JButton("Play Chess");
      buttonCheckers = new JButton("Play Checkers");
      buttonOtherGames = new JButton("Other Games");
      buttonHighScores = new JButton("View High Scores");
      buttonGames = new JButton("Choose a game to play");
      buttonExit = new JButton("Exit");
   }

   private void addComponentsToFrame()
   {
      // Title Logo Panel
      logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
      logoPanel.add(new JLabel(new ImageIcon("images\\aaa.png")));
      logoPanel.add(new JLabel(new ImageIcon("images\\logotext.png")));

      // Panel for the nickname
      nicknamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
      nicknamePanel.add(nicknameLabel);
      nicknamePanel.add(nicknameField);

      // Middle Button Part Panel
      buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 24));
      buttonPanel.add(buttonGames);
      buttonPanel.add(buttonHighScores);
      buttonPanel.add(buttonExit);

      // Second Button Part Panel
      buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 24));
      buttonPanel2.add(buttonBack);
      buttonPanel2.add(buttonTTT);
      buttonPanel2.add(buttonChess);
      buttonPanel2.add(buttonCheckers);
      buttonPanel2.add(buttonOtherGames);

      // disabling the not implemented ones
      buttonHighScores.setEnabled(false);
      buttonChess.setEnabled(false);
      buttonCheckers.setEnabled(false);
      buttonOtherGames.setEnabled(false);

      // The Main Panel
      mainPanel = new JPanel();
      LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
      mainPanel.setLayout(layout);

      mainPanel.add(logoPanel);
      mainPanel.add(nicknamePanel);
      mainPanel.add(buttonPanel);
      mainPanel.add(buttonPanel2);

      buttonPanel2.setVisible(false);
      setContentPane(mainPanel);
   }

   private void registerEventHandlers()
   {
      ButtonHandler buttonHandler = new ButtonHandler();

      buttonGames.addActionListener(buttonHandler);
      buttonHighScores.addActionListener(buttonHandler);
      buttonExit.addActionListener(buttonHandler);
      buttonTTT.addActionListener(buttonHandler);
      buttonChess.addActionListener(buttonHandler);
      buttonCheckers.addActionListener(buttonHandler);
      buttonBack.addActionListener(buttonHandler);
      buttonOtherGames.addActionListener(buttonHandler);
   }

   private class ButtonHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == buttonGames)
         {
            buttonPanel.setVisible(false);
            buttonPanel2.setVisible(true);
         }
         else if (e.getSource() == buttonBack)
         {
            buttonPanel2.setVisible(false);
            buttonPanel.setVisible(true);
         }
         else if (e.getSource() == buttonHighScores)
         {
            // soon
         }
         else if (e.getSource() == buttonExit)
         {
            System.exit(0);
         }
         else if (e.getSource() == buttonTTT)
         {
            controller.Execute("choose game"); 
         }
         else if (e.getSource() == buttonChess)
         {
            //soon
         }
         else if (e.getSource() == buttonCheckers)
         {
            // soon
         }
         else if (e.getSource() == buttonOtherGames)
         {
            // soon
         }
      }
   }

   public static void main(String[] args)
   {
      GameMenuGUI gameMenuGUI = new GameMenuGUI();
      gameMenuGUI.setVisible(true);
      gameMenuGUI.setResizable(true);
      gameMenuGUI.setSize(625, 275);
      gameMenuGUI.setLocationRelativeTo(null);
      gameMenuGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

public void startGame() 
{
	TicTacToeFrame.main(null);
}
}