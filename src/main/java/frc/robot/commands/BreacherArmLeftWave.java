// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class BreacherArmLeftWave extends Command {
  private boolean forwardDirection = true;
  private int counter = 0;

  /** Creates a new BreacherArmLeftWave. */
  public BreacherArmLeftWave() {
    addRequirements(RobotContainer.breacherMotorLeftSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    forwardDirection = true;
    RobotContainer.breacherMotorLeftSubsystem.leftBreacherMotorForward();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (counter == 0) {
      if (Math.abs(RobotContainer.breacherMotorLeftSubsystem
          .getLeftBreacherCurrentRecord()) > Constants.BreacherMotorConstants.stallCurrent) {
        if (forwardDirection) {
          System.out.println("F to R");
          forwardDirection = false;
          RobotContainer.breacherMotorLeftSubsystem.leftBreacherMotorReverse();
          counter = 100; 
        } else {
          System.out.println("R to F");
          forwardDirection = true;
          RobotContainer.breacherMotorLeftSubsystem.leftBreacherMotorForward();
          counter = 100;
        }
      }
    } else {
      counter--;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
