package org.Blitzkrieg.State;

import org.Blitzkrieg.Entity.DirectionBlock;
import org.Blitzkrieg.Entity.GameMap;
import org.Blitzkrieg.Entity.Sedan;
import org.Blitzkrieg.Entity.Vehicle;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class LevelOne extends GameState {
	private GameMap map;
	public static final int ID = 1;
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		super.init(gc, game);
		cars.add(new Sedan(0, (33*8) + 2, "right"));
		map = new GameMap("res/maps/test.tmx");
		for(Vehicle v : cars){
			v.init(gc, game);
		}
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame game)
			throws SlickException {
		map.init(gc, game);
		super.enter(gc, game);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(gc, game, g);
		map.render(gc, game, g);
		for(Vehicle v : cars){
			v.render(gc, game, g);
		}
		for(DirectionBlock v : DirectionBlocks){
			v.render(gc, game, g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		super.update(gc, game, delta);
		for(Vehicle v : cars){
			v.update(gc, game, delta);
		}
	}

	@Override
	public int getID() {
		return ID;
	}
}