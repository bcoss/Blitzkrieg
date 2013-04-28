package org.Blitzkrieg.Entity;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Tower extends Entity{
	protected int moral;
	protected double HPDamage;
	protected double ArmourDamage;
	protected int range;
	protected Image image;
	protected boolean placed;
	protected double price;
	protected boolean dead;
	
	public void init(GameContainer gc, StateBasedGame game, int mouseX, int mouseY)
			throws SlickException {
		super.init(gc, game);
		placed = false;
		dead = false;
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
	protected void DamageCar(Vehicle v){
		if(v.getHP()>0){
			v.HPDamage(HPDamage);
			v.ArmorDamage(ArmourDamage);
		}
	}
	
	public void placed(){
		placed = true;
	}
	public double Amount(){
		return price;
	}
}
