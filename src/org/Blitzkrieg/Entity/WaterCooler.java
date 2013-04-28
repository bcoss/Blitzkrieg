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

public class WaterCooler extends Tower{

	private Animation cooling;
	private Boolean attacking;

	@Override
	public void init(GameContainer gc, StateBasedGame game, int mouseX, int mouseY)
			throws SlickException {
		cooling = new Animation(new SpriteSheet("res/images/entities/WaterCooler/waterCooler.png", 24, 24), 200);
		image = cooling.getImage(0);
		cooling.setLooping(false);
		shape = new Rectangle(mouseX-12,mouseY-12,24,24);
		attacking = false;
		HPDamage = 10;
		ArmourDamage = 0;
		range = 50;
		price = 50;
		super.init(gc, game);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int g)
			throws SlickException {
		TargetCheck(((GameState)game.getCurrentState()).getTowers());
		if(cooling.isStopped()){
			attacking = false;
			cooling.restart();
		}
		super.update(gc, game, g);
	}
	private void TargetCheck(List<Tower> tower) {
		if(!attacking){
			Shape Target = new Circle(shape.getCenterX(), shape.getCenterY(), range);
			for(Tower t : tower){
				if(Target.intersects(t.shape)){
					attacking = true;
					AttackTarget(t);
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
			g.drawAnimation(cooling, shape.getX(), shape.getY());
		}
	}

	protected void AttackTarget(Tower t) {	
		t.moral+=HPDamage;
		if(t.moral>100){
			t.moral=100;
		}
	}

	
}
