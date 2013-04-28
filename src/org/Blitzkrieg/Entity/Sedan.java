package org.Blitzkrieg.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Sedan extends Vehicle{
	
	public Sedan(int xStart, int yStart, String facing){
		xLocation = xStart;
		yLocation = yStart;
		Direction = facing;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		LeftRightShape = new Rectangle((int)xLocation,(int)yLocation,70,36);
		UpDownShape = new Rectangle((int)xLocation,(int)yLocation,36,70);
		hp = 100;
		armour= .1;
		speed = 4;
		amount = 25;
		maxHp = 100;
		RightVehicle = new Animation(new SpriteSheet("res/images/entities/Sedan/Sedan.png", 70, 36), 300);
		LeftVehicle = new Animation(new SpriteSheet("res/images/entities/Sedan/SedanLeft.png", 70, 36), 300);
		UpVehicle = new Animation(new SpriteSheet("res/images/entities/Sedan/SedanUp.png", 36, 70), 300);
		DownVehicle = new Animation(new SpriteSheet("res/images/entities/Sedan/SedanDown.png", 36, 70), 300);
		super.init(gc, game);
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
