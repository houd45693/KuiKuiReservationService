package com.example.logindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ActivityReceipt extends AppCompatActivity {

    private TextView receipt,totalPrice;
            //bookingNumber;
    private Button backHome;
    private FirebaseDatabase firebaseDatabase;

    private DatabaseReference databaseReference;
    private TextView randomNumber;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        receipt = findViewById(R.id.tvDateReceipt);
        //bookingNumber = findViewById(R.id.bookingNumber);
        backHome = findViewById(R.id.btnHome);
        totalPrice = findViewById(R.id.tvTotalPrice);
        randomNumber = findViewById(R.id.randomNumber);


        Random r = new Random();
        int minNumber = 10000;
        int maxNumber = 100000;
        int random = r.nextInt((maxNumber - minNumber) + 1) + minNumber;
        randomNumber.setText(String.valueOf(random));

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = sdf.format(new Date());
        receipt.setText(currentDate);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("ClassBooking").child("booking1");


        final ValueEventListener valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClassBooking classBooking = dataSnapshot.getValue(ClassBooking.class);
                double weddingPrice = 125.00, birthdayPrice = 132.00, specialPrice = 150.00;

                double totalWeddingPrice = weddingPrice * classBooking.getWedding();
                double totalBirthdayPrice = birthdayPrice * classBooking.getBirthday();
                double totalSpecialPrice = specialPrice * classBooking.getSpecial();

                final double totalAll = totalWeddingPrice + totalBirthdayPrice + totalSpecialPrice;

                totalPrice.setText("Total: RM" + String.format("%.2f", totalAll));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ActivityReceipt.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });


        backHome.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                startActivity(new Intent(ActivityReceipt.this, MainActivity.class));
            }
            });
        };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.profileMenu: {
                startActivity(new Intent(ActivityReceipt.this, ProfileActivity.class));
                break;
            }

            case R.id.logoutMenu:{
                Logout();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(ActivityReceipt.this, MainActivity.class));
    }
}