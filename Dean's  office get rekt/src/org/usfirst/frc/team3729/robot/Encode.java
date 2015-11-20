package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.Encoder;

public class Encode {
	 Encoder leftENC;
	 Encoder rightENC;
	
public Encode()
{
	leftENC = new Encoder(0,1,false,Encoder.EncodingType.k2X);
	 leftENC.setMaxPeriod(1);//maximum time in which the device is still considered moving
	 leftENC.setMinRate(10);//min rate b/4 considered stopped
	 leftENC.setDistancePerPulse(1);//sets scale factor between pulse and distance
	 leftENC.setReverseDirection(true);//depending on mounting of motor
	 leftENC.setSamplesToAverage(7);//averaging reduces jittery movement
	 rightENC= new Encoder(2,3,false,Encoder.EncodingType.k2X);
	 rightENC.setMaxPeriod(1);//maximum time in which the device is still considered moving
	 rightENC.setMinRate(10);//min rate b/4 considered stopped
	 rightENC.setDistancePerPulse(5);//sets scale factor between pulse and distance
	 rightENC.setReverseDirection(true);//depending on mounting of motor
	 rightENC.setSamplesToAverage(7);//averaging reduces jittery movemennt	
}
	 
}
