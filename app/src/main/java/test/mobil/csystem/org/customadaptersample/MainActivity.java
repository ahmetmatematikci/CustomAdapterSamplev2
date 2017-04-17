package test.mobil.csystem.org.customadaptersample;

import android.content.Context;
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

                        new Vibrasyon(MainActivity.this).Titrestir();
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
