package com.example.bettermath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bettermath.databinding.ActivityAdditionBinding;
import com.example.bettermath.databinding.ActivityMainBinding;

import java.util.Random;

public class AdditionActivity extends AppCompatActivity {

    private ActivityAdditionBinding binding;
    Random rand = new Random();
    private int answer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdditionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        newGame();

        binding.checkAnswer.setOnClickListener(v -> calculate());

        binding.nextQuestion.setOnClickListener(v -> newGame());

    }

    private void calculate() {
        String usrAns = binding.usrAnswer.getText().toString();

        if (usrAns.isEmpty()) {
            Toast.makeText(this, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        int usrAnswer = Integer.parseInt(usrAns);
        if (usrAnswer == answer) {
            binding.result.setText("정답!");
        } else {
            binding.result.setText(String.format("정답은 %d입니다", answer));
        }
    }

    private void newGame() {
        int num1 = rand.nextInt(101), num2 = rand.nextInt(101);

        binding.question.setText(String.format("%d + %d =", num1, num2));

        binding.result.setText("");

        binding.usrAnswer.setText("");

        answer = num1 + num2;
    }
}