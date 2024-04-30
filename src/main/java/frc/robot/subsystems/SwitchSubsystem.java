// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwitchSubsystem extends SubsystemBase {
  public static DigitalInput limitSwitch;
  /** Creates a new LimitSwitchSubsystem. */
  public SwitchSubsystem() {
        //Initialize the limit switch
        if(limitSwitch == null) {
          try {
            limitSwitch = new DigitalInput(Constants.OperatorConstants.SWITCH_PORT);
          } catch (Exception e) {
            System.out.println("No Value");
          }
        }
  }

  public boolean getSwitch() {
    return !limitSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}