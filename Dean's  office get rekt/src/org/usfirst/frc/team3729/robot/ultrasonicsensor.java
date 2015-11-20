package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;

public class ultrasonicsensor {
	Ultrasonic sonicfront;
	double range;
	robotDrive Drive;
	public ultrasonicsensor()
	{
		
		sonicfront = new Ultrasonic(9,8,Unit.kMillimeter);
		sonicfront.setEnabled(true);
	}
	public void wallHacks()
	{
		range = sonicfront.getRangeMM();
		if (sonicfront.isRangeValid()==true)
		{
			if (range<1000)
			{
				Drive.mcLeft.set(0);
				Drive.mcRight.set(0);
				
			}
		}
	}
}
