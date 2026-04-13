//courtosy of macus
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class aura extends LinearOpMode {
    
    @Override
    public void runOpMode() throws InterruptedException {
        // declare and configure motors
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("FL");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("BL");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("FR");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("BR");
       
        
        
        //reverse some motors
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        
        
        

        waitForStart();

        if (isStopRequested()) return;
        
        
        //main loop
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;
            
            double shoot = 0;
            double servoPosition = 0;
            double motorOffVariable = 0;
            
            //initialize servo
            
            
            
            //shoot buttons initialize
            boolean b = gamepad2.b;
            boolean a = gamepad2.a;
            boolean c = gamepad2.x;
            boolean yy = gamepad2.y;
            
            //independent shooter motor buttons initialize
            double LeftStick = gamepad2.left_stick_x;
            double RightStick = gamepad2.right_stick_x;
            
            //setting shoot speeds to the buttons
            if (b == true){
                shoot = 1;
                motorOffVariable = 1;
                
            } else if (b == false && c == false && a == false) {
                shoot = 0;
            }
            
            if (a == true){
                shoot = 0.9;
                motorOffVariable = 1;
            } else if (b == false && c == false && a == false) {
                shoot = 0;
            }
            
            if (c == true){
                shoot = 0.8;
            } else if (b == false && c == false && a == false){
                shoot = 0;
            }
            
            if (yy == true){
                servoPosition = 0.20;
            } else {
                servoPosition = 0.90;
            }
            
            //wheel power calculations
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

           

            //set the motor power
            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
            
            
            
        }
    }
}
 
