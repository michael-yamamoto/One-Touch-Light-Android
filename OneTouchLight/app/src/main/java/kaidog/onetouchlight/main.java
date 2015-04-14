package kaidog.onetouchlight;


import android.app.Activity;
import android.os.Bundle;


/**
 * Created by michael yamamoto on 4/13/2015.
 */
public class main extends Activity {
    //camera flash is part of camera class
    android.hardware.Camera cam;
    android.hardware.Camera.Parameters p;

    //flashlight state, true = on
    boolean flashOn;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        flashOn = false;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume()
    {
        super.onResume();

        powerToggle();

        //minimize blank app screen on startup/resume
        moveTaskToBack(true);
    }

    @Override
    public void onPause()
    {
        super.onPause();

    }

    public void powerToggle()
    {
        if(flashOn)
        {
            powerOff();
            flashOn = false;
        }
        else
        {
            powerOn();
            flashOn = true;
        }

    }

    public void powerOn()
    {
        cam = android.hardware.Camera.open();
        p = cam.getParameters();
        p.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
        cam.setParameters(p);
        cam.startPreview();
    }

    public void powerOff()
    {
        cam.release();
    }
}
