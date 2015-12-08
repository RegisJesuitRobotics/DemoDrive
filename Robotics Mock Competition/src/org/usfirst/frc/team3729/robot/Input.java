package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Input {

	Joystick left, right, xbox;
	
	public Input(){
		left = new Joystick(0);
		right = new Joystick(1);
		xbox = new Joystick(2);
		
	}
}
