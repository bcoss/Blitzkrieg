package org.Blitzkrieg.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Van extends Vehicle{
	

	public Van(Shape start, String facing) {
		super(start, facing);
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		LeftRightShape = new Rectangle(-100,-100,123,36);
		UpDownShape = new Rectangle((int)xLocation,(int)yLocation,50,123);
		hp = 300;
		armour= .5;
		speed = .6;
		amount = 15;
		maxHp = 300;
		RightVehicle = new Animation(new SpriteSheet("res/images/entities/Van/Van.png", 82, 34), 300);
		LeftVehicle = new Animation(new SpriteSheet("res/images/entities/Van/VanLeft.png", 82, 34), 300);
		UpVehicle = new Animation(new SpriteSheet("res/images/entities/Van/VanUp.png", 34, 82), 300);
		DownVehicle = new Animation(new SpriteSheet("res/images/entities/Van/VanDown.png", 34, 82), 300);
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