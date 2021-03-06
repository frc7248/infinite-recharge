// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  Spark leftFront;
  Spark rightFront;
  Spark leftBack;
  Spark rightBack;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront = new Spark (Constants.LEFT_FRONT);
    leftFront.setInverted(true);
    rightFront = new Spark (Constants.RIGHT_FRONT);
    rightFront.setInverted(false);
    leftBack = new Spark(Constants.LEFT_BACK);
    leftBack.setInverted(true);
    rightBack = new Spark (Constants.RIGHT_BACK);
    rightBack.setInverted(false);

    leftMotors = new SpeedControllerGroup(leftFront, leftBack);
    rightMotors = new SpeedControllerGroup(rightFront, rightBack);
    drive = new DifferentialDrive(leftMotors, rightMotors);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveWithJoySticks(XboxController controller, double speed)
  {
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
    //Y_Axis: forward and back arguments
    //X_Axis: rotational arguments
  }

  public void driveForward(double speed)
  {
    drive.tankDrive(speed, speed);
  }

  public void stop()
  {
    drive.stopMotor();
  }
}
