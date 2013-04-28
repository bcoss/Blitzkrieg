package org.Blitzkrieg;


import org.Blitzkrieg.State.LevelOne;
import org.Blitzkrieg.State.MenuState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A test for the multi-state based functionality
 *
 * @author kevin
 */
public class game extends StateBasedGame {


		/**
         * Create a new test
         */
        public game() {
                super("Blitzkrieg");
        }
        
        /**
         * @see org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick.GameContainer)
         */
        public void initStatesList(GameContainer container) {
                addState(new MenuState());
                addState(new LevelOne());
                //addState(new TestState2());
                //addState(new TestState3());
        }
        
        /**
         * Entry point to our test
         * 
         * @param argv The arguments to pass into the test
         */
        public static void main(String[] argv) {
                try {
                        AppGameContainer container = new AppGameContainer(new game());
                        container.setDisplayMode(800,600,false);
                        container.setTargetFrameRate(60);
                        container.setShowFPS(false);
                        container.start();
                } catch (SlickException e) {
                        e.printStackTrace();
                }
        }
}