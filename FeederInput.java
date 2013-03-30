package shoutfeeder;

import java.util.ArrayList;
import java.util.Date;
import com.sun.syndication.feed.synd.SyndEntry;
import com.wyldco.romefeeder.Feeder;

import processing.core.PApplet;
	

public class FeederInput {
	

	PApplet parent; 
	Feeder feeder;         // the feeder
	SyndEntry entry;       // a feed entry

	Date curDate;
	long timeStamp; 
	long timeFrame = (6*60)*60*1000;
	int inTime = 0;
	int outTime = 0;
	int totalTime = 0;

	int total = 0;
	long X;
	ArrayList<Long> countR = new ArrayList<Long>();

	
	FeederInput(PApplet p, String input){
	  parent = p;

	  //create the feeder
	  feeder = new Feeder(parent);
	  
	  //turn on output to the console (useful for debugging)
	  feeder.verbose = true;

	  feeder.sortByPublishedDate();

	  feeder.setUpdateInterval(5*60*1000); // milliseconds
	  
	  //start updating
	  feeder.startUpdate();
	    
	  //load the feed  
	  feeder.load(input);
	  
	  

		
	}//END FEEDerINPUT
	
	
	void counting(){
		 curDate = new Date();
		 timeStamp = curDate.getTime();
		
		//display the next entries
		  while (feeder.hasNext()) {
		    //get the next entry
		    entry = feeder.next();
//		    PApplet.println("\n" + entry.getTitle());
//		    PApplet.println(" + " + entry.getPublishedDate());
//			PApplet.println("  ++  " + total);		    

			total++;	
			if(timeStamp-entry.getPublishedDate().getTime()<=timeFrame){
				countR.add(entry.getPublishedDate().getTime());
				inTime++;
			}
			
			
			
		    
		  }//END WHILE	
		  

		  if(countR.size()>0){
			  for(int n = 0; n< countR.size(); n++){
//					PApplet.println(" // // " + countR.get(n));
//					PApplet.println(n+"-- "+(timeStamp-countR.get(n))+" <<<>>> "+timeFrame);
					if(timeStamp-countR.get(n) > timeFrame){
						PApplet.println("//////  OUT OF TIMEFRAME REMOVE ONE \\");		    
						
						inTime--;
						outTime++;
						countR.remove(n);
						
					}
						
			  }//END FOR
		  }
	
	}//END COUNTING
	public float total(){
		if(total>0){
			return total;
		}else{
			return 0;
		}
	}
	public float inTime(){
		if(inTime>0){
			return inTime;
		}else{
			return 0;
		}	}
	public float outTime(){
		if(outTime>0){
			return outTime;
		}else{
			return 0;
		}	}
	

}
