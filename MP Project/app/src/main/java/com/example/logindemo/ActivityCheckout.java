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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class ActivityCheckout extends AppCompatActivity {

    private TextView checkIn, checkOut, totalPrice, table1,table2,table3;
    private FloatingActionButton btnConfirm;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkIn = findViewById(R.id.checkin);
        checkOut = findViewById(R.id.checkout);
      //  roomNum = findViewById(R.id.checkoutRoomNumber);
        totalPrice = findViewById(R.id.tvTotalPrice);
        table1 = findViewById(R.id.table1);
        table2 = findViewById(R.id.table2);
        table3 = findViewById(R.id.table3);
      //  quadQ = findViewById(R.id.quadQ);
        btnConfirm = findViewById(R.id.btnConfirm);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("ClassBooking").child("booking1");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String checkin = dataSnapshot.child("checkindate").getValue().toString();
                checkIn.setText(checkin);
                String checkout = dataSnapshot.child("checkoutdate").getValue().toString();
                checkOut.setText(checkout);
                String Q1 = "Quantity: " + Integer.valueOf(dataSnapshot.child("wedding").getValue().toString());
                table1.setText(Q1);
                String Q2 = "Quantity: " + Integer.valueOf(dataSnapshot.child("birthday").getValue().toString());
                table2.setText(Q2);
                String Q3 = "Quantity: " + Integer.valueOf(dataSnapshot.child("special").getValue().toString());
                table3.setText(Q3);

                ClassBooking classBooking = dataSnapshot.getValue(ClassBooking.class);
                double weddingPrice = 125.00, birthdayPrice = 132.00 ,specialPrice = 150.00 ;

                double totalWeddingPrice = weddingPrice * classBooking.getWedding();
                double totalBirthdayPrice = birthdayPrice * classBooking.getBirthday();
                double totalSpecialPrice = specialPrice * classBooking.getSpecial();

                final double totalAll = totalWeddingPrice + totalBirthdayPrice + totalSpecialPrice ;

                totalPrice.setText("Total RM" +String.format("%.2f",totalAll));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ActivityCheckout.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityCheckout.this, ActivityReceipt.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.profileMenu: {
                startActivity(new Intent(ActivityCheckout.this, ProfileActivity.class));
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
        startActivity(new Intent(ActivityCheckout.this, MainActivity.class));
    }
}
