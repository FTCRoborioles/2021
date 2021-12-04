package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous

public class Auto_Red_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(true);

        waitForStart();

        // this.sense_barcode();

        auto_motors.strafeLeft(0.8,7);
        auto_motors.goToSpot((int) (-inchToTicks*25), .75);

        auto_carousel.run_carousel_auto(telemetry,true);

        auto_motors.strafeLeft(.75, 24);
        auto_motors.goToSpot((int) (-inchToTicks*9), .75);

        Thread.sleep(10000);
    }
}