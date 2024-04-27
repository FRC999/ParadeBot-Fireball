// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

  private final WPI_TalonSRX rightSpinnerMotor;
  private final WPI_TalonSRX leftSpinnerMotor;
  private final WPI_TalonSRX fireBallMotor;

  
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    rightSpinnerMotor = new WPI_TalonSRX(Constants.GPMConstants.rightSpinnerMotorCANID);
    leftSpinnerMotor = new WPI_TalonSRX(Constants.GPMConstants.leftSpinnerMotorCANID);
    fireBallMotor = new WPI_TalonSRX(Constants.GPMConstants.FireBallCANID);
    configureMotors();
    configureCurrentLimiterFireball();
  }

  public void configureMotors(){
  rightSpinnerMotor.setInverted(Constants.DriveConstants.rightSpinnerMotorInverted);
  leftSpinnerMotor.setInverted(Constants.DriveConstants.leftSpinnerMotorInverted);
 
  leftSpinnerMotor.follow(rightSpinnerMotor);
  }

  public void setBrakeMode() {
    rightSpinnerMotor.setNeutralMode(NeutralMode.Brake);
    leftSpinnerMotor.setNeutralMode(NeutralMode.Brake);

  }

  public void spinIntakeForward() {
    rightSpinnerMotor.set(Constants.GPMConstants.ShooterSpeed);
  }

  public void spinIntakeReverse() {
    rightSpinnerMotor.set(Constants.GPMConstants.IntakeSpeed);
  }

  public void stopIntakeMotor() {
    rightSpinnerMotor.set(Constants.GPMConstants.StopIntake);
  }

  public void FireBallRight() {
    fireBallMotor.set(Constants.GPMConstants.FireBallSpeed);
  }

  public void FireBallLeft() {
    fireBallMotor.set(-Constants.GPMConstants.FireBallSpeed);
  }

  public void FireBallStop() {
    fireBallMotor.set(Constants.GPMConstants.fireBallStop);
  }

  private void configureCurrentLimiterFireball() {
    fireBallMotor.configPeakCurrentLimit(Constants.CurrentLimitConstants.anglePeakCurrentLimit, Constants.CurrentLimitConstants.configureTimeoutMs);
    fireBallMotor.configPeakCurrentDuration(Constants.CurrentLimitConstants.anglePeakCurrentDuration, Constants.CurrentLimitConstants.configureTimeoutMs);
    fireBallMotor.configContinuousCurrentLimit(Constants.CurrentLimitConstants.angleContinuousCurrentLimit, Constants.CurrentLimitConstants.configureTimeoutMs);
    fireBallMotor.enableCurrentLimit(Constants.CurrentLimitConstants.angleEnableCurrentLimit);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
