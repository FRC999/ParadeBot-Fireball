// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
	public static final int shooterIntakeOut = 1;
	public static final int shooterIntakeIn = 2;
	public static final int fireBallRight = 3;
	public static final int fireBallLeft = 4;
	public static final int armDown = 5;
	public static final int armUp = 6;
	public static final int SWITCH_PORT = 1; //dio port of the encoder
  }
  public static class DriveConstants {
    public static final int rightFrontMotorCANID = 3 ;
	public static final int rightRearMotorCANID = 4 ;
    public static final int leftFrontMotorCANID = 1 ;
    public static final int leftRearMotorCANID = 2 ;

    
    public static final boolean rightFrontMotorInverted = true;
	public static final boolean rightRearMotorInverted = true;
    public static final boolean leftFrontMotorInverted = false;
    public static final boolean leftRearMotorInverted = false;
	public static final boolean rightSpinnerMotorInverted = false;
	public static final boolean leftSpinnerMotorInverted = true;
    public static double turnAdjust = 0.6;
  }

 public static final class OIConstants {
		public static final int driverControllerPort = 0;

		public static enum ControllerDeviceType {
			LOGITECH,
			PS5,
			XBOX, // RightJ F/B, LeftJ L/R, L2/R2 - rotation
			XBOX_ONEDRIVE // RIghtJ F/B/L/R, LeftJ - rotation
		}

		public static enum ControllerDevice {
			
			XBOX_CONTROLLER(
					0, // Port Number for Xbox controller
					ControllerDeviceType.XBOX,
					0.03, // deadband X for Xbox
					0.03, // deadband Y for Xbox //TODO: ALL DEADBAND FOR XBOX IS PLACEHOLDER
					0.03, // deadband Omega for Xbox
					false, // No cube controller configuration for Xbox yet
					false);


			private ControllerDeviceType controllerDeviceType;
			private int portNumber;
			private double deadbandX;
			private double deadbandY;
			private double deadbandOmega;
			private boolean cubeControllerLeftStick;
			private boolean cubeControllerRightStick;

			ControllerDevice(int pn, ControllerDeviceType cdt, double dx, double dy, double dm, boolean ccL,
					boolean ccR) {
				this.portNumber = pn;
				this.controllerDeviceType = cdt;
				this.deadbandX = dx;
				this.deadbandY = dy;
				this.deadbandOmega = dm;
				this.cubeControllerLeftStick = ccL;
				this.cubeControllerRightStick = ccR;
			}

			public ControllerDeviceType getControllerDeviceType() {
				return controllerDeviceType;
			}

			public int getPortNumber() {
				return portNumber;
			}

			public double getDeadbandX() {
				return deadbandX;
			}

			public double getDeadbandY() {
				return deadbandY;
			}

			public double getDeadbandOmega() {
				return deadbandOmega;
			}

			public boolean isCubeControllerLeftStick() {
				return cubeControllerLeftStick;
			}

			public boolean isCubeControllerRightStick() {
				return cubeControllerRightStick;
			}
		}
	}

	public static final class GPMConstants {
		public static final double IntakeSpeed = -0.7;

		public static final double ShooterSpeed = 0.9;

		public static final double StopIntake = 0.0;

		public static final int rightSpinnerMotorCANID = 6;

		public static final int leftSpinnerMotorCANID = 5;

		public static final int FireBallCANID = 8;

		public static final double FireBallSpeed = 0.3;

		public static final double fireBallStop = 0.0;

		/*Tilt Motor Controller Constants*/

		public static final int tiltMotorControllerCANID = 7;
		public static final boolean tiltMotorInverted = true;
		public static final boolean tiltEncoderSensorPhase = false; 
		public static final int PID_TILT = 0;
		public static final double peakOutput = 1.0;
		public static final int SLOT_0 = 0;
		public static final int tiltDefaultAcceptableError = 1; 
		public static final int armUpPosition = 140; 
		public static final int armDownPosition = 0; 
		
		public static final double P_TILT = 10.0;
		public static final double I_TILT = 0.0;
		public static final double D_TILT = 0.0;
		public static final double F_TILT = 0.0;
	}

	public static final class CurrentLimitConstants {
		public static final int angleContinuousCurrentLimit = 1; // amperes
        	public static final int anglePeakCurrentLimit = 5; // amperes
			public static final int anglePeakCurrentDuration = 1000; // Milliseconds
			public static final boolean angleEnableCurrentLimit = true;
			public static final int configureTimeoutMs = 30;
	}

}
