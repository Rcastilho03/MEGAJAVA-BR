// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int frontLeft = 1;
    public static final int backLeft = 2;
    public static final int frontRight = 3;
    public static final int backRight = 4;

    public static final int kDriverControllerPort = 0;
    public static final int yAxisJoystick = 1;
    public static final int xAxisJoystick = 4;

    public static final int kOperatorControllerPort = 1;
    public static final int elevatorAxis = 5;
    public static final int telescopioAxis = 1;
    public static final int punhoAxis = 0;

    public static final int elevadorLeft = 5;
    public static final int elevadorRight = 6;
    
    public static final int telescopioMotor = 7;
    public static final int punhoMotor = 8;

    public static final int pcmId = 11;
    public static final int forwardGarras = 0;
    public static final int reverseGarra = 1;


    public static final double SpeedElevador = 0.7;
    public static final double SpeedTelescopio = 0.7;
    public static final double SpeedPunho = 0.7;

  }
}
