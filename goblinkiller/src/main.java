import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.Tab;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.api.ui.Skill;
import java.util.concurrent.TimeUnit; 




//Importing Java AWT
import java.awt.*;

//Script Details
@ScriptManifest(name = "Versace Goblin Killer", author = "VersaceGod", version = 0.1, info = "Kills Goblins", logo = "")
public class main extends Script {
	

    public int mouseX;
    public int mouseY;
    private long timeBegan;
    private long timeRan;
    //hitpoint exp
    private int hpbeginningXp;
    private int hpcurrentXp;
    private int hpxpGained;
    //attack exp
    private int attbeginningXp;
    private int attcurrentXp;
    private int attxpGained;
    //strength exp
    private int strbeginningXp;
    private int strcurrentXp;
    private int strxpGained;
    //defence exp
    private int defbeginningXp;
    private int defcurrentXp;
    private int defxpGained;
    //ranged exp
    private int rngbeginningXp;
    private int rngcurrentXp;
    private int rngxpGained;
    //magic exp
    private int magbeginningXp;
    private int magcurrentXp;
    private int magxpGained;
    //variable paint text
    private String currentaction;

    
    



	@Override
	public void onStart() {
		log("Verace Goblin Killer Started");
		//beggining time
		timeBegan = System.currentTimeMillis();
		//beginning exp
		hpbeginningXp = skills.getExperience(Skill.HITPOINTS);
		attbeginningXp = skills.getExperience(Skill.ATTACK);
		strbeginningXp = skills.getExperience(Skill.STRENGTH);
		defbeginningXp = skills.getExperience(Skill.DEFENCE);
		rngbeginningXp = skills.getExperience(Skill.RANGED);

		
	}
	
	@Override
	public void onExit() {
		log("Verace Goblin Killer Ended");
	}
	

	@Override
	public int onLoop() throws InterruptedException {
	//define door as closest object
        final RS2Object door = objects.closest("Door");
        //define goblin as closest goblin, true
		NPC goblin = npcs.closest(true, "Goblin") ;
 //Check if door is there
		if (door != null) {
			for(String actions: door.getDefinition().getActions()) {
               //check if door can be opened
				if(actions.contains("Open")) {
					//if door has action open then interact
					setCurrentaction("Opening Door");
                	door.interact("Open");
                	sleep(random(900, 2500));
                } else {
                	//if my player is not under attack and not moving
		if(!myPlayer().isUnderAttack() && !myPlayer().isMoving()) {
			//if goblin is available, not under attack, and health is greater than 0
			if(goblin != null && !goblin.isUnderAttack() && (goblin.getMaximumHealth() == 0 || goblin.getCurrentHealth() > 0)) {
				if(!goblin.isAnimating()) {
			if (goblin.isVisible()) {
				//attack goblin
				setCurrentaction("Wrecking Goblins");
				goblin.interact("Attack");
				sleep(random(100, 250));
				//after attack mouse movements
				AfterAttack();
				AntiBan();
				sleep(random(300, 700));
				
		                
					
			} else {
				//Move Camera to Goblin
				setCurrentaction("Moving Camera");
				camera.toEntity(goblin);
			}
		  }
		} else {
			sleep(random(500, 700));

		}
		
			return random(200, 300);
	}
	return 500;
	} } }
	return 200;
			}		
	public void AfterAttack() throws InterruptedException {
		//1 in 8 chance of 6 different antibans
		switch (random(1, 8)) {
		case 1:
			//random mouse movement
            this.mouse.moveRandomly();
			break;
		case 2:
			//very slight mouse movement
            this.mouse.moveVerySlightly();
                        break;                 
		case 3:
			//slight mouse movement
            this.mouse.moveSlightly();
			break;
		case 4:
			//move mouse outside screen
            this.mouse.moveOutsideScreen();
			break;
		case 5:
			//move camera to top, simulates up key
           camera.toTop();
			break;
		case 6:
			//move camera to top, simulates up key
           camera.toTop();
			break;
		
		}
		
		sleep(random(250, 320));

	}
	
	
public void AntiBan() throws InterruptedException {
		//1 in 60 chance of 6 cases. 1 in 10 chance of antiban start
		switch (random(1, 60)) {
		case 1:
			setCurrentaction("Opening Equipment Tab");
			equipment.openTab();
			sleep(random(1500, 3100));
			break;
		case 2:
			setCurrentaction("Opening Skills Tab");
			skills.open();
			sleep(random(3000, 4200));
                        break;                 
		case 3:
			setCurrentaction("Random Camera Movement Antiban");
			camera.movePitch(40 + (random(2, 80)));
			break;
		case 4:
			setCurrentaction("Random Camera Movement Antiban");
			camera.moveYaw(110 + (random(20, 50)));
			break;
		case 5:
			//open skills tan
			setCurrentaction("Checking Random Skill");
			 this.tabs.open(Tab.SKILLS);
	            sleep(random(1200, 2400));
	            switch (random(1, 5)) {
	            //random stat hovers (x,y)
	            case 1:
	            	//hitpoints hover
	    			setCurrentaction("Hovering Over Hitpoints Skill");
	              this.mouse.move(random(617, 666), random(207, 236));
	              sleep(random(2200, 4500));
	              break;
	            case 2:
	            	//attack hover
	    			setCurrentaction("Hovering Over Attack Skill");
	              this.mouse.move(random(550, 606), random(206, 235));
	              sleep(random(2200, 4500));
	              break;
	            case 3:
	            	//strength hover
	    			setCurrentaction("Hovering Over Strength Skill");
	              this.mouse.move(random(550, 606), random(238, 263));
	              sleep(random(2200, 4500));
	              break;
	            case 4:
	            	//ranged hover
	    			setCurrentaction("Hovering Over Ranged Skill");
	              this.mouse.move(random(549, 607), random(304, 324));
	              sleep(random(2200, 4500));
	              break;
	            case 5:
	            	//defence hover
	    			setCurrentaction("Hovering Over Defence Skill");
	              this.mouse.move(random(549, 607), random(273, 295));
	              sleep(random(2200, 4500));
	              break;
	                   
	       
	          }
			break;
		case 6:
			camera.moveYaw(30 + (random(20, 100)));
			//open skills
			setCurrentaction("Opening Skills Tab");
			skills.open();
			//random mouse movement
			AfterAttack();
			sleep(random(2200, 4500));
			break;
		
		}
		
		sleep(random(250, 750));
		//if inventory is not open at end of antiban, then open inventory
		if (!Tab.INVENTORY.isOpen(bot)) {
			setCurrentaction("Opening Inventory");
		tabs.open(Tab.INVENTORY);
		setCurrentaction("Wrecking Goblins");
		//random mouse movement or screen to top
		AfterAttack();
		}
	}



