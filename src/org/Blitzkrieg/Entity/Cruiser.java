package org.Blitzkrieg.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Cruiser extends Vehicle{
	

	public Cruiser(Shape start, String facing) {
		super(start, facing);
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		LeftRightShape = new Rectangle(-100,-100,70,36);
		UpDownShape = new Rectangle((int)xLocation,(int)yLocation,36,70);
		hp = 130;
		armour= .2;
		speed = 1;
		amount = 10;
		maxHp = 130;
		RightVehicle = new Animation(new SpriteSheet("res/images/entities/Cruiser/Cruiser.png", 73, 34), 300);
		LeftVehicle = new Animation(new SpriteSheet("res/images/entities/Cruiser/CruiserLeft.png", 73, 34), 300);
		UpVehicle = new Animation(new SpriteSheet("res/images/entities/Cruiser/CruiserUp.png", 34, 73), 300);
		DownVehicle = new Animation(new SpriteSheet("res/images/entities/Cruiser/CruiserDown.png", 34, 73), 300);
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