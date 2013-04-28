package org.Blitzkrieg.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Truck extends Vehicle{
	

	public Truck(Shape start, String facing) {
		super(start, facing);
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		LeftRightShape = new Rectangle(-100,-100,123,36);
		UpDownShape = new Rectangle((int)xLocation,(int)yLocation,50,123);
		hp = 800;
		armour= .1;
		speed = .5;
		amount = 40;
		maxHp = 800;
		RightVehicle = new Animation(new SpriteSheet("res/images/entities/Truck/Truck.png", 123, 50), 300);
		LeftVehicle = new Animation(new SpriteSheet("res/images/entities/Truck/TruckLeft.png", 123, 50), 300);
		UpVehicle = new Animation(new SpriteSheet("res/images/entities/Truck/TruckUp.png", 50, 123), 300);
		DownVehicle = new Animation(new SpriteSheet("res/images/entities/Truck/TruckDown.png", 50, 123), 300);
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