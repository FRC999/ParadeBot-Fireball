// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  
private WPI_TalonSRX tiltMotorController;
  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
     tiltMotorController = new WPI_TalonSRX(Constants.GPMConstants.tiltMotorControllerCANID);

    configureTiltMotors();

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

    //tiltMotorController.configAllowableClosedloopError(Constants.GPMConstants.SLOT_0, 
    //    Constants.GPMConstants.tiltDefaultAcceptableError,
    //    Constants.CurrentLimitConstants.configureTimeoutMs);
    
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

  public void setArmToPower(double power){
    tiltMotorController.set(TalonSRXControlMode.PercentOutput, power);
  }
  
  public void setArmToPositon(int position ){
    tiltMotorController.set(TalonSRXControlMode.Position, position);
  }

  public int getTiltEncoder() {
    return (int) tiltMotorController.getSelectedSensorPosition();
  }

  public void tiltMotorBrakeMode() {
    tiltMotorController.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
