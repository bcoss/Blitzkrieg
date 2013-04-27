package org.Blitzkrieg.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Vehicle extends Entity{
	protected int hp;
	protected double armour;
	protected int speed;
	protected double xSpeed;
	protected double ySpeed;
	protected double xLocation;
	protected double yLocation;
	protected Animation RightVehicle;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
	}
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(gc, game, g);
		g.drawAnimation(RightVehicle, shape.getX(), shape.getY());
	}
	@Override
	public void update(GameContainer gc, StateBasedGame game, int g)
			throws SlickException {
		super.update(gc, game, g);
		move();
	}
	
	
	protected void move(){
		if(directionChange()){
			double temp = xSpeed;
			xSpeed = temp;
			ySpeed = xSpeed;
		}
		xLocation += xSpeed;
		yLocation += ySpeed;
		getShape().setLocation((int)xLocation, (int)yLocation);
	}
	private boolean directionChange() {
		return false;
	}
}
