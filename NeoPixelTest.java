package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.Random;

@Autonomous
@Config
public class NeoPixelTest extends LinearOpMode {
    public static int NUM_PIXELS = 16;

    @Override
    public void runOpMode() throws InterruptedException {
        NeoPixelDriverDevice dev = hardwareMap.get(NeoPixelDriverDevice.class, "neopixel_driver");

        NeoPixelDriverDevice.Params p = new NeoPixelDriverDevice.Params();
        p.numPixels = NUM_PIXELS;
        dev.initialize(p);

        byte[] pixArray = new byte[p.getNumBytes()];

        Random rng = new Random();

        waitForStart();

        while (opModeIsActive()) {
            rng.nextBytes(pixArray);
            dev.showColors(pixArray);
        }
    }
}
