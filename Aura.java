
//courtosy of macus
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
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
        DcMotor intakeMotor = hardwareMap.dcMotor.get("IM");
        DcMotor leftShooterMotor = hardwareMap.dcMotor.get("S1");
        DcMotor rightShooterMotor = hardwareMap.dcMotor.get("S2");
        Servo stopper = hardwareMap.servo.get("COCK(blocker)");
        
        CRServo BRS = hardwareMap.crservo.get("BRS");
        CRServo BLS = hardwareMap.crservo.get("BLS");
        CRServo FRS = hardwareMap.crservo.get("FRS");
        CRServo FLS = hardwareMap.crservo.get("FLS");
        
        
        //reverse some motors
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        
        rightShooterMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        
        BLS.setDirection(DcMotorSimple.Direction.REVERSE);
        FLS.setDirection(DcMotorSimple.Direction.REVERSE);
        
        
        

        waitForStart();

        if (isStopRequested()) return;
        
        
        //main loop
        while (opModeIsActive()) {
            
            //movement variables
            //driving
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;
            
            //interior servos
            double bleh = gamepad2.left_stick_x;
            
            //intake
            double aa = gamepad1.right_trigger;
            
            //shooting
            boolean xbutton = gamepad2.x;
            boolean enable_shooter = gamepad2.a;
            boolean b = gamepad2.b;
            
            //c block
            boolean yy = gamepad2.y;
            
            
            
            //other variables
            double power = 0;
            double intakePower = 0;
            int servoPosition = -50;
            
            
            
            
            //wheel power calculations
            // Divides the 
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;
            
            double interiorPower = bleh;
            
            //setting power based on input
            if (xbutton){
                power = 0.5;
            } else if (enable_shooter){
                power = 0.65;
            } else if (b){
                power = 0.75;
            }
            
            if (yy){
                servoPosition = 50;
            }
            
            if (aa > 0){
                intakePower = 1;
            }

            //set the motor power
            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
            
            BRS.setPower(interiorPower);
            BLS.setPower(interiorPower);
            FRS.setPower(interiorPower);
            FLS.setPower(interiorPower);
            
            leftShooterMotor.setPower(power);
            rightShooterMotor.setPower(power);
            stopper.setPosition(servoPosition); 
            intakeMotor.setPower(intakePower);
        }
    }
}
