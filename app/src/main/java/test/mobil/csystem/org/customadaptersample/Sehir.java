package test.mobil.csystem.org.customadaptersample;

/**
 * Created by aykut on 12.3.2015.
 */
public class Sehir
{
    private String isim;
    private int gorsel;
    private long plaka;

    public Sehir(String isim, int gorsel, long plaka)
    {
        this.isim = isim;
        this.gorsel = gorsel;
        this.plaka = plaka;

    }

    public String getIsim()
    {
        return isim;
    }

    public void setIsim(String isim)
    {
        this.isim = isim;
    }

    public int getGorsel()
    {
        return gorsel;
    }

    public void setGorsel(int gorsel)
    {
        this.gorsel = gorsel;
    }

    public long getPlaka()
    {
        return plaka;
    }

    public void setPlaka(long plaka)
    {
        this.plaka = plaka;
    }
}
