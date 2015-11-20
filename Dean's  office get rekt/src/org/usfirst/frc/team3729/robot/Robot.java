package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
    
	
	Input input;
    robotDrive drive;
    servoControl camera;
    ultrasonicsensor ultrasound;
   
    public Robot() 
    {
        drive = new robotDrive();
        camera = new servoControl();
        //drive.setExpiration(0.1);
        input = new Input();
        
        
    }

  
    //@SuppressWarnings("deprecation")
	public void autonomous()   
	{
	        drive.tankDrive(10,.5);
	
    	
        
    }
    public void operatorControl() {
       drive.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) 
        {
        	drive.tankDrive();
        	camera.camTurn();
        	//ultrasound.wallHacks();
        	Timer.delay(0.005);// wait for a motor update time
        	
        }
    }
    public void test() {
    }
}
