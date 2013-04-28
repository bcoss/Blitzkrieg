package org.Blitzkrieg.Entity;

import java.util.List;

import org.Blitzkrieg.State.GameState;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Tower extends Entity{
	protected int moral;
	protected double HPDamage;
	protected double ArmourDamage;
	protected int range;
	protected Image image;
	protected boolean placed;
	protected double price;
	
	
	public void init(GameContainer gc, StateBasedGame game, int mouseX, int mouseY)
			throws SlickException {
		super.init(gc, game);
		placed = false;
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
	
	public void placed(){
		placed = true;
	}
	public double Amount(){
		return price;
	}
}
