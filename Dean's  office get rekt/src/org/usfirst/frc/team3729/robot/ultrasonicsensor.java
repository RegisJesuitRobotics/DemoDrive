package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;

public class ultrasonicsensor {
	Ultrasonic sonicfront;
	double range;
	int z;
	robotDrive Drive;
	public ultrasonicsensor()
	{
		
		sonicfront = new Ultrasonic(9,8,Unit.kMillimeter);
		sonicfront.setEnabled(true);
	}
	public int wallHacks()
	{
		z = 0;
		
		if (sonicfront.isRangeValid()==true)
		{
			range = sonicfront.getRangeMM();
			if (range<500)
			{
				z=1;
			}
		}
		return z;
	}
}
