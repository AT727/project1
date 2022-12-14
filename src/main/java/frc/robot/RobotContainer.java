// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.arcadeDriveCmd;
import frc.robot.commands.driveForwardForeverCmd;
import frc.robot.subsystems.driveSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final driveSub mdriveSub = new driveSub();
  private final Joystick driverController = new Joystick(0);
  final JoystickButton rightJoystick = new JoystickButton(driverController, 0);

  public RobotContainer() {
    mdriveSub.setDefaultCommand(
      new arcadeDriveCmd(mdriveSub, () -> driverController.getRawAxis(1), () -> driverController.getRawAxis(3))
    );
    
    configureButtonBindings();
  }


  private void configureButtonBindings() {}


  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(

      new driveForwardForeverCmd(mdriveSub)

    );

  }
}
