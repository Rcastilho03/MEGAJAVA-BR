package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class DriveTrainSubsystem extends SubsystemBase {
    

  //Initialize Motors

  //Victor
 // MotorController frontLeft= new WPI_VictorSPX(1);
  //MotorController backLeft= new WPI_VictorSPX(2);
  //MotorController frontRight= new WPI_VictorSPX(3);
  //MotorController backRight= new WPI_VictorSPX(4);


  //NEO
  CANSparkMax frontLeft = new CANSparkMax(OperatorConstants.frontLeft, MotorType.kBrushless);
  CANSparkMax backLeft = new CANSparkMax(OperatorConstants.backLeft, MotorType.kBrushless);
  CANSparkMax frontRight= new CANSparkMax(OperatorConstants.frontRight, MotorType.kBrushless);
  CANSparkMax backRight= new CANSparkMax(OperatorConstants.backRight, MotorType.kBrushless);


  DifferentialDrive drive;

  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;    

  double speed;

  public DriveTrainSubsystem(){

    //Config Motors

    // frontLeft.setInverted(true);
    //backLeft.setInverted(false);

    //Neo
    frontLeft.setIdleMode(IdleMode.kBrake); 

    //Usar só depois de explicar arcade drive

    leftMotors = new MotorControllerGroup(frontLeft,backLeft);
    rightMotors = new MotorControllerGroup(frontRight,backRight);
    
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }


  public void driveWithJoystick(Joystick joystick, double speed){
    
    drive.arcadeDrive(joystick.getRawAxis(OperatorConstants.yAxisJoystick)*speed,
                            joystick.getRawAxis(OperatorConstants.xAxisJoystick)*speed);
    this.speed =speed;
  }

  public void driveForward(double speed){
    drive.tankDrive(speed, speed);
  }

  public void driveBack(double speed){
    drive.tankDrive(-speed, -speed);
  }

  public void driveLeft(double speed){
    drive.tankDrive(-speed, speed);
  }

  public void driveRight(double speed){
    drive.tankDrive(speed, -speed);
  }

  public void stop(){
    drive.stopMotor();
  }

  @Override
  public void periodic(){
    SmartDashboard.putNumber("Speed DriveTrain", speed);
  }
}
