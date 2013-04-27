package org.Blitzkrieg.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Sedan extends Vehicle{
	
	public Sedan(int xStart, int yStart){
		xLocation = xStart;
		yLocation = yStart;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		shape = new Rectangle(0,0,180,64);
		hp = 100;
		armour= .1;
		speed = 4;
		xSpeed = 0.5;
		RightVehicle = new Animation(new SpriteSheet("res/images/entities/Sedan/Sedan.png", 70, 36), 300);
	}
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(gc, game, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int g)
			throws SlickException {
		super.update(gc, game, g);
	}

}
