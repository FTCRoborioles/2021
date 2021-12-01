package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turntable_15455 {
    private CRServo turntable = null;
    private DcMotor TTEncoder = null;
    private Telemetry telemetry = null;

    public void init_turntable(HardwareMap map, Telemetry telemetry, String name) {
        turntable = map.get(CRServo.class, name);
        TTEncoder = map.get(DcMotor.class, name);
        this.telemetry = telemetry;
    }

    public void run_turntable(Gamepad gamepad1, Telemetry telemetry) {
        double turn_right = gamepad1.right_trigger;
        double turn_left = gamepad1.left_trigger;

        if (turn_left>0&&TTEncoder.getCurrentPosition()>-8000*5) {
            turntable.setPower( -turn_left*.88);
        } else if (turn_right>0&&TTEncoder.getCurrentPosition()<8000*5) {
            turntable.setPower( turn_right*.88);
        } else {
            turntable.setPower(0);
        }

        get_telemetry(telemetry);
    }

    public void turntable_auto (int deg, double power) {
        turntable.setPower(power * .88);
        while (TTEncoder.getCurrentPosition()<deg*(8000/360)) {
            this.get_telemetry(telemetry);
        }
        turntable.setPower(0);
    }



    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("turntable power", turntable.getPower());
        telemetry.addData("turntable current pos", TTEncoder.getCurrentPosition());
    }













}
