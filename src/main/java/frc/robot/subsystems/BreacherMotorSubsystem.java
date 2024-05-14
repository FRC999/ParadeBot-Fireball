// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BreacherMotorSubsystem extends SubsystemBase {
  private WPI_TalonSRX leftBreacherMotor;
  private WPI_TalonSRX rightBreacherMotor;

  /** Creates a new ShutterDoorSubsystem. */
  public BreacherMotorSubsystem() {
     leftBreacherMotor = new WPI_TalonSRX(Constants.BreacherMotorConstants.leftBreacherMotorCANID);
     rightBreacherMotor = new WPI_TalonSRX(Constants.BreacherMotorConstants.rightBreacherMotorCANID);

     configureMotors();
  }

  public void configureMotors(){
    leftBreacherMotor.setInverted(Constants.BreacherMotorConstants.leftBreacherMotorInverted);
    rightBreacherMotor.setInverted(Constants.BreacherMotorConstants.rightBreacherMotorInverted);

    //leftBreacherMotor.follow(rightBreacherMotor);
  }

  public void setBrakeModeSpinnerMotor() {
    rightBreacherMotor.setNeutralMode(NeutralMode.Brake);
    leftBreacherMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void rightBreacherMotorForward() {
    rightBreacherMotor.set(Constants.BreacherMotorConstants.rightBreacherMotorForwardPower);
  }
  
  public void leftBreacherMotorForward(){
     leftBreacherMotor.set(Constants.BreacherMotorConstants.leftBreacherMotorForwardPower);
  }

  public void rightBreacherMotorReverse() {
    rightBreacherMotor.set(Constants.BreacherMotorConstants.rightBreacherMotorReversePower);
  }

  public void leftBreacherMotorReverse(){
    leftBreacherMotor.set(Constants.BreacherMotorConstants.leftBreacherMotorReversePower);
  }

  public double getRightBreacherCurrentRecord() {
    return rightBreacherMotor.getSupplyCurrent();
  }

  public double getLeftBreacherCurrentRecord() {
    return leftBreacherMotor.getSupplyCurrent();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
