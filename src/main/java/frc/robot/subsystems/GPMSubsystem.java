// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class GPMSubsystem extends SubsystemBase {

  private WPI_TalonSRX rightSpinnerMotor;
  private WPI_TalonSRX leftSpinnerMotor;
  private WPI_TalonSRX fireBallMotor;
  private WPI_TalonSRX tiltMotorController;

  /** Creates a new ShooterSubsystem. */
  public GPMSubsystem() {
    rightSpinnerMotor = new WPI_TalonSRX(Constants.GPMConstants.rightSpinnerMotorCANID);
    leftSpinnerMotor = new WPI_TalonSRX(Constants.GPMConstants.leftSpinnerMotorCANID);
    fireBallMotor = new WPI_TalonSRX(Constants.GPMConstants.FireBallCANID);
    tiltMotorController = new WPI_TalonSRX(Constants.GPMConstants.tiltMotorControllerCANID);
    configureMotors();
    configureCurrentLimiterFireball();
    configureTiltMotors();
  }

  public void configureMotors() {
    rightSpinnerMotor.setInverted(Constants.DriveConstants.rightSpinnerMotorInverted);
    leftSpinnerMotor.setInverted(Constants.DriveConstants.leftSpinnerMotorInverted);

    leftSpinnerMotor.follow(rightSpinnerMotor);
  }

  public void configureTiltMotors() {
    tiltMotorController.configFactoryDefault();

    tiltMotorController.setInverted(Constants.GPMConstants.tiltMotorInverted);
    tiltMotorController.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
        Constants.GPMConstants.PID_TILT,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    //set the sensor phase for the tilt motor controller
    tiltMotorController.setSensorPhase(Constants.GPMConstants.tiltEncoderSensorPhase);
    tiltMotorController.configPeakOutputForward(Constants.GPMConstants.peakOutput,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    tiltMotorController.configPeakOutputReverse(Constants.GPMConstants.peakOutput * (-1),
        Constants.CurrentLimitConstants.configureTimeoutMs);
    tiltMotorController.configNominalOutputForward(0,Constants.CurrentLimitConstants.configureTimeoutMs);
    tiltMotorController.configNominalOutputReverse(0,Constants.CurrentLimitConstants.configureTimeoutMs);

    tiltMotorController.configAllowableClosedloopError(Constants.GPMConstants.SLOT_0, 
        Constants.GPMConstants.tiltDefaultAcceptableError,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    
    tiltMotorController.config_kP(Constants.GPMConstants.SLOT_0, 
        Constants.GPMConstants.P_TILT,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    tiltMotorController.config_kI(Constants.GPMConstants.SLOT_0, 
        Constants.GPMConstants.I_TILT,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    tiltMotorController.config_kD(Constants.GPMConstants.SLOT_0,
        Constants.GPMConstants.D_TILT,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    tiltMotorController.config_kF(Constants.GPMConstants.SLOT_0,
        Constants.GPMConstants.F_TILT,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    
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
    fireBallMotor.configPeakCurrentLimit(Constants.CurrentLimitConstants.anglePeakCurrentLimit,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    fireBallMotor.configPeakCurrentDuration(Constants.CurrentLimitConstants.anglePeakCurrentDuration,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    fireBallMotor.configContinuousCurrentLimit(Constants.CurrentLimitConstants.angleContinuousCurrentLimit,
        Constants.CurrentLimitConstants.configureTimeoutMs);
    fireBallMotor.enableCurrentLimit(Constants.CurrentLimitConstants.angleEnableCurrentLimit);
  }

  public int getTiltEncoder() {
    return (int) tiltMotorController.getSelectedSensorPosition();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
