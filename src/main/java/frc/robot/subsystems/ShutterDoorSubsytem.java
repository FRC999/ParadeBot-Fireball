// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShutterDoorSubsytem extends SubsystemBase {

  private TalonSRX fireBallMotor;
  /** Creates a new ShutterDoorSubsytem. */
  public ShutterDoorSubsytem() {
    fireBallMotor = new WPI_TalonSRX(Constants.ShutterDoorConstants.shutterMotorCANID);
  }

  public void configureShutterMotor(){
    fireBallMotor.configFactoryDefault();
    fireBallMotor.setInverted(Constants.ShutterDoorConstants.shutterMotorInverted);
  }

  public void runShutter(double power){
    fireBallMotor.set(TalonSRXControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
