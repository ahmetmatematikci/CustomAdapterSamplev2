package test.mobil.csystem.org.customadaptersample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
{
    private ListView lstCities;
    private Container container;
    private CustomAdapter adp;

    String[] sayfalar = {"gecis", "deneme"};

    private void init()
    {
        lstCities = new ListView(this);
        container = new Container();
        adp = new CustomAdapter(this, container);
    }

    private void BindData()
    {
        lstCities.setAdapter(adp);
    }

    private void lstCities_ItemClick()
    {
        lstCities.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        // LinearLayout lay = (LinearLayout) lstCities.getChildAt(position);
                        LinearLayout lay = (LinearLayout) view;
                        TextView txtIsim = (TextView) lay.findViewById(R.id.txtIsim);
                        MainActivity.this.setTitle("Seçilen : " + txtIsim.getText());

                        //Bu kısım kitapta yok. Custom view de sayfaya tıklandığında  başka aktivitiye gitmesi eklendi
                        String sayfa = sayfalar[position];
                        Class gis;
                        try{
                            gis = Class.forName("test.mobil.csystem.org.customadaptersample." + sayfa);
                            Intent i = new Intent(MainActivity.this, gis);
                            startActivity(i);
                        }catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }


                        //new Vibrasyon(MainActivity.this).Titrestir();//açılırsa eklenti de titreşim çıkacak
                    }
                }


        );
    }


        private void registerHandlers()
        {
            lstCities_ItemClick();
            // ...
        }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        init();
        setContentView(lstCities);
        BindData();
        registerHandlers();
    }
}
