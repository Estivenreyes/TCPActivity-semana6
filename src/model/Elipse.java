package model;

import processing.core.PApplet;

public class Elipse {
	
	private String name;
	private int posX,posY;
	private int r,g,b;
	int speed = 25;
	float ease = 0.5f;
	PApplet app;
	
	public Elipse (PApplet app, int posX, int posY) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.r=255;
		this.g=255;
		this.b=255;
	}
	
	public void move(int direction) {
		
		switch (direction) {
		case 1:
			this.posX+=speed;
			break;
			
		case -1:
			this.posX-=speed;
			break;	
			
		case 2:
			this.posY-=speed;
			break;
			
		case -2:
			this.posY+=speed;
			break;
		
		}
	
	}

	public void draw() {
		
		app.fill(this.r,this.g,this.b);
		app.ellipse(posX, posY, 60, 60);
		if(name!= null) {
		app.text(name, posX-20, posY-85);
		
		}
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
