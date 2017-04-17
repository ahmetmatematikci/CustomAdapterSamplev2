package test.mobil.csystem.org.customadaptersample;

import android.content.Context;
import android.os.Vibrator;

/**
 * Created by aykut on 13.3.2015.
 */
public class Vibrasyon
{
    private Context c;

    public Vibrasyon(Context context)
    {
        c = context;
    }

    public void Titrestir()
    {
        Vibrator v = (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(2000);
    }

    public void Titrestir2()
    {
        Vibrator v = (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
        long patern[] = {1000, 1000, 500, 700, 2000, 1000};
        v.vibrate(patern, 3);
    }
}

