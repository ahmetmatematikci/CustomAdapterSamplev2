package test.mobil.csystem.org.customadaptersample;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by aykut on 12.3.2015.
 */
public class CustomAdapter extends BaseAdapter
{
    private Context context;
    private Container model;

    public CustomAdapter(Context context, Container model)
    {
        this.context = context;
        this.model = model;
    }

    @Override
    public int getCount()
    {
        // kolleksiyon içerisindeki nesne sayısı return ediliyor
        return model.getVector().size();
    }

    @Override
    public Object getItem(int position)
    {
        // indeks bilgisine göre nesnenin kolleksiyondan alınması
        return model.getVector().get(position);
    }

    @Override
    public long getItemId(int position)
    {
        // indeks bilgisine göre plaka kodunun kolleksiyondan alınması
        // ve niteleyici bilgi olarak return edilmesi
        return ((Sehir) this.getItem(position)).getPlaka();
    }

    // Dekleratif
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // O an üzerinde çalışılan nesne, kolleksiyondan elde ediliyor
        Sehir shr = (Sehir) getItem(position);

        // eleman_tasarimi.xml kullanılarak Sehir bilgilerinin görselleştirilmesi
        LayoutInflater li = ((Activity) context).getLayoutInflater();
        LinearLayout pnlItem = (LinearLayout) li.inflate(R.layout.eleman_tasarimi, null);

        // isim
        TextView txtIsim = (TextView) pnlItem.findViewById(R.id.txtIsim);
        txtIsim.setText(shr.getIsim());

        // plaka
        TextView txtPlaka = (TextView) pnlItem.findViewById(R.id.txtPlaka);
        txtPlaka.setText(String.valueOf(shr.getPlaka()));

        // görsel
        ImageView imgGorsel = (ImageView) pnlItem.findViewById(R.id.imgGorsel);
        Resources res = context.getResources();
        Drawable drw = res.getDrawable(shr.getGorsel());
        imgGorsel.setImageDrawable(drw);

        // kompoziyonun root elemanı return ediliyor
        return pnlItem;
    }

    // Programatik
    /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Sehir shr = (Sehir) getItem(position);

        LinearLayout pnlItem = new LinearLayout(context);
        pnlItem.setOrientation(LinearLayout.HORIZONTAL);

        TextView txtIsim = new TextView(context);
        txtIsim.setText(shr.getIsim());

        TextView txtPlaka = new TextView(context);
        txtPlaka.setText(String.valueOf(shr.getPlaka()));

        ImageView imgGorsel = new ImageView(context);
        Resources res = context.getResources();
        Drawable drw = res.getDrawable(shr.getGorsel());
        imgGorsel.setImageDrawable(drw);

        pnlItem.addView(imgGorsel);
        pnlItem.addView(txtIsim);
        pnlItem.addView(txtPlaka);

        return pnlItem;
    }
    */
}
