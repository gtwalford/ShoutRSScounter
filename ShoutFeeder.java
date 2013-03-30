package shoutfeeder;
import processing.core.PApplet;
import processing.core.PImage;


//import shoutfeeder.CirclingDot;


public class ShoutFeeder extends PApplet {
	
	String inputBBC = "http://feeds.bbci.co.uk/news/rss.xml";
	String inputAL = "http://www.aljazeera.com/Services/Rss/?PostingId=2007731105943979989";
	String inputFOX = "http://www.foxnews.com/about/rss/feedburner/foxnews/world";

	FeederInput theFeedBBC;
	FeederInput theFeedAL;
	FeederInput theFeedFOX;
	
	CirclingDot alDot;
	CirclingDot bbcDot;
	CirclingDot foxDot;
	
	LEDconnect ledStrips;
	
	float total;
	float oldTotal;
	float bbcPercent;
	float alPercent;
	float foxPercent;
    float test = 0;
    
    
    int r1;
    int g1;
    int b1;
    int r2;
    int g2;
    int b2;
    
 // Output
    int redPin   = 9;   
    int greenPin = 10; 
    int bluePin  = 11;

    int redPin2 = 3;
    int greenPin2 = 5;
    int bluePin2 = 6; 
    
    PImage img;
    

    
	public void setup() {
		size(displayHeight,displayWidth);
		background(0);
		
		theFeedBBC = new FeederInput(this, inputBBC);
		theFeedAL = new FeederInput(this, inputAL);
		theFeedFOX = new FeederInput(this, inputFOX);
	   
		bbcDot = new CirclingDot(this, width/2-100);
		alDot = new CirclingDot(this, width/2-125);
	    foxDot = new CirclingDot(this, width/2-150);
	    
	    img = loadImage("sounds.png");    

	    ledStrips = new LEDconnect(this);

	
	}//END SETUP

	public void draw() {
		
		fill(0,10);
		rect(0,0,width,height);
		imageMode(CENTER);
		image(img, width/2, height/2, width/2, height/2+75);

		  
		theFeedBBC.counting();
		theFeedAL.counting();
		theFeedFOX.counting();
		
		total = theFeedBBC.inTime + theFeedAL.inTime + theFeedFOX.inTime;
		if(theFeedBBC.inTime/total > 0)	bbcPercent = (theFeedBBC.inTime/total); else bbcPercent = 0;
		if(theFeedAL.inTime/total > 0) alPercent = (theFeedAL.inTime/total); else alPercent = 0;
		if(theFeedFOX.inTime/total > 0) foxPercent = (theFeedFOX.inTime/total); else foxPercent = 0;
		
        fill(0,130,250);
		text("BBC Total Count " + theFeedBBC.total, 10, 50);
		text(" ++ The inTime count " + theFeedBBC.inTime, 10, 75);
		text(" ++ The outTime count " + theFeedBBC.outTime, 10, 95);
        text("Percent of the Time " + (theFeedBBC.inTime/total)*100 + "%", 10, 115);
		
        fill(255,230,0);
		text("Aljazeera Total Count " + theFeedAL.total, 10, 150);
		text(" ++ The inTime count " + theFeedAL.inTime, 10, 175);
		text(" ++ The outTime count " + theFeedAL.outTime, 10, 195);
        text("Percent of the Time " + (theFeedAL.inTime/total)*100 + "%", 10, 215);
		
        fill(250,30,0);
		text("FOX Total Count " + theFeedFOX.total, 10, 250);
		text(" ++ The inTime count " + theFeedFOX.inTime, 10, 275);
		text(" ++ The outTime count " + theFeedFOX.outTime, 10, 295);
        text("Percent of the Time " + (theFeedFOX.inTime/total)*100 + "%", 10, 315);
		
		fill(255);
		text("OVERALL TOTAL -- " + total,10,400);

		
        bbcDot.draw(bbcPercent,0,130,250);
		alDot.draw(alPercent,255,230,0);
        foxDot.draw(foxPercent,250,30,0);
        
        ledStrips.light(bbcPercent,alPercent,foxPercent);

		
//        ledStrips.light(test, test, test);
        
	}//END DRAW
	
	public void keyReleased(){

		  if (key == '1'){ 
			 test++;
			 println(" // Test : " +test);
		  }
		  if (key == '2'){
			  test--;
			  println(" // Test : " +test);
		  }
	}
}
