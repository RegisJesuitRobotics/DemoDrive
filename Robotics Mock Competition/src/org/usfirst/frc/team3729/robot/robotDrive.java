package org.usfirst.frc.team3729.robot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;



public class robotDrive {

	Talon mcLeftF;
	Talon mcRightF;
	Talon mcLeftB;
	Talon mcRightB;
	Input input;
	//Encode encode;
	//ultrasonicsensor ultrasound;
	 /*double  encodeL;
	 double  encodeR;
	 double distanceL;
	 double distanceR;*/
	 int sonic; 
	 double acceleration;
	 boolean state = true;
	 double circumference=.667*3.14159;//feet
	 double motorspeed=.9;//revolutions/second
	
	public robotDrive()
	{
		//ultrasound = new ultrasonicsensor();
		mcLeftF= new Talon(3);
		mcRightF= new Talon(2);
		mcLeftB= new Talon(1);
		mcRightB= new Talon(0);
		input = new Input();
		//encode = new Encode();
	}
	
	public void setSafetyEnabled(boolean b) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void tankDrive() 
	{
		//sonic = ultrasound.wallHacks();
		 boolean z1 = input.left.getRawButton(1);
		 boolean z2 = input.right.getRawButton(1);
		while ((z1==true)||(z2==true))
		{
			z1 = input.left.getRawButton(1);
			z2 = input.right.getRawButton(1);
			mcLeftF.set(.25*input.left.getRawAxis(1));
			mcRightF.set(.25*input.right.getRawAxis(1));
			mcLeftB.set(.25*input.left.getRawAxis(1));
			mcRightB.set(.25*input.right.getRawAxis(1));
		}
		mcLeftF.set(.5*input.left.getRawAxis(1));
		mcRightF.set(.5*input.right.getRawAxis(1));
		mcLeftB.set(.5*input.left.getRawAxis(1));
		mcRightB.set(.5*input.right.getRawAxis(1));
	}
	
	
	public void turn(double x)
	{
		x= sin(x);
		mcLeftF.set(.5);
		mcRightF.set(.5);
		mcLeftB.set(.5);
		mcRightB.set(.5);
		Timer.delay(x);//constant
		mcLeftB.set(0);
		mcRightB.set(0);
		
	}
	
	public double sin(double x)
	{
		x= Math.sin(Math.toRadians(x));
		return x; 
	}
	
	public void tankDrive(double x) 
	{
		mcLeftF.set(x);
		mcRightF.set(x);
		mcLeftB.set(x);
		mcRightB.set(x);
	}
	
	public void tankDrive(double distance,  double speed) 
	{
		mcLeftF.set(speed);
		mcRightF.set(speed);
		mcLeftB.set(speed);
		mcRightB.set(speed);
		
		Timer.delay(circumference*(distance-.25)/motorspeed);
	/*	encode.leftENC.reset();
		encode.rightENC.reset();
		while (distanceL<=distance)
		{
		encodeL = encode.leftENC.get();
		encodeR = encode.rightENC.get();
		distanceL=encode.leftENC.getDistance();
		distanceR=encode.rightENC.getDistance();
		
		}*/
		
		acceleration=2*speed;
		double time =0;
		double speedf =speed;
		//double distancea=(speed*time)+(acceleration*time*time);
		while ((speedf>0))
		{
		speedf=speed -(acceleration*time);
		mcLeftF.set(speedf);
		mcRightF.set(speedf);
		mcLeftB.set(speedf);
		mcRightB.set(speedf);
		Timer.delay(0.005);
		time=time+.005;
			if (speedf<0.05||speedf>-0.05)
			{
				mcLeftF.set(0);
				mcRightF.set(0);
				mcLeftB.set(0);
				mcRightB.set(0);
			}
		}
		while ((speedf<0))
		{
		speedf=speed +(acceleration*time);
		mcLeftF.set(speedf);
		mcRightF.set(speedf);
		mcLeftB.set(speedf);
		mcRightB.set(speedf);
		Timer.delay(0.005);
		time=time+.005;
			if (speedf<0.05||speedf>-0.05)
			{
				mcLeftF.set(0);
				mcRightF.set(0);
				mcLeftB.set(0);
				mcRightB.set(0);
			}
		}
	}

	public void arcadeDrive()
{
	double leftmotor;
	double rightmotor;
	boolean z1 = input.left.getRawButton(1);
	boolean z2 = input.right.getRawButton(1);
	double stickx = input.left.getRawAxis(0);
	double sticky = input.left.getRawAxis(1);
	  if (sticky > 0.0) {
          if (stickx > 0.0) {
              leftmotor = sticky - stickx;
              rightmotor = Math.max(sticky, stickx);
          } else {
              leftmotor = Math.max(sticky, -stickx);
              rightmotor = sticky + stickx;
          }
      } else {
          if (stickx > 0.0) {
              leftmotor = -Math.max(-sticky, stickx);
              rightmotor = sticky + stickx;
          } else {
              leftmotor = sticky - stickx;
              rightmotor = -Math.max(-sticky, -stickx);
          }
      }
	 
		if ((z1==true)||(z2==true))
		{
			z1 = input.left.getRawButton(1);
			z2 = input.right.getRawButton(1);
			mcLeftF.set(.5*leftmotor);
			mcRightF.set(.5*rightmotor);
			mcLeftB.set(.5*leftmotor);
			mcRightB.set(.5*rightmotor);
		}
		else
		{

      mcLeftF.set(leftmotor);
      mcRightF.set(rightmotor);
     mcLeftB.set(leftmotor);
      mcRightB.set(rightmotor);
		}
	
}

	public boolean change(int button1, int button2)
{
	boolean z2=input.left.getRawButton(button2);
	boolean z1=input.left.getRawButton(button1);
	
	if (z2==true)
	{
		state= true;
	}
	if (z1==true)
	{
		state= false;
	}
	return state;
	
}

	public void accelerate(double speedi)
	{
		double time =0;
		double speed =speedi;
		
		while ((speed>0))
		{
		speed =speedi -(acceleration*time);
		mcLeftF.set(speed);
		mcRightF.set(speed);
		mcLeftB.set(speed);
		mcRightB.set(speed);
		Timer.delay(0.005);
		time=time+.005;
			if (speed<0.05||speed>-0.05)
			{
				mcLeftF.set(0);
				mcRightF.set(0);
				mcLeftB.set(0);
				mcRightB.set(0);
			}
		}
		while ((speed<0))
		{
		speed=speedi +(acceleration*time);
		mcLeftF.set(speed);
		mcRightF.set(speed);
		mcLeftB.set(speed);
		mcRightB.set(speed);
		Timer.delay(0.005);
		time=time+.005;
			if (speed<0.05||speed>-0.05)
			{
				mcLeftF.set(0);
				mcRightF.set(0);
				mcLeftB.set(0);
				mcRightB.set(0);
			}
		}
		
		
	}


}






