package org.usfirst.frc.team3729.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class pneumaticGripper {
	
	DoubleSolenoid exampleDouble;
	
	public pneumaticGripper(){

	exampleDouble = new DoubleSolenoid(1, 2);
	
	}
	
	//exampleDouble.set(DoubleSolenoid.Value.kOff);
	public void closeArams(){	
		exampleDouble.set(DoubleSolenoid.Value.kForward);
	}
	
	
	public void openArms(){
		
		exampleDouble.set(DoubleSolenoid.Value.kReverse);
	}
}