	@Override
	public void onPaint(Graphics2D g) {
		//time ran
		 timeRan = System.currentTimeMillis() - this.timeBegan;
		//Hitpoints Stuff
        hpcurrentXp = skills.getExperience(Skill.HITPOINTS);
        hpxpGained = hpcurrentXp - hpbeginningXp;
       //attack Stuff
        attcurrentXp = skills.getExperience(Skill.ATTACK);
        attxpGained = attcurrentXp - attbeginningXp;
        //strength Stuff
        strcurrentXp = skills.getExperience(Skill.STRENGTH);
        strxpGained = strcurrentXp - strbeginningXp;
        //defence Stuff
        defcurrentXp = skills.getExperience(Skill.DEFENCE);
        defxpGained = defcurrentXp - defbeginningXp;
        //range Stuff
        rngcurrentXp = skills.getExperience(Skill.RANGED);
        rngxpGained = rngcurrentXp - rngbeginningXp;
        //magic Stuff
        magcurrentXp = skills.getExperience(Skill.MAGIC);
        magxpGained = magcurrentXp - magbeginningXp; 
        
        
		//Loading paint
		g.setColor(Color.GREEN);
        g.drawString("Versace Goblin Killer", 8, 65);
        g.drawString("Time Ran: " + ft(timeRan), 8, 80);
        g.drawString("Hitpoint EXP Gained: " + hpxpGained, 8, 95);
        g.drawString("Attack EXP Gained: " + attxpGained, 8, 110);
        g.drawString("Strength EXP Gained: " + strxpGained, 8, 125);  
        g.drawString("Defence EXP Gained: " + defxpGained, 8, 140);  
        g.drawString("Ranged EXP Gained: " + rngxpGained, 8, 155);   
        g.drawString("Magic EXP Gained: " + magxpGained, 8, 170); 
        g.drawString("Status: " + currentaction, 8, 185); 
        
        
		g.setColor(Color.white);

		Point mousePoint = getMouse().getPosition();

		g.drawRect(mousePoint.x - 10, mousePoint.y - 10, 20, 20);

		g.drawLine(mousePoint.x, 0, mousePoint.x, 500);

		g.drawLine(0, mousePoint.y, 800, mousePoint.y);
		
	}

	private String ft(long duration) 
	{
		String res = "";
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		long hours = TimeUnit.MILLISECONDS.toHours(duration)
		- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
		- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
		.toHours(duration));
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
		- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
		.toMinutes(duration));
		if (days == 0) {
		res = (hours + ":" + minutes + ":" + seconds);
		} else {
		res = (days + ":" + hours + ":" + minutes + ":" + seconds);
		}
		return res;
	}

	public String getCurrentaction() {
		return currentaction;
	}

	public void setCurrentaction(String currentaction) {
		this.currentaction = currentaction;
	} 

}