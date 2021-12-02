package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous

public class Auto_Red_Left_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(true);


        waitForStart();
        this.sense_barcode();

        auto_motors.strafeLeft(1,4);
        auto_motors.goToSpot((int) (-inchToTicks*12.5), 1);
        auto_carousel.run_carousel_auto(telemetry,true);
        auto_motors.strafeLeft(1, 10);
        auto_motors.goToSpot(-inchToTicks*7,1);
        auto_motors.strafeLeft(1, 17);







        while (opModeIsActive()) {
            Thread.sleep(1);
        }

    }
}