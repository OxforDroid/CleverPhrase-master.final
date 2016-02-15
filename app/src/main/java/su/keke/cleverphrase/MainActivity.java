package su.keke.cleverphrase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bildRandom(textView);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            share(textView );
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.random) {

            bildRandom(textView);//начальный экран генерация случайной фразы

        } else if (id == R.id.otvet) {
            Intent intent = new Intent(MainActivity.this, TexGen.class);
            startActivity(intent);


        } else if (id == R.id.vopros) {
            Intent intent = new Intent(MainActivity.this, VoprosAkt.class);
            startActivity(intent);

        } else if (id == R.id.filosofiy) {
            Intent intent = new Intent(MainActivity.this, FilosofAkt.class);
            startActivity(intent);

        }
        else if (id == R.id.fizika) {
            Intent intent = new Intent(MainActivity.this, FizikAkt.class);
            startActivity(intent);

        }
        else if (id == R.id.matematika) {
            Intent intent = new Intent(MainActivity.this, MatemAkt.class);
            startActivity(intent);

        }
        else if (id == R.id.psifologiy) {
            Intent intent = new Intent(MainActivity.this, PsixAkt.class);
            startActivity(intent);

        }
        else if (id == R.id.info) {
            Intent intent = new Intent(MainActivity.this, Info.class);
            startActivity(intent);

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void share (TextView view)
    {
        String str = textView.getText().toString();
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");

        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Я думаю что ");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, str);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void bildRandom (View view){

        String[]gum_list = getResources().getStringArray(R.array.all_list);
// Вычисляем, сколько слов в каждом списке
        int gumLength = gum_list.length;
//Генерируем случайное число
        int randl = (int) (Math.random() * gumLength);
//Теперь строим фразу
        String phrase =  gum_list[randl];
        textView.setText("");//очищаем поле
        textView.setText(phrase);//вставляем фразу
    }
}
