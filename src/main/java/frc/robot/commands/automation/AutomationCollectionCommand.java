/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.automation;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.conveyor.ConveyorMoveCommand;
import frc.robot.commands.intake.IntakeDoubleSolenoid;
import frc.robot.commands.intake.IntakeMoveCommand;
import frc.robot.commands.shooter.ShooterConveyorCommand;
import frc.robot.subsystems.Automation;
import frc.robot.subsystems.IntakeSubsystem;

public class AutomationCollectionCommand extends CommandBase {

  private Automation automationSubsystem;
  private CommandBase intakeSolenoidCommand, intakeMoveCommand, conveyorMoveCommand, shooterConveyorCommand;

  /**
   * Creates a new AutomationCollectionCommand.
   */
  public AutomationCollectionCommand() {
    automationSubsystem = Automation.getinstance();

    intakeSolenoidCommand = new IntakeDoubleSolenoid();
    intakeMoveCommand = new IntakeMoveCommand(-.5);
    conveyorMoveCommand = new ConveyorMoveCommand(-.5);
    shooterConveyorCommand = new ShooterConveyorCommand(-.5);

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(automationSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (!IntakeSubsystem.getInstance().getDoubleSolenoid()){
      intakeSolenoidCommand.initialize();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeMoveCommand.execute();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  intakeMoveCommand.end(true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
