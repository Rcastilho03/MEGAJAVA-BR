package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class PunhoSubsystem extends SubsystemBase {
    //Victor
    //MotorController motorPunho;
    
    CANSparkMax motorPunho;
    double speed;

    public PunhoSubsystem(){
        //Victor
        //motorPunho = new WPI_VictorSPX(OperatorConstants.punhoMotor);

        motorPunho = new CANSparkMax(OperatorConstants.punhoMotor,MotorType.kBrushless);

        motorPunho.setInverted(false);
    }

    public void punhoWithJoystick(Joystick joystick, double speed){
        motorPunho.set(joystick.getRawAxis(OperatorConstants.telescopioAxis)*speed);

        this.speed = speed;
    }

    public void stop(){
        motorPunho.stopMotor();
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("SpeedPunho", speed);
    }
}
