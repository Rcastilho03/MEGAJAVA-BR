package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class ElevadorSubsystem extends SubsystemBase {
    
    //Initialize Motors

    //Victor
    //MotorController leftMotor;
    //MotorControler rightMotor;

    CANSparkMax leftMotor;
    CANSparkMax rightMotor;

    MotorControllerGroup elevatorMotors;

    double speed;

    public ElevadorSubsystem(){

        //Victor
        //leftMotor = new WPI_VictorSPX(OperatorConstants.elevadorLeft);
        //rightMotor = new WPI_VictorSPX(OperatorConstants.elevadorRight);

        leftMotor = new CANSparkMax(OperatorConstants.elevadorLeft, MotorType.kBrushless);
        rightMotor = new CANSparkMax(OperatorConstants.elevadorRight, MotorType.kBrushless);

        leftMotor.setInverted(false);
        rightMotor.setInverted(false);

        elevatorMotors = new MotorControllerGroup(leftMotor,rightMotor);
    }

    public void elevatorWithJoystick(Joystick joystick, double speed){
        elevatorMotors.set(joystick.getRawAxis(OperatorConstants.elevatorAxis)*speed);

        this.speed = speed;
    }

    public void stop(){
        elevatorMotors.stopMotor();
    }
}
