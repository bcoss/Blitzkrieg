package org.Blitzkrieg.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class wwRoach extends Vehicle{
	
	public wwRoach(int xStart, int yStart, String facing){
		xLocation = xStart;
		yLocation = yStart;
		Direction = facing;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		LeftRightShape = new Rectangle((int)xLocation,(int)yLocation,70,36);
		UpDownShape = new Rectangle((int)xLocation,(int)yLocation,36,70);
		hp = 70;
		armour= .7;
		speed = 1.5;
		amount = 5;
		maxHp = 70;
		RightVehicle = new Animation(new SpriteSheet("res/images/entities/wwRoach/wwroach.png", 73, 36), 300);
		LeftVehicle = new Animation(new SpriteSheet("res/images/entities/wwRoach/wwroachLeft.png", 73, 36), 300);
		UpVehicle = new Animation(new SpriteSheet("res/images/entities/wwRoach/wwroachUp.png", 36, 73), 300);
		DownVehicle = new Animation(new SpriteSheet("res/images/entities/wwRoach/wwroachDown.png", 36, 73), 300);
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
