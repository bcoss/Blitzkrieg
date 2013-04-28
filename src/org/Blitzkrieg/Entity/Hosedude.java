package org.Blitzkrieg.Entity;

import java.util.List;

import org.Blitzkrieg.State.GameState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Hosedude extends Tower{

	private Animation spray;
	private Boolean attacking;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game, int mouseX, int mouseY)
			throws SlickException {
		image = new Image("res/images/entities/Hosedude/hosedudeImage.png");
		spray = new Animation(new SpriteSheet("res/images/entities/Hosedude/hosedude.png", 24, 24), 300);
		spray.setLooping(false);
		shape = new Rectangle(mouseX-12,mouseY-12,24,24);
		attacking = false;
		HPDamage = 10;
		ArmourDamage = 0;
		range = 100;
		price = 200;
		super.init(gc, game);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int g)
			throws SlickException {
		TargetCheck(((GameState)game.getCurrentState()).getCars());
		if(spray.isStopped()){
			attacking = false;
			spray.restart();
		}
		super.update(gc, game, g);
	}
	private void TargetCheck(List<Vehicle> cars) {
		if(!attacking){
			Shape Target = new Circle(shape.getCenterX(), shape.getCenterY(), range);
			for(Vehicle v : cars){
				if(Target.intersects(v.shape)){
					attacking = true;
					AttackTarget(v, cars);
					break;
				}
			}
		}
	}
	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		if(!placed){
			g.setColor(Color.blue);
			g.fill(shape);
		}
		if(!attacking){
			g.drawImage(image, shape.getX(), shape.getY());
		}
		else{
			g.drawAnimation(spray, shape.getX(), shape.getY());
		}
	}

	protected void AttackTarget(Vehicle target, List<Vehicle> cars) {
		Shape aoe = new Circle(target.shape.getCenterX(), target.shape.getCenterY(), 21);
		for(Vehicle v : cars){
			if(aoe.intersects(v.shape)){
				DamageCar(v);
			}
		}
	}
	protected void DamageCar(Vehicle v){
		v.HPDamage(HPDamage);
		v.ArmorDamage(ArmourDamage);
	}
	
}
