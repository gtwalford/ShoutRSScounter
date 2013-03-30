package shoutfeeder;
import processing.core.PApplet;
import processing.serial.*;
import cc.arduino.*;

public class LEDconnect {
	
	   Serial port;
		PApplet parent; // The parent PApplet that we will render ourselves onto

	   
	     int r1;
	     int g1;
	     int b1;
	     int r2;
	     int g2;
	     int b2;
	     int r3;
	     int g3;
	     int b3;
	     float Oldr1, Oldg1,Oldb1,Oldr2,Oldg2,Oldb2,Oldr3,Oldg3,Oldb3;
	     
//	  // Output
//	     int redPin   = 9;   
//	     int greenPin = 10; 
//	     int bluePin  = 11;
//
//	     int redPin2 = 3;
//	     int greenPin2 = 5;
//	     int bluePin2 = 6; 
//	     
//	     int redPin3 = A0;
//	     int greenPin3 = A1;
//	     int bluePin3 = A2;

	     
	 
	LEDconnect(PApplet p){
		parent = p;
//	     
		PApplet.println(Serial.list()); 
		
	     port = new Serial(parent, Serial.list()[0], 9600);  
	     
	}//END 
	
	void light(float bbcFeed,float alFeed,float foxFeed){
		
			r1 = 100;//PApplet.map(bbcFeed, 0, 1, 255, 0);
			g1 = 100;//PApplet.map(bbcFeed, 0, 1, 100, 0);
			b1 = 0;//PApplet.map(bbcFeed, 0, 1, 0, 10);
			r2 = 255;//PApplet.map(alFeed, 0, 1, 255, 0);
			g2 = 0;//PApplet.map(alFeed, 0, 1, 255, 0);
			b2 = 255;//PApplet.map(alFeed, 0, 1, 255, 0);
			r3 = 255;//PApplet.map(foxFeed, 0, 1, 255, 0);
			g3 = 255;
			b3 = 0;//PApplet.map(foxFeed, 0, 1, 255, 0);
			
//			if(r1 != Oldr1 || g1!=Oldg1 || b1!=Oldb1 || 
//					r1 != Oldr2 || g1!=Oldg2 || b1!=Oldb2 || 
//					r1 != Oldr3 || g1!=Oldg3 || b1!=Oldb3 ){
		    
//			port.write("C");
//		    port.write(r1);
//		    port.write(g1);
//		    port.write(b1);
//		    port.write(r2);
//		    port.write(g2);
//		    port.write(b2);
//		    port.write(r3);
//		    port.write(g3);
//		    port.write(b3);
		    
		    PApplet.println(bbcFeed +" // " + b1);
		    
//		    Oldr1 = r1;
//		    Oldg1 = g1;
//		    Oldb1 = b1;
//		    Oldr2 = r2;
//		    Oldg2 = g2;
//		    Oldb2 = b2;		    
//		    Oldr3 = r3;
//		    Oldg3 = g3;
//		    Oldb3 = b3;		
//		    
//			}//END Check
//			PApplet.println(" // r1 = " + r1 +" // g1 = " + g1 + " // b1 = " + b1);

//			PApplet.println(" // BBC " +bbcFeed +" // AL " + alFeed +" // FOX "+foxFeed );
//			    byte out[] = new byte[3];
////			    
//			    out[0] = (byte) (0);
//			    out[1] = (byte) (g1);
//			    out[2] = (byte) (b1);
//			    out[3] = (byte) (r2);
//			    out[4] = (byte) (g2);
//			    out[5] = (byte) (b2);
//			    out[6] = (byte) (r3);
//			    out[7] = (byte) (g3);
//			    out[8] = (byte) (b3);
			    
//			    PApplet.println(" // "+ out);
			    
//			    port.write(out);

		
	}
	


}
