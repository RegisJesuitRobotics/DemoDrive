
package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
    
	
	Input input;
    robotDrive drive;
    armRaise raise;
    pneumaticGripper grabber;   //servoControl camera;
    //ultrasonicsensor ultrasound;
   
    public Robot() 
    {
        drive = new robotDrive();
        //camera = new servoControl();
        //drive.setExpiration(0.1);
        input = new Input();
        raise=new armRaise();
        grabber = new pneumaticGripper();
        
        
        
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
        	if (drive.change(9, 10)==true)
        	{
        	drive.tankDrive();
        	raise.lift();
        	}
        	else 
        	{
        		drive.arcadeDrive();
        		raise.lift();
        	}
        	if (input.left.getRawButton(5)==true)
        	{
        		grabber.closeArms();
        	}
        	if (input.left.getRawButton(6)==true)
        	{
        		grabber.openArms();
        	}
        	
        	//camera.camTurn();
        	//ultrasound.wallHacks();
        	Timer.delay(0.005);// wait for a motor update time
        	
        }
    }
    public void test() {
    }
}
