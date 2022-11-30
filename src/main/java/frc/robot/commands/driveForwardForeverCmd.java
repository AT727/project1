package frc.robot.commands;
import frc.robot.subsystems.driveSub;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class driveForwardForeverCmd extends CommandBase {

  private final driveSub mdriveSub;


  public driveForwardForeverCmd(driveSub mdriveSub) {
    this.mdriveSub = mdriveSub;
  
    addRequirements(mdriveSub);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    mdriveSub.setMotors(0.2, 0.2);
  }


  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }
}
