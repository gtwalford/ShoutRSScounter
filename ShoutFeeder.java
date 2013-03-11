package shoutfeeder;

import processing.core.PApplet;
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
	
	float total;

	public void setup() {
		size(500,500);
		
		theFeedBBC = new FeederInput(this, inputBBC);
		theFeedAL = new FeederInput(this, inputAL);
		theFeedFOX = new FeederInput(this, inputFOX);
	   
		bbcDot = new CirclingDot(this, 100);
		alDot = new CirclingDot(this, 125);
	    foxDot = new CirclingDot(this, 150);
	
	}//END SETUP

	public void draw() {
		
		background(100);

		theFeedBBC.counting();
		theFeedAL.counting();
		theFeedFOX.counting();
		
		total = theFeedBBC.inTime + theFeedAL.inTime + theFeedFOX.inTime;
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

		
        bbcDot.draw((theFeedBBC.inTime/total),0,130,250);
		alDot.draw((theFeedAL.inTime/total),255,230,0);
        foxDot.draw((theFeedFOX.inTime/total),250,30,0);
 
	}//END DRAW
}
