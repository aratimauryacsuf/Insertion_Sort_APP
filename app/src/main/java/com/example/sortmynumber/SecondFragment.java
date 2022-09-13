package com.example.sortmynumber;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sortmynumber.databinding.FragmentSecondBinding;

import java.util.Arrays;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }

        });
        binding.sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }

            public void sendMessage(View view) {
                // Do something in response to button
                // Intent intent = new Intent(this, DisplayMessageActivity.class);
                EditText editText = (EditText) getView().findViewById(R.id.editTextTextPersonName);
                TextView textView1 = getView().findViewById(R.id.textView1);
                // TextView myTextView = null;
                // TextView myTextView = findViewById(R.id.textView);

                try {
                    String myString = editText.getText().toString();
                    String[] myStringList = myString.split(" ");
                    int[] numberList = new int[myStringList.length];
                    for (int i = 0; i < myStringList.length; i++) {
                        numberList[i] = Integer.parseInt(myStringList[i]);
                    }
                    String finalString = Arrays.toString(numberList).replaceAll("\\[|\\]|,|\\s", " ");
                    int size = numberList.length;
                    for (int i = 1; i < size; i++) {
                        // finalString = Arrays.toString(numberList);

                        int keyNum = numberList[i];
                        int j = i - 1;

                        while (j >= 0 && numberList[j] > keyNum) {
                            numberList[j + 1] = numberList[j];
                            j = j - 1;
                        }
                        numberList[j + 1] = keyNum;
                        finalString = finalString + "\n" + Arrays.toString(numberList).replaceAll("\\[|\\]|,|\\s", " ");
                    }

//            String[] sortedString = new String[numberList.length];
//            for (int i = 0; i < numberList.length; i++) {
//                sortedString[i] = String.valueOf(numberList[i]);
//            }

                    //String finalString = String.join(" ", sortedString);
//            String finalString = Arrays.toString(numberList);
//            finalString = finalString + "\n" + "1 2 3";
                    textView1.setText(finalString);
                    // intent.putExtra(EXTRA_MESSAGE,finalString);
                    //  startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // myTextView = myTextView.setText(finalString);
                //String message = myTextView.getText().toString();

            }


        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}