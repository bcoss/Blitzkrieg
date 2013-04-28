package org.Blitzkrieg.State;

import org.newdawn.slick.Color;
import java.util.ArrayList;
import java.util.List;

import org.Blitzkrieg.Entity.DirectionBlock;
import org.Blitzkrieg.Entity.GameMap;
import org.Blitzkrieg.Entity.Hosedude;
import org.Blitzkrieg.Entity.Sedan;
import org.Blitzkrieg.Entity.Sprayer;
import org.Blitzkrieg.Entity.Tower;
import org.Blitzkrieg.Entity.Vehicle;
import org.Blitzkrieg.Entity.block;
import org.Blitzkrieg.Entity.wwRoach;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {
	protected List<Vehicle> cars;
	protected List<Vehicle> DeadCars;
	private List<block> blocks;
	protected List<DirectionBlock> DirectionBlocks;
	protected Vehicle[] penalty;
	protected int penaltyCount;
	protected List<Tower> towers;
	protected Double Money;
	protected Tower TowerToPlace;
	private GameContainer gc;
	private StateBasedGame game;
	protected double Score;
	protected boolean dead;
	private int mouseY;
	private int mouseX;
	protected GameMap map;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		penalty = new Vehicle[10];
		penaltyCount = 0;
		this.gc = gc;
		this.game = game;
		cars = new ArrayList<Vehicle>();
		blocks = new ArrayList<block>();
		DirectionBlocks = new ArrayList<DirectionBlock>();
		towers = new ArrayList<Tower>();
		DeadCars = new ArrayList<Vehicle>();
		Money = 300.0;
		TowerToPlace = null;
		Score = 0;
		dead = false;
	}

	
	
	@Override
	public void keyPressed(int key, char c) {
		if(TowerToPlace==null){
			if(key == Input.KEY_1){
				TowerToPlace = new Sprayer();
				try {
					TowerToPlace.init(gc, game, mouseX, mouseY);
					if((int)(Money-TowerToPlace.Amount())>=0){
						
						Money -= TowerToPlace.Amount();
					}
					else
						TowerToPlace = null;

				} catch (SlickException e) {
					e.printStackTrace();
				}
			}
			else if(key == Input.KEY_2){
				TowerToPlace = new Hosedude();
				try {
					TowerToPlace.init(gc, game, mouseX, mouseY);
					if((int)(Money-TowerToPlace.Amount())>=0){
						
						Money -= TowerToPlace.Amount();
					}
					else
						TowerToPlace = null;

				} catch (SlickException e) {
					e.printStackTrace();
				}
			}
		}
		if(key == Input.KEY_D){
			cars.add(new Sedan(0, (33*8) + 2, "right"));
			try {
				cars.get(cars.size()-1).init(gc, game);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		if(key == Input.KEY_F){
			cars.add(new wwRoach(0, (33*8)+2, "right"));
			try {
				cars.get(cars.size()-1).init(gc, game);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		super.keyPressed(key, c);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		map.render(gc, game, g);
		for(Vehicle v : cars){
			v.render(gc, game, g);
		}
		for(Vehicle v : DeadCars){
			v.render(gc, game, g);
		}
		for(DirectionBlock v : DirectionBlocks){
			v.render(gc, game, g);
		}
		for(Tower t : towers){
			t.render(gc, game, g);
		}
		if(TowerToPlace!= null){
			TowerToPlace.render(gc, game, g);
		}
		for(int i=0; i<penaltyCount; i++){
			g.drawAnimation(penalty[i].deadAnimation(), i*75 + 48, 400);
		}
		g.setColor(Color.white);
		g.drawString("Money: " + Money + " K", 0, 0);
		g.drawString("Score: " + Score, 0,580);
	}
	

	@Override
	public void mousePressed(int button, int x, int y) {
		if(TowerToPlace!= null){
			boolean AbleToPlace = true;
			for(block b : blocks){
				if(b.getShape().intersects(TowerToPlace.getShape())){
					AbleToPlace = false;
					break;
				}
			}
			for(Tower t : towers){
				if(t.getShape().intersects(TowerToPlace.getShape())){
					AbleToPlace = false;
					break;
				}
			}
			if(AbleToPlace){
				towers.add(TowerToPlace);
				TowerToPlace.placed();
				TowerToPlace = null;
			}
		}
		super.mousePressed(button, x, y);
	}



	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		mouseY = newy;
		mouseX = newx;
		if(TowerToPlace!= null){
			TowerToPlace.getShape().setLocation(newx-(TowerToPlace.getShape().getWidth()/2), newy-(TowerToPlace.getShape().getHeight()/2));
		}
			super.mouseMoved(oldx, oldy, newx, newy);
	}



	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		if(!dead){
			for(int i=0; i< DeadCars.size(); i++){
				cars.remove(DeadCars.get(i));
				DeadCars.get(i).update(gc, game, delta);
				if(DeadCars.get(i).getShape().getX()>map.getWidth() || DeadCars.get(i).getShape().getX()<-100
						|| DeadCars.get(i).getShape().getY()>map.getHeight() || DeadCars.get(i).getShape().getY()<-100){
					if(DeadCars.get(i).reward()){
						Money+=DeadCars.get(i).getAmount();
						Score+=DeadCars.get(i).getAmount();
						DeadCars.remove(i);
						i--;
					}
					else{

						penalty[penaltyCount] = DeadCars.get(i);
						penaltyCount++;
						DeadCars.remove(i);
					}
				}
			}
			checkDead();
		}
		for(int i=0; i< cars.size(); i++){
			cars.get(i).update(gc, game, delta);
			if(cars.get(i).getShape().getX()>map.getWidth() || cars.get(i).getShape().getX()<-100
					|| cars.get(i).getShape().getY()>map.getHeight() || cars.get(i).getShape().getY()<-100){
					DeadCars.add(cars.get(i));
					cars.remove(i);
					i--;
			}
			
		}
		for(Tower t : towers){
			t.update(gc, game, delta);
		}
	}

	private void checkDead() {
		if(penaltyCount==10){
			dead=true;
		}
		
	}



	public void removeCar(Vehicle v){
		DeadCars.add(v);
	}
	@Override
	public int getID() {
		return 0;
	}

	public List<block> getBlocks() {
		return blocks;
	}

	public List<Vehicle> getCars() {
		return cars;
	}
	public List<DirectionBlock> getDirectionBlocks() {
		return DirectionBlocks;
	}
}