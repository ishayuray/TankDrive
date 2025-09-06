// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
  WPI_VictorSPX leftRearMotor = new WPI_VictorSPX(DrivetrainConstants.leftRearMotor);
  WPI_VictorSPX rightRearMotor = new WPI_VictorSPX(DrivetrainConstants.rightRearMotor);
  WPI_VictorSPX leftForwardMotor = new WPI_VictorSPX(DrivetrainConstants.leftForwardMotor);
  WPI_VictorSPX rightForwardMotor = new WPI_VictorSPX(DrivetrainConstants.rightForwardMotor);
  DifferentialDrive differentialDrive;
  public Drivetrain() {
    leftRearMotor.follow(leftForwardMotor);
    rightRearMotor.follow(rightForwardMotor);
    differentialDrive = new DifferentialDrive(leftForwardMotor, rightForwardMotor);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  
  public Command driveCommand(double leftSpeed, double rightSpeed) {
    // Drive the robot
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
