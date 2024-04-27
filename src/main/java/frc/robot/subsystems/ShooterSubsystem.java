// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

  private final WPI_TalonSRX rightSpinnerMotor = new WPI_TalonSRX(Constants.DriveConstants.rightSpinnerMotorCANID);
  private final WPI_TalonSRX leftSpinnerMotor = new WPI_TalonSRX(Constants.DriveConstants.leftSpinnerMotorCANID);

  
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    configureMotors();
  }

  public void configureMotors(){
  rightSpinnerMotor.setInverted(Constants.DriveConstants.rightSpinnerMotorInverted);
  leftSpinnerMotor.setInverted(Constants.DriveConstants.leftSpinnerMotorInverted);
 
  rightSpinnerMotor.follow(leftSpinnerMotor);
  }

  public void setBrakeMode() {
    rightSpinnerMotor.setNeutralMode(NeutralMode.Brake);
    leftSpinnerMotor.setNeutralMode(NeutralMode.Brake);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
