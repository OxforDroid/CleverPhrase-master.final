package su.keke.cleverphrase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class VoprosAkt extends AppCompatActivity {
    private TextView mTextViewtex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vopros_akt);
        mTextViewtex = (TextView)findViewById(R.id.tvvopros);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);//генератор
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                share(mTextViewtex);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);//генератор
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bildGum(mTextViewtex);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void bildGum (View view){

        String[]gum_list = getResources().getStringArray(R.array.voproskorot);
// Вычисляем, сколько слов в каждом списке
        int gumLength = gum_list.length;
//Генерируем случайное число
        int randl = (int) (Math.random() * gumLength);
//Теперь строим фразу
        String phrase =  gum_list[randl];
        mTextViewtex.setText("");//очищаем поле
        mTextViewtex.setText(phrase);//вставляем фразу
    }

    public void share (TextView view)
    {
        String str = mTextViewtex.getText().toString();
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");

        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Я думаю что ");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, str);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void onclk(View view) {
        share(mTextViewtex);
    }
}