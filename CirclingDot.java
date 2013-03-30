package shoutfeeder;
import processing.core.PApplet;

public class CirclingDot {
	
	int r;
	float angle;
//	float rad = parent.radians(angle);
	PApplet parent; // The parent PApplet that we will render ourselves onto

	
	CirclingDot(PApplet p,int x){
		parent = p;
		r = x; //radius
	
	}//END CIRCLINGDOT
	
	void draw(float count,int R,int G,int B){
	  //draw circling dot
	parent.pushMatrix();
	parent.translate(parent.width/2, parent.height/2);
	  angle += count;
	  if (angle>=360) angle -= 360;
	  float ca = PApplet.cos(PApplet.radians(angle));
	  float sa = PApplet.sin(PApplet.radians(angle));
	  parent.noStroke();
	  parent.fill(R,G,B);
//	  parent.translate(ca*r, sa*r, 0);
//	  parent.sphereDetail(4);
//	  parent.sphere(15);
	  parent.ellipse(ca*r, sa*r, 25, 25);
	parent.popMatrix();
	  
	}//END DRAW

}