package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
  binding.btnSend.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                  AppDatabase.class, "room_db").allowMainThreadQueries().build();
          UserDao userDao = db.userDao();
          Boolean check=userDao.is_exists(Integer.parseInt(binding.etID.getText().toString()));
          if(check==false) {
              userDao.insertAll
                      (new User(Integer.parseInt(binding.etID.getText().toString()),
                      binding.etOne.getText().toString(),
                      binding.etSecond.getText().toString()));
              binding.etID.setText("");
              binding.etOne.setText("");
              binding.etSecond.setText("");
              binding.tvResult.setText("Inserted Successfully");
          }
          else
          {
              binding.etID.setText("");
              binding.etOne.setText("");
              binding.etSecond.setText("");
              binding.tvResult.setText("Record is existing");
          }
      }
  });}
}