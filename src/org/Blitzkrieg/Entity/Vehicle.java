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
	protected double maxHp;
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
	protected double amount;
	protected StateBasedGame game;
	
	public Vehicle(Shape start, String facing){
		xLocation = start.getCenterX();
		yLocation = start.getCenterY();
		Direction = facing;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		this.game = game;
		if(Direction.equals("right")){
			Current = RightVehicle;
			shape = LeftRightShape;
			xLocation-=shape.getWidth();
			yLocation-=(double)shape.getHeight()/2;
		}
		else if(Direction.equals("left")){
			Current = LeftVehicle;
			shape = LeftRightShape;
			xLocation+=shape.getWidth();
			yLocation-=(double)shape.getHeight()/2;
		}
		else if(Direction.equals("up")){
			Current = UpVehicle;
			shape = UpDownShape;
			xLocation-=(double)shape.getWidth()/2;
			yLocation+=(double)shape.getHeight();
		}
		else if(Direction.equals("down")){
			Current = DownVehicle;
			shape = UpDownShape;
			xLocation-=(double)shape.getWidth()/2;
			yLocation-=(double)shape.getHeight();
		}
		super.init(gc, game);
	}
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(gc, game, g);
		g.drawAnimation(Current, shape.getX(), shape.getY());
		//g.setColor(Color.red);
		//g.draw( new Rectangle((float) (shape.getCenterX()-speed), (float) (shape.getCenterY()-speed)+1, (int)(2*speed), (int)(2*speed)));
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
		Shape test = new Rectangle((float) (shape.getCenterX()-speed)-1, (float) (shape.getCenterY()-speed)-1, (int)(2*speed)+2, (int)(2*speed)+2);
		Shape testShape;
		for(DirectionBlock b : blocks){
			testShape = new Rectangle(b.shape.getCenterX(), b.shape.getCenterY(), 0, 0);
			if(test.intersects(testShape)){
				if(!Direction.equals(b.getDirection())){
					Direction = b.getDirection();
					UpdateAnimation(b.shape.getCenterX(), b.shape.getCenterY());
				}
			}
		}
	}
	public void HPDamage(double amount){
		hp-=(amount * (1-armour));
		if(hp<=0){
			hp = 0;
			RemoveCar();
		}
		//System.out.println(hp);
	}
	private void RemoveCar() {
		((GameState)game.getCurrentState()).removeCar(this);
		speed = 20;
	}
	public void ArmorDamage(double amount){
		if(!(armour <= 0)){
			armour-= amount;
			if(armour <=0){
				armour = 0;
			}
		}
	}
	private void UpdateAnimation(float xCenter, float yCenter) {
		if(Direction.equals("left")){
			Current = LeftVehicle;
			shape = LeftRightShape;
		}
		else if(Direction.equals("right")){
			Current = RightVehicle;
			shape = LeftRightShape;			
		}
		else if(Direction.equals("up")){
			Current = UpVehicle;
			shape = UpDownShape;
		}
		else{
			Current = DownVehicle;
			shape = UpDownShape;
		}
		yLocation= yCenter - shape.getHeight()/2;
		xLocation= xCenter - shape.getWidth()/2;
	}
	public boolean reward() {
		if((maxHp * .5)> hp){
			return true;
		}
		return false;
	}
	public Double getAmount() {
		return amount - (amount*(hp/maxHp));
	}
	public double getHP(){
		return hp;
	}
	public Animation deadAnimation(){
		return DownVehicle;
	}
}
