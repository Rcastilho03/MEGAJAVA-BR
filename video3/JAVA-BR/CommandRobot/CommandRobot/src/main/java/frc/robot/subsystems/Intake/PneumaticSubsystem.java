package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class PneumaticSubsystem extends SubsystemBase {
    Compressor compressor;
    DoubleSolenoid garra;
    
    public PneumaticSubsystem(){
        compressor = new Compressor(OperatorConstants.pcmId,PneumaticsModuleType.CTREPCM);
        garra = new DoubleSolenoid(OperatorConstants.pcmId, PneumaticsModuleType.CTREPCM, 
                                  OperatorConstants.forwardGarras, OperatorConstants.reverseGarra);
    }

    public void startCompressor(){
        compressor.enableDigital();
    }

    public void openIntake(){
        garra.set(Value.kReverse);
    }

    public void closeIntake(){
        garra.set(Value.kForward);
    }
}
