package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Mecanum_Methods {

    private boolean strafe;
    private int strafe_set=1;

    //right == 1
    //left  == -1
    private double denominator;
    private double ly;
    private double lx;
    private double rx;
    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;

    /**
     *
     * @param right_strafe if you want right strafe set true, left set false
     */
    public Mecanum_Methods(boolean right_strafe){
    strafe=right_strafe;
    if (strafe)
        strafe_set = 1;
    else
        strafe_set = -1;

    }
    public void init_drive_motors(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);
    }

    public void run_drive_motors(Gamepad gamepad1, Telemetry telemetry){
        ly=gamepad1.left_stick_y;
        lx=gamepad1.left_stick_x;
        rx=gamepad1.right_stick_x;
        denominator = Math.abs(ly)+Math.abs(lx)+Math.abs(rx);

        fl.setPower((ly+lx+rx)/denominator);
        bl.setPower((ly+lx*strafe_set-rx*strafe_set)/denominator);
        fr.setPower((ly-lx-rx)/denominator);
        br.setPower((ly-lx*strafe_set+rx*strafe_set)/denominator);

        telemetry.addData("fl power: ",fl.getPower());
        telemetry.addData("fr power: ",fr.getPower());
        telemetry.addData("bl power: ",bl.getPower());
        telemetry.addData("br power: ",br.getPower());
        telemetry.update();

    }


}
