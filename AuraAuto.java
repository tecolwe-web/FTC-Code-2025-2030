//maxus' epicly amazingly awesome auto

//import all the things
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


//declare auto
@Autonomous

//declare the class
public class redBackAuto extends LinearOpMode {

    //declare the opmode that can be interrupted
     @Override
    public void runOpMode() throws InterruptedException {
        
        
        
        //declare our auraful motors
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("FL");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("BL");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("FR");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("BR");
        DcMotor intakeMotor = hardwareMap.dcMotor.get("IM");
        DcMotor frontleftShooter = hardwareMap.dcMotor.get("S1");
        DcMotor frontrightShooter = hardwareMap.dcMotor.get("S2");
        
        //reverse all them motors
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        Servo stopper = hardwareMap.servo.get("COCK(blocker)");
        
        CRServo BRS = hardwareMap.crservo.get("BRS");
        CRServo BLS = hardwareMap.crservo.get("BLS");
        CRServo FRS = hardwareMap.crservo.get("FRS");
        CRServo FLS = hardwareMap.crservo.get("FLS");
        
        frontrightShooter.setDirection(DcMotorSimple.Direction.REVERSE);
        
        BLS.setDirection(DcMotorSimple.Direction.REVERSE);
        FLS.setDirection(DcMotorSimple.Direction.REVERSE);
        
        
        
        //wait fo thu start
        waitForStart();
        
        double shootPower = (0);

        //first auto function
        frontLeftMotor.setPower(1);
        backLeftMotor.setPower(1);
        frontRightMotor.setPower(1);
        backRightMotor.setPower(1);
 
        
         //wait for 300 ms before turning off motors
        sleep(70);
        
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
        
        sleep(1000);
        
        frontLeftMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);
        frontRightMotor.setPower(-0.5);
        backRightMotor.setPower(-0.5);
        
        shootPower = 0.57;
        
        sleep(110);
         
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
        
        frontleftShooter.setPower(shootPower);
        frontrightShooter.setPower(shootPower);
        
        intakeMotor.setPower(1);
        
        BRS.setPower(1);
        BLS.setPower(1);
        FRS.setPower(1);
        FLS.setPower(1);

        sleep(8000);
        
        stopper.setPosition(50);
        
        sleep(3000);
        
        //turn off all motors
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
        
        BRS.setPower(0);
        BLS.setPower(0);
        FRS.setPower(0);
        FLS.setPower(0);
        
        frontleftShooter.setPower(0);
        frontrightShooter.setPower(0);
    
        intakeMotor.setPower(0);

    }
    
}





        
        
    }
}
