package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;

public class servoControl {
	Servo camServo;
	Input input;
	int y=90;
	int x=0;
	int z=1;
	public servoControl()
	{
		 input = new Input();
		camServo = new Servo(2);
	}
	public void camTurn(double x)
	{
		/*if (x==315)
		{
			camServo.setAngle(45);
		}
		if (x==45)
		{
			camServo.setAngle(135);
		}
		if (x==0)
		{
			camServo.setAngle(90);
		}*/
		camServo.setAngle(x);
	}
	public void camTurn()
	{
	
		if (z==1)
		{
		camServo.setAngle(90);
		}
		z=2;
		
			x=input.left.getPOV();
			if (x==90)
			{
				if (y<180)
				{
				y=y+45;
			camServo.setAngle(y);
			Timer.delay(.15);
				}
			}
			if (x==0)
			{
				camServo.setAngle(90);
				y=90;
				Timer.delay(.15);
			}
			if (x==270)
			{
				if (y>0)
					{
						y=y-45;
						camServo.setAngle(y);
						Timer.delay(.15);
					}
			}

	}
}

