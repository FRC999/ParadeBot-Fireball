// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsytem extends SubsystemBase {
  private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(Constants.DriveConstants.leftFrontMotorCANID);
  private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(Constants.DriveConstants.rightFrontMotorCANID);
  private final WPI_TalonSRX leftRearMotor = new WPI_TalonSRX(Constants.DriveConstants.leftRearMotorCANID);
  private final WPI_TalonSRX rightRearMotor = new WPI_TalonSRX(Constants.DriveConstants.rightRearMotorCANID);
  /** Creates a new DriveSubsytem. */
  
  public DriveSubsytem() {}
  
  private void configureMotors(){
    leftFrontMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();
    leftRearMotor.configFactoryDefault();
    rightRearMotor.configFactoryDefault();
  } 
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
