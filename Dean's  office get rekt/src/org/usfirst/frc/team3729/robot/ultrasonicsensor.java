package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;

public class ultrasonicsensor {
	Ultrasonic sonicfront;
	double range;
	robotDrive drive;
	public ultrasonicsensor()
	{
		drive = new robotDrive();
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
				drive.mcLeft.set(0);
				drive.mcRight.set(0);
				
			}
		}
	}
}
