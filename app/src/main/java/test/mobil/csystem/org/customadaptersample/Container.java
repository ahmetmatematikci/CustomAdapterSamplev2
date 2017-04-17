package test.mobil.csystem.org.customadaptersample;

import java.util.Vector;

/**
 * Created by aykut on 12.3.2015.
 */
public class Container
{
    private Vector<Sehir> vector;

    public Vector<Sehir> getVector()
    {
        return vector;
    }

    public Container()
    {
        this.vector = new Vector<Sehir>(3);
        vector.add(new Sehir("BERLİN", R.drawable.berlin, 63L));
        vector.add(new Sehir("FRANKFURT", R.drawable.frankfurt, 21L));
        vector.add(new Sehir("KÖLN", R.drawable.koln, 98L));
    }
}
