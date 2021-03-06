/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.balance;

import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbBalanceSubsystem;

public class ClimbBalanceMoveCommand extends CommandBase {

  ClimbBalanceSubsystem climbBalanceSubsystem;

  /**
   * Creates a new ClimbBalanceMoveCommand.
   */
  public ClimbBalanceMoveCommand() {
    climbBalanceSubsystem = ClimbBalanceSubsystem.getInstance();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climbBalanceSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!(RobotContainer.OperatingJoystick.getAxisType(0) < 0.15 && RobotContainer.OperatingJoystick.getAxisType(0) > 0.15 )) {
      climbBalanceSubsystem.setMotor(RobotContainer.OperatingJoystick.getRawAxis(0));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbBalanceSubsystem.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
