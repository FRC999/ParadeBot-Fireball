// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BreacherMotorLeftSubsystem extends SubsystemBase {
  private WPI_TalonSRX leftBreacherMotor;

  /** Creates a new BreacherMotorLeftSubsystem. */
  public BreacherMotorLeftSubsystem() {
    leftBreacherMotor = new WPI_TalonSRX(Constants.BreacherMotorConstants.leftBreacherMotorCANID);
  }

  public void configureMotors() {
    leftBreacherMotor.setInverted(Constants.BreacherMotorConstants.leftBreacherMotorInverted);
  }

  public void setBrakeModeSpinnerMotor() {
    leftBreacherMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void leftBreacherMotorForward() {
    leftBreacherMotor.set(Constants.BreacherMotorConstants.leftBreacherMotorForwardPower);
  }

  public void leftBreacherMotorReverse() {
    leftBreacherMotor.set(Constants.BreacherMotorConstants.leftBreacherMotorReversePower);
  }

  public void stopLeftBreacherArm() {
    leftBreacherMotor.set(Constants.BreacherMotorConstants.stopLeftBreacherArm);
  }

  public double getLeftBreacherCurrentRecord() {
    return leftBreacherMotor.getSupplyCurrent();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
