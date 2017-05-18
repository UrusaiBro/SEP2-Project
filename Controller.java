package controller;

import view.*;
import domain.mediator.Model;
import domain.mediator.ModelManager;

public class Controller 
{
	private GameMenuGUI view;
	private Model model;
	private TicTacToeFrame gameView;
	
	public Controller( GameMenuGUI view,  TicTacToeFrame gameView)
	{
		this.gameView = gameView;
		this.view = view;
		this.model = new ModelManager();
	}
	
	public void Execute(String what)
	{
		switch(what)
		{
			case "click":	
				gameView.update(model.interact(gameView.get("coordinates")));
				System.out.println(gameView.get("coordinates")[1]);
				break;
			case "choose game":
				model.createGame();
				view.startGame();
				
		}
	}
	
}
