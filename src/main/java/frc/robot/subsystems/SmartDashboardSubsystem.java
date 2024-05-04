// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class SmartDashboardSubsystem extends SubsystemBase {
  /** Creates a new SmartDashboardSubsystem. */
  public SmartDashboardSubsystem() {}

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Trigger Open: ", RobotContainer.switchSubsystem.limitSwitch.get());
    SmartDashboard.putNumber("Relative Encoder Value: ", RobotContainer.shooterSubsystem.getTiltEncoder());
  }
}