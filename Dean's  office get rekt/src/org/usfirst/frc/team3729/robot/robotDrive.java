package org.usfirst.frc.team3729.robot;
import java.lang.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;



public class robotDrive {

	Talon mcLeft, mcRight;
	Input input;
	Encode encode;
	
	public robotDrive()
	{
		
		mcLeft= new Talon(0);
		mcRight= new Talon(1);
		input = new Input();
		encode = new Encode();
	}
	public void setSafetyEnabled(boolean b) 
	{
		// TODO Auto-generated method stub
		
	}
	public void tankDrive() 
	{
		boolean z1 = input.left.getRawButton(3);
		boolean z2 = input.right.getRawButton(3);
		while ((z1==true)||(z2==true))
		{
			z1 = input.left.getRawButton(3);
			z2 = input.right.getRawButton(3);
			mcLeft.set(.46*input.left.getRawAxis(1));
			mcRight.set(.5*-input.right.getRawAxis(1));
		}
		mcLeft.set(.92*input.left.getRawAxis(1));
		mcRight.set(-input.right.getRawAxis(1));
	}
	public void turn(double x)
	{
		x= sin(x);
		mcLeft.set(.5);
		mcRight.set(.5);
		Timer.delay(x);//constant
		mcLeft.set(0);
		mcRight.set(0);
		
	}
	public double sin(double x)
	{
		x= Math.sin(Math.toRadians(x));
		return x; 
	}
	public void tankDrive(double x) 
	{
		mcLeft.set(-.92*x);
		mcRight.set(x);
	}
public void tankDrive(double distance,  double speed) 
	{
		mcLeft.set(-.92*speed);
		mcRight.set(speed);
		Timer.delay(.667*distance/speed);
	/*	encode.leftENC.reset();
		encode.rightENC.reset();
		while (encode.distanceL<=distance)
		{
		encode.encodeL = encode.leftENC.get();
		encode.encodeR = encode.rightENC.get();
		encode.distanceL=encode.leftENC.getDistance();
		encode.distanceR=encode.rightENC.getDistance();
		
		}*/
		mcLeft.set(0);
		mcRight.set(0);
		
	}
}