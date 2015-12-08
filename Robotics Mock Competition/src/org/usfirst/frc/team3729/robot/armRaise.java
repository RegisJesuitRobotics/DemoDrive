package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.Talon;

public class armRaise {
	// xbox stuff
	//A:1 B:2 x:3 Y:4 LB;5 RB:6 Back:7 Start:8 LSClick:9 RSClick:10
	//LSXAxis:0  LSYAxis:1 LTrigger:2 RTrigger:3 RXAxis:4 RYAxis=5
	Talon mcRaise;
	Input input;
	public armRaise()
	{
		mcRaise= new Talon(1);
	}
	public void lift()
	{
		boolean up=input.left.getRawButton(4);
		boolean down=input.left.getRawButton(3);
		if (up==true)
		{
			mcRaise.set(.5);
		}
		if (down==true)
		{
			mcRaise.set(-.5);
		}
		else
		{
			 
		}
	}
}
