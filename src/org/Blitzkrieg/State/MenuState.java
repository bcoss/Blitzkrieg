package org.Blitzkrieg.State;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState {
  public static final int ID = 0;
 
  private boolean startGameButtonPressed;
  
  	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		startGameButtonPressed =false;
	}

  	
  	
  	
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ENTER){
			startGameButtonPressed = true;
		}
	}




	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		if(startGameButtonPressed) {
			// When the start button is pressed goto the in game state
			game.enterState(LevelOne.ID, new FadeOutTransition(), new FadeInTransition());
		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
}