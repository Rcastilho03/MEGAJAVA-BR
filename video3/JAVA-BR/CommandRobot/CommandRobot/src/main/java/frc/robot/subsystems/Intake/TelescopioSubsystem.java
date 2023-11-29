package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class TelescopioSubsystem extends SubsystemBase {
    
    //Initialize Motors

    //VictorSPX
    //MotorController telescopeMotor;

    CANSparkMax motorTelescopio;

    double speed;

    public TelescopioSubsystem(){
        
        //VictorSPX
        //motorTelescopio = new WPI_VictorSPX(OperatorConstants.telescopioMotor);

        motorTelescopio = new CANSparkMax(OperatorConstants.telescopioMotor, MotorType.kBrushless);

        motorTelescopio.setInverted(false);
    }

    public void telescopiWithJoystick(Joystick joystick, double speed){
        motorTelescopio.set(joystick.getRawAxis(OperatorConstants.telescopioAxis)*speed);
        this.speed = speed;
    }

    public void stop(){
        motorTelescopio.stopMotor();
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Speed Telescopio", speed);
    }
}
