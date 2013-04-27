package org.Blitzkrieg.Entity;

import java.util.List;

import org.Blitzkrieg.State.GameState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Vehicle extends Entity{
	protected Shape UpDownShape;
	protected Shape LeftRightShape;
	protected double hp;
	protected double armour;
	protected double speed;
	protected double xLocation;
	protected double yLocation;
	protected Animation Current;
	protected Animation RightVehicle;
	protected Animation LeftVehicle;
	protected Animation UpVehicle;
	protected Animation DownVehicle;
	protected String Direction;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		if(Direction.equals("right")){
			Current = RightVehicle;
			shape = LeftRightShape;
		}
		else if(Direction.equals("left")){
			Current = LeftVehicle;
			shape = LeftRightShape;
		}
		else if(Direction.equals("up")){
			Current = UpVehicle;
			shape = UpDownShape;
		}
		else if(Direction.equals("down")){
			Current = DownVehicle;
			shape = UpDownShape;
		}
		super.init(gc, game);
	}
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(gc, game, g);
		g.drawAnimation(Current, shape.getX(), shape.getY());
		//g.setColor(Color.red);
		//g.draw(new Rectangle(shape.getCenterX(), shape.getCenterY(), 1, 1));
	}
	@Override
	public void update(GameContainer gc, StateBasedGame game, int g)
			throws SlickException {
		super.update(gc, game, g);
		move(game);
	}


	protected void move(StateBasedGame game){
		directionChange(((GameState)game.getCurrentState()).getDirectionBlocks());
		if(Direction.equals("left")){
			xLocation += -speed;
		}
		else if(Direction.equals("right")){
			xLocation += speed;
		}
		else if(Direction.equals("up")){
			yLocation += -speed;
		}
		else{
			yLocation += speed;
		}
		shape.setLocation((int)xLocation, (int)yLocation);
	}
	private void directionChange(List<DirectionBlock> blocks) {
		Shape test = new Rectangle(shape.getCenterX()-1, shape.getCenterY()-1, 2, 2);
		Shape testShape;
		for(DirectionBlock b : blocks){
			testShape = new Rectangle(b.shape.getCenterX(), b.shape.getCenterY(), 0, 0);
			if(test.intersects(testShape)){
				if(!Direction.equals(b.getDirection())){
					Direction = b.getDirection();
					UpdateAnimation();
				}
			}
		}
	}
	private void HPDamage(double amount){
		hp-=(amount * (1-armour));
		if(hp<=0){
			RemoveCar();
		}
	}
	private void RemoveCar() {
		
	}
	private void ArmorDamage(double amount){
		if(!(armour <= 0)){
			armour-= amount;
			if(armour <=0){
				armour = 0;
			}
		}
	}
	private void UpdateAnimation() {
		if(Direction.equals("left")){
			Current = LeftVehicle;
			yLocation+= (shape.getHeight()- (LeftRightShape.getHeight()*1.5) +1);
			shape = LeftRightShape;
		}
		else if(Direction.equals("right")){
			Current = RightVehicle;
			yLocation+= (shape.getHeight()- (LeftRightShape.getHeight()*1.5) +1);
			shape = LeftRightShape;			
		}
		else if(Direction.equals("up")){
			Current = UpVehicle;
			xLocation+= (shape.getWidth() -(UpDownShape.getWidth()*1.5)+1);
			shape = UpDownShape;
		}
		else{
			Current = DownVehicle;
			xLocation+= (shape.getWidth() -(UpDownShape.getWidth()*1.5)+1);
			shape = UpDownShape;
		}
	}
}
