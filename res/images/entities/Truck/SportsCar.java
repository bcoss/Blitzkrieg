package org.Blitzkrieg.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class SportsCar extends Vehicle{
	
	public SportsCar(int xStart, int yStart, String facing){
		xLocation = xStart;
		yLocation = yStart;
		Direction = facing;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		LeftRightShape = new Rectangle((int)xLocation,(int)yLocation,123,36);
		UpDownShape = new Rectangle((int)xLocation,(int)yLocation,50,123);
		hp = 75;
		armour= .1;
		speed = 3;
		amount = 40;
		maxHp = 75;
		RightVehicle = new Animation(new SpriteSheet("res/images/entities/SportsCar/SportsCar.png", 123, 50), 300);
		LeftVehicle = new Animation(new SpriteSheet("res/images/entities/SportsCar/SportsCarLeft.png", 123, 50), 300);
		UpVehicle = new Animation(new SpriteSheet("res/images/entities/SportsCar/SportsCarUp.png", 50, 123), 300);
		DownVehicle = new Animation(new SpriteSheet("res/images/entities/SportsCar/SportsCarDown.png", 50, 123), 300);
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