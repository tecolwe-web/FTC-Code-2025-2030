//courtosy of maxus

//HOW TO USE A COLOR SENSOR
//this code shows how to use specifically a rev color sensor v3
//a color sensor must be plugged into the 12C slot in the control hub

//the range of the rev color sensor v3 is only about half a foot
//it uses rgb and has a built in distance sensor
//it will return an integer value for green, blue, and red
//you can use if statements to compare the number values and determine the color



//this example code will drive the bot forward if it detects red, and back for blue


//-------------------------------------------------------------------------------//
//import all the things
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


//declare auto
@Autonomous

//declare the class
public class howToUseAColorSensor extends LinearOpMode {

    //declare the opmode that can be interrupted
     @Override
    public void runOpMode() throws InterruptedException {
        
        
        
        //declare our auraful motors
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("FL");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("BL");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("FR");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("BR");
        
        //declare our color sensor
        ColorSensor auraColorSensor = hardwareMap.colorSensor.get("CO");
        
        //set our color sensor variables
        int red = auraColorSensor.red();
        int blue = auraColorSensor.blue();
        
        //reverse all them motors
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        
        
        //wait for the start
        waitForStart();
        
        //wait 2 seconds before everything starts
        sleep(2000);
        while (opModeIsActive()) {
            //set color sensor data to variables
            red = auraColorSensor.red();
            blue = auraColorSensor.blue();
            
            //send color sensor data to drive station
            telemetry.addData("r", red);
            telemetry.addData("b", blue);
            
            //recieve it
            telemetry.update();
            
            //if it detects red
            if (red > blue)  {
                frontLeftMotor.setPower(0.5);
                backLeftMotor.setPower(0.5);
                frontRightMotor.setPower(0.5);
                backRightMotor.setPower(0.5);
            //if it detects blue
            } else {
                frontLeftMotor.setPower(-0.5);
                backLeftMotor.setPower(-0.5);
                frontRightMotor.setPower(-0.5);
                backRightMotor.setPower(-0.5);
            }
            //break out of the loop to continue to the rest of the code
            break;
        }
        
        //wait for 300 ms before turning off motors
        sleep(300);
        
        //turn off motors
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
        
        
    }
}


