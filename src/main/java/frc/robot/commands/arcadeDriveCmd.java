package frc.robot.commands;
import frc.robot.subsystems.driveSub;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class arcadeDriveCmd extends CommandBase{

private driveSub mdriveSub;
private Supplier<Double> speedFunction, turnFunction;

    public arcadeDriveCmd(driveSub mdriveSub, Supplier<Double> speedFunction, Supplier<Double> turnFunction){
      this.mdriveSub = mdriveSub;
      this.speedFunction = speedFunction;
      this.turnFunction = turnFunction;
      addRequirements(mdriveSub);
    }

    @Override
    public void initialize() {}
  
  
    @Override
    public void execute() {
      double realTimeSpeed = speedFunction.get();
      double realTimeTurn = turnFunction.get();

      double left = realTimeSpeed + realTimeTurn;
      double right = realTimeSpeed - realTimeTurn;
      mdriveSub.setMotors(left, right);
    }
  
  
    @Override
    public void end(boolean interrupted) {}
  
  
    @Override
    public boolean isFinished() {
      return false;
    }
}
