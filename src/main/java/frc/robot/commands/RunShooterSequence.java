// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RunShooterSequence extends SequentialCommandGroup {
  /** Creates a new RunShooterSequence. */
  public RunShooterSequence() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ArmUp(),
      new WaitCommand(0.5),
      new ShooterOut(),
      new WaitCommand(1.0),
      new RunShutter(),
      new WaitCommand(0.5),
      new ArmRelax(),
      new ShooterStop()
    );
  }
}
