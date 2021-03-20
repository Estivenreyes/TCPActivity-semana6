package view;

import java.awt.Color;


import com.google.gson.Gson;

import communicaton.MessageListener;
import communicaton.TCP_Singleton;
import model.Direction;
import model.Elipse;
import model.Generic;
import model.Name;
import processing.core.PApplet;

public class Main extends PApplet implements MessageListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");	
	}
	private TCP_Singleton single;
	private Elipse ellipse;
	private Name name;
	
	public void settings() {
		
		size(600,600);
	}
	
	public void setup() {
		
		single= TCP_Singleton.getInstance();
		single.SetObserver(this);
		ellipse = new Elipse (this,width/2,height/2);
		
	}
	public void draw() {
		background(0);
		ellipse.draw();	
	}
	@Override
	public void Message(String msg) {
		// TODO Auto-generated method stub
		//System.out.println(msg);
		Gson gson = new Gson();

		Generic generic = gson.fromJson(msg, Generic.class);
		
		switch(generic.getType()) {
		
		case "Name":
			
			Name temp = gson.fromJson(msg, Name.class);
			ellipse.setName(temp.getName());
		break;
		
		case "Direction" :
			//System.out.println("direccion");
			Direction tempD = gson.fromJson(msg, Direction.class);
			ellipse.move(tempD.getDirection());
			break;
			
		case "Colors":
			Color tempC = gson.fromJson(msg, Color.class);
			ellipse.setR(tempC.getRed());
			ellipse.setG(tempC.getGreen());
			ellipse.setB(tempC.getBlue());
			break;
		}
	
			
		
			
		
	}
}