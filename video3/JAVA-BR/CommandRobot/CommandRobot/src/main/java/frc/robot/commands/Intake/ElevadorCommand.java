package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Intake.ElevadorSubsystem;

public class ElevadorCommand extends CommandBase {  

    ElevadorSubsystem elevador;

    public ElevadorCommand(ElevadorSubsystem subsystem) {
      elevador = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        RobotContainer.eSubsystem.stop();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        elevador.elevatorWithJoystick(RobotContainer.m_operatorController, OperatorConstants.SpeedElevador);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  }
  
