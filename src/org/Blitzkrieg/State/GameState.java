package org.Blitzkrieg.State;

import org.newdawn.slick.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.Blitzkrieg.Entity.Cruiser;
import org.Blitzkrieg.Entity.DirectionBlock;
import org.Blitzkrieg.Entity.GameMap;
import org.Blitzkrieg.Entity.Hosedude;
import org.Blitzkrieg.Entity.Sedan;
import org.Blitzkrieg.Entity.Sprayer;
import org.Blitzkrieg.Entity.Tower;
import org.Blitzkrieg.Entity.Truck;
import org.Blitzkrieg.Entity.Van;
import org.Blitzkrieg.Entity.Vehicle;
import org.Blitzkrieg.Entity.WaterCooler;
import org.Blitzkrieg.Entity.block;
import org.Blitzkrieg.Entity.wwRoach;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {
	protected List<Vehicle> cars;
	protected List<Vehicle> waveCars;
	protected List<Vehicle> DeadCars;
	private List<block> blocks;
	protected List<DirectionBlock> DirectionBlocks;
	protected Vehicle[] penalty;
	protected Animation[] towerDisplay;
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
	protected Shape start;
	protected int wave;
	protected int numCars;
	protected int time;
	protected int frequency;
	protected boolean startWave;
	protected boolean waveFinished;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		penalty = new Vehicle[10];
		penaltyCount = 0;
		this.gc = gc;
		this.game = game;
		waveCars = new ArrayList<Vehicle>();
		time = 0;
		wave = 1;
		frequency = 2000;
		numCars = 0;
		cars = new ArrayList<Vehicle>();
		blocks = new ArrayList<block>();
		DirectionBlocks = new ArrayList<DirectionBlock>();
		towers = new ArrayList<Tower>();
		DeadCars = new ArrayList<Vehicle>();
		Money = 300.0;
		TowerToPlace = null;
		Score = 0;
		dead = false;
		start = new Rectangle(0,0,0,0);
		waveFinished = true;
		towerDisplay[0] = new Animation(new SpriteSheet("res/images/entities/Sprayer/SprayerAttack.png", 24, 24), 200);
		towerDisplay[1] = new Animation(new SpriteSheet("res/images/entities/Hosedude/hosedude.png", 24, 24), 300);
		towerDisplay[2] = new Animation(new SpriteSheet("res/images/entities/WaterCooler/waterCooler.png", 24, 24), 200);
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
			else if(key == Input.KEY_3){
				TowerToPlace = new WaterCooler();
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
		if(key == Input.KEY_ENTER){
			if(waveFinished)
				startWave = true;
		}
		if(key == Input.KEY_D){
			Money+=1000;
		}
		if(key == Input.KEY_F){
			cars.add(new Truck(start, "right"));
			try {
				cars.get(cars.size()-1).init(gc, game);
			} catch (SlickException e) {
				// TODO Auto-generated catch block
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
			g.drawAnimation(penalty[i].deadAnimation(), i*75 + 48, 460);
		}
		g.setColor(Color.white);
		g.drawString("Money: " + Money + " K", 0, 0);
		g.drawString("Score: " + Score, 0,580);
		g.drawString("Wave:" + wave, 700, 0);
		for(int i =0; i<towerDisplay.length; i++){
			g.drawAnimation(towerDisplay[i], 40 + 1, 1);
		}
		if(waveFinished){
			g.drawString("Press Enter To Start Wave", 250, 250);
		}
		else{
			g.drawString("Cars Left to spawn:" + numCars, 250, 0);
		}
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
				if(DeadCars.get(i).getShape().getX()>map.getWidth() || DeadCars.get(i).getShape().getX()<-200
						|| DeadCars.get(i).getShape().getY()>map.getHeight() || DeadCars.get(i).getShape().getY()<-200){
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
			if(cars.get(i).getShape().getX()>map.getWidth() || cars.get(i).getShape().getX()<-200
					|| cars.get(i).getShape().getY()>map.getHeight() || cars.get(i).getShape().getY()<-200){
					DeadCars.add(cars.get(i));
					cars.remove(i);
					i--;
			}
			
		}
		for(Tower t : towers){
			t.update(gc, game, delta);
		}
		Wave();
		if(numCars >0){
			if(time ==0){
				cars.add(waveCars.get(numCars-1));
				numCars--;
			}
			
			time+=delta;
			if(time >frequency){
				time = 0;
			}
		}
		if(!waveFinished && cars.isEmpty() && numCars ==0){
			//System.out.println("DONE");
			waveFinished = true;
			Money+= wave*10 +100;
			wave ++;
			time = 0;
			if(frequency >=100){
				frequency -=50;
			}
			waveCars.clear();
		}
	}

	private void Wave() throws SlickException {
		if(startWave){
			waveFinished = false;
			startWave = false;
			numCars = 5 + wave;
			for(int i=0; i<numCars; i++){
				if (wave-i>=10){
					waveCars.add(new Truck(start, "right"));
				}
				else if(wave-i>=7){
					waveCars.add(new Van(start, "right"));
				}
				else if(wave-i>=5){
					waveCars.add(new Cruiser(start, "right"));
				}
				else if (wave-i>=3){
					waveCars.add(new wwRoach(start, "right"));
				}
				else{
					waveCars.add(new Sedan(start, "right"));
				}
			}
			for(Vehicle v : waveCars){
				v.init(gc, game);
			}
			Collections.shuffle(waveCars, new Random());
			
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
	public List<Tower> getTowers(){
		return towers;
	}

	public List<Vehicle> getCars() {
		return cars;
	}
	public List<DirectionBlock> getDirectionBlocks() {
		return DirectionBlocks;
	}



	public Shape getStart() {
		return start;
	}



	public void setStart(Shape start) {
		this.start = start;
	}
}