// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants.ControllerDevice;
import frc.robot.commands.ArmRelax;
import frc.robot.commands.ArmUp;
import frc.robot.commands.Autos;
import frc.robot.commands.BreacherArmLeftRetract;
import frc.robot.commands.BreacherArmLeftWave;
import frc.robot.commands.BreacherArmRightForward;
import frc.robot.commands.BreacherArmRightRetract;
import frc.robot.commands.BreacherArmRightReverse;
import frc.robot.commands.BreacherArmRightWave;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunIntakeSequence;
import frc.robot.commands.RunShooterSequence;
import frc.robot.commands.ShooterIn;
import frc.robot.commands.ShooterOut;
import frc.robot.commands.RunShutter;
import frc.robot.commands.ShooterStop;
import frc.robot.commands.StopLeftBreacherArm;
import frc.robot.commands.StopRightBreacherArm;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.BreacherMotorLeftSubsystem;
import frc.robot.subsystems.DriveSubsytem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ShutterDoorSubsytem;
import frc.robot.subsystems.BreacherMotorRightSubsystem;
import frc.robot.subsystems.SmartDashboardSubsystem;
import frc.robot.subsystems.SwitchSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  public final static DriveSubsytem driveSubsystem = new DriveSubsytem(); 
  public final static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public final static SwitchSubsystem switchSubsystem = new SwitchSubsystem();
  public final static SmartDashboardSubsystem smartDashboardSubsystem = new SmartDashboardSubsystem();
  public final static ArmSubsystem armSubsystem = new ArmSubsystem();
  public final static BreacherMotorRightSubsystem breacherMotorRightSubsytem = new BreacherMotorRightSubsystem();
  public final static BreacherMotorLeftSubsystem breacherMotorLeftSubsystem = new BreacherMotorLeftSubsystem();
  public final static ShutterDoorSubsytem shutterDoorSubsystem = new ShutterDoorSubsytem();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  
  private final Controller xboxController =
      new Controller(ControllerDevice.XBOX_CONTROLLER);

  public RobotContainer(){
    //configure the trigger bindings
    configureBindings();
    
      driveSubsystem.setDefaultCommand(
         new DriveManuallyCommand(
            () -> getDriverXAxis(),
            () -> getDriverYAxis()));
  }

   /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
   // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  //testArm();
  //testMotors();
  //testShutter();
  //testIntakeSequence();
  // testShooterSequence();
  //testArms();
  finalControlMappings();
  }

  private void finalControlMappings() {
    new Trigger(() -> xboxController.getRawAxis(Constants.OIConstants.xBoxControllerRightTrigger) > 0.3)
    .onTrue(new RunIntakeSequence())
    .onFalse(new ShooterStop()); 

    new Trigger(() -> xboxController.getRawAxis(Constants.OIConstants.xBoxControllerLeftTrigger) > 0.3)
      .onTrue(new RunShooterSequence());

    new JoystickButton(xboxController, 5)
      .onTrue(new BreacherArmLeftWave().alongWith(new BreacherArmRightWave()));
    
    new JoystickButton(xboxController, 6)
      .onTrue(new BreacherArmRightRetract().alongWith(new BreacherArmLeftRetract()));
  }



  private void testMotors() {
    /*new JoystickButton(xboxController, 3)
        .onTrue(new InstantCommand(() -> RobotContainer.driveSubsystem.testRightLeaderMotor(0.6)))
        .onFalse(new InstantCommand(() -> RobotContainer.driveSubsystem.testRightLeaderMotor(0.0)));
    new JoystickButton(xboxController, 4)
        .onTrue(new InstantCommand(() -> RobotContainer.driveSubsystem.testLeftLeaderMotor(0.6)))
        .onFalse(new InstantCommand(() -> RobotContainer.driveSubsystem.testLeftLeaderMotor(0.0)));
    new JoystickButton(xboxController, Constants.OperatorConstants.shooterIntakeIn)
        .whileTrue(new ShooterIn())
        .whileFalse(new ShooterStop());
    new JoystickButton(xboxController, Constants.OperatorConstants.shooterIntakeOut)
        .whileTrue(new ShooterOut())
        .whileFalse(new ShooterStop());
/*  new JoystickButton(xboxController, Constants.OperatorConstants.fireBallLeft)
      .whileTrue(new LeftFireBall())
      .whileFalse(new FireBallStop());
    new JoystickButton(xboxController, Constants.OperatorConstants.fireBallRight)
      .whileTrue(new RightFireBall())
      .whileFalse(new FireBallStop());*/
  }
 
  private double getDriverXAxis() {
    return -xboxController.getLeftStickY();
  }

  private double getDriverYAxis() {
    return -xboxController.getRightStickX();
  }

  /*public void testShutter(){
    new JoystickButton(xboxController, Constants.OperatorConstants.moveShutter)
      .onTrue(new RunShutter());
  }

  public void testIntakeSequence(){
    new JoystickButton(xboxController,7)
      .onTrue(new RunIntakeSequence())
      .onFalse(new ShooterStop());
  }

  public void testShooterSequence(){
    new JoystickButton(xboxController, 8)
      .onTrue(new RunShooterSequence());
  } 
   private void testArms(){
    new JoystickButton(xboxController, 8)
      .onTrue(new BreacherArmLeftWave().alongWith(new BreacherArmRightWave()))
      .onFalse(new StopRightBreacherArm().alongWith(new StopLeftBreacherArm()));

    new JoystickButton(xboxController, 7)
      .onTrue(new BreacherArmRightWave())
      .onFalse(new StopRightBreacherArm();   
  }*/

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}