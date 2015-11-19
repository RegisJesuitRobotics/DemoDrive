package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Input {

	Joystick left, right;
	
	public Input(){
		left = new Joystick(0);
		right = new Joystick(1);
		
	}
}