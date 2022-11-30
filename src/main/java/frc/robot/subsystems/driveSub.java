
package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class driveSub extends SubsystemBase {
  private CANSparkMax rightMotor1 = new CANSparkMax(1,  MotorType.kBrushless);
  private CANSparkMax rightMotor2 = new CANSparkMax(2,  MotorType.kBrushless);
  private CANSparkMax rightMotor3 = new CANSparkMax(3,  MotorType.kBrushless);

  private CANSparkMax leftMotor1 = new CANSparkMax(4,  MotorType.kBrushless);
  private CANSparkMax leftMotor2 = new CANSparkMax(5,  MotorType.kBrushless);
  private CANSparkMax leftMotor3 = new CANSparkMax(6,  MotorType.kBrushless);

  private MotorControllerGroup rightDrive = new MotorControllerGroup(rightMotor1, rightMotor2, rightMotor3);
  private MotorControllerGroup leftDrive = new MotorControllerGroup(leftMotor1, leftMotor2, leftMotor3);
  public DifferentialDrive diffDrive = new DifferentialDrive(leftDrive, rightDrive);

  public driveSub() {
  rightMotor1.setInverted(true);
  rightMotor2.setInverted(true);
  rightMotor3.setInverted(true);
  };


  public void setMotors(double leftSpeed, double rightSpeed){
    rightDrive.set(leftSpeed);
    leftDrive.set(rightSpeed);
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
