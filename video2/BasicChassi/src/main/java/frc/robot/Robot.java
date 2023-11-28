
package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {
  //Initialize Motors

  //NEO
  CANSparkMax frontLeft = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax backLeft = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax frontRight= new CANSparkMax(3, MotorType.kBrushless);
  CANSparkMax backRight= new CANSparkMax(4, MotorType.kBrushless);

  //Victor
  //MotorController frontLeft= new WPI_VictorSPX(1);
  //MotorController backLeft= new WPI_VictorSPX(2);
  //MotorController frontRight= new WPI_VictorSPX(3);
  //MotorController backRight= new WPI_VictorSPX(4);


  double startTime;

  //Joystick
  Joystick xBoxController  = new Joystick(0);

  //Usar só dps de explicar arcade Drive
  DifferentialDrive drive;

  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  @Override
  public void robotInit() {

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

  @Override
  public void robotPeriodic() {}

 
  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }


  @Override
  public void autonomousPeriodic() {

        double time = Timer.getFPGATimestamp();
      
        if(time - startTime < 3){      
        frontLeft.set(0.6);
        backLeft.set(0.6);
        frontRight.set(-0.6);
        backRight.set(-0.6);
        }
        else{
        frontLeft.set(0);
        backLeft.set(0);
        frontRight.set(0);
        backRight.set(0);
        }
    }

  @Override
  public void teleopInit() {}

 
  @Override
  public void teleopPeriodic() {
    double speed = xBoxController.getRawAxis(1);
    double turn = xBoxController.getRawAxis(4);

    double left = speed + turn;
    double right = speed - turn;
    
    frontLeft.set(left);
    backLeft.set(left);
    frontRight.set(-right);
    backRight.set(-right);

    drive.arcadeDrive(speed, turn);

  }
  @Override
  public void disabledInit() {}


  @Override
  public void disabledPeriodic() {}


  @Override
  public void testInit() {}


  @Override
  public void testPeriodic() {}


  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
