package org.usfirst.frc.team3729.robot;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * This is a demo program showing the use of the RobotDrive class.
 * The SampleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
    
	
	Input input;
    robotDrive drive;
    servoControl camera;
   
    public Robot() 
    {
        drive = new robotDrive();
        camera = new servoControl();
        //drive.setExpiration(0.1);
        input = new Input();
        //parameters: (ports)a channel, b channel, reverse direction, encoding type
    }

  
    @SuppressWarnings("deprecation")
	public void autonomous()   
    {
        drive.tankDrive(1,.5);
    }
    public void operatorControl() {
       drive.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) 
        {
        	drive.tankDrive();
        	camera.camTurn();
        	Timer.delay(0.005);// wait for a motor update time
        	
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
