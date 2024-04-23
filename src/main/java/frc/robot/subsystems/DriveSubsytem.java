// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsytem extends SubsystemBase {
  private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(Constants.DriveConstants.leftFrontMotorCANID);
  private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(Constants.DriveConstants.rightFrontMotorCANID);
  private final WPI_TalonSRX leftRearMotor = new WPI_TalonSRX(Constants.DriveConstants.leftRearMotorCANID);
  private final WPI_TalonSRX rightRearMotor = new WPI_TalonSRX(Constants.DriveConstants.rightRearMotorCANID);
  /** Creates a new DriveSubsytem. */

  DifferentialDrive diffDrive;
  
  public DriveSubsytem() {
    configureMotors();
    //diffDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }
  
  private void configureMotors(){
    leftFrontMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();
    leftRearMotor.configFactoryDefault();
    rightRearMotor.configFactoryDefault();

    leftFrontMotor.setInverted(Constants.DriveConstants.leftFrontMotorInverted);
    rightFrontMotor.setInverted(Constants.DriveConstants.rightFrontMotorInverted);
    leftRearMotor.setInverted(Constants.DriveConstants.leftRearMotorInverted);
    rightRearMotor.setInverted(Constants.DriveConstants.rightRearMotorInverted);

    leftRearMotor.follow(leftFrontMotor);
    rightRearMotor.follow(rightFrontMotor);

  } 

  public void setBrakeMode() {
    leftFrontMotor.setNeutralMode(NeutralMode.Brake);
    rightFrontMotor.setNeutralMode(NeutralMode.Brake);
    leftRearMotor.setNeutralMode(NeutralMode.Brake);
    rightRearMotor.setNeutralMode(NeutralMode.Brake);
  }

 public void manualDrive(double speed, double turn) {
     diffDrive.arcadeDrive(speed, turn);
 }
 public void testRightLeaderMotor(double power) {
  rightFrontMotor.set(power);
}

  public void testLeftLeaderMotor(double power) {
  leftFrontMotor.set(power);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
