package com.fillipe.tcc2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Janela1 extends AppCompatActivity {

    private int posicao=0;


    private ImageView imagem;

    private ImageView imagem2;

    private ImageView imagem3;

    private ImageView imagem4;

    private final int GALERIA_IMAGENS=3;

    private final int PermissionRequest=2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janela1);

        imagem = (ImageView) findViewById(R.id.imageView);
        imagem2 = (ImageView) findViewById(R.id.imageView2);
        imagem3 = (ImageView) findViewById(R.id.imageView3);
        imagem4= (ImageView) findViewById(R.id.imageView4);

        Button galeria1 = (Button) findViewById(R.id.brincar);
        Button galeria2 = (Button) findViewById(R.id.brinquedo);
        Button galeria3 = (Button) findViewById(R.id.comer);
        Button galeria4 = (Button) findViewById(R.id.pessoal);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE))
            {

            }else
            {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PermissionRequest);
            }

        }

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);


        }

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        !=PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);

        }


        galeria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galerias =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galerias, GALERIA_IMAGENS);
                posicao=1;

            }
        });
        galeria2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galerias =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galerias, GALERIA_IMAGENS);
                posicao=2;

            }
        });
        galeria3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galerias =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galerias, GALERIA_IMAGENS);
                posicao=3;

            }
        });
        galeria4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galerias =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galerias, GALERIA_IMAGENS);
                posicao=4;

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== RESULT_OK && requestCode== GALERIA_IMAGENS)
        {

            Uri selecinarimagem = data.getData();
            String[] filePath= {MediaStore.Images.Media.DATA};
            Cursor c =getContentResolver().query(selecinarimagem, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex= c.getColumnIndex(filePath[0]);
            String picturePath= c.getString(columnIndex);
            c.close();
            Bitmap imagemGaleria= (BitmapFactory.decodeFile(picturePath));

            if (posicao==1)
            {
                imagem.setImageBitmap(imagemGaleria);
            }
            if (posicao==2)
            {
                imagem2.setImageBitmap(imagemGaleria);
            }
            if (posicao==3)
            {
                imagem4.setImageBitmap(imagemGaleria);
            }
            if (posicao==4)
            {
                imagem3.setImageBitmap(imagemGaleria);
            }



        }

    }


    public void irpagina2( View view)
    {
        Intent muda = new Intent(this, Janela2.class);
        startActivity(muda);
        finish();


    }





}
