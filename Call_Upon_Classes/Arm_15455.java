package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Base64;


public class Arm_15455{
    private DcMotor arm = null;
    private double speed;

    public void init_arm(HardwareMap map, String name) {
        arm  = map.get(DcMotor.class, name);
    }

    public void run_arm(Gamepad gamepad1, Telemetry telemetry) {
        double pos = arm.getCurrentPosition()/22.7%360;
        boolean dpad_up = gamepad1.dpad_up;
        boolean dpad_down = gamepad1.dpad_down;

        if (dpad_up && pos<=77) {
            speed = 1;
        } else if (dpad_down&&pos>=1) {
            speed = -1;
        } else {
            speed = 0;
        }

        arm.setPower(speed);

        get_telemetry(telemetry);
    }

    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("encoder", arm.getCurrentPosition()/22.7%360);
        telemetry.addData("Arm Speed", speed);
    }

    public void autoArm (int pos){
        if (pos==1) {}
        if (pos==2) {}
        if (pos==3) {}
    }









}
