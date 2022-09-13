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

import java.util.ArrayList;
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
                EditText editText = (EditText) getView().findViewById(R.id.editTextTextPersonName);
                TextView textView1 = getView().findViewById(R.id.textView1);


                try {
                    String myString = editText.getText().toString();

                    String[] myStringList = myString.split(" ");

                    ArrayList<Integer> numberArr = new ArrayList<Integer>();

                    for (int i = 0; i < myStringList.length; i++) {
                        if (!myStringList[i].equals("")) {
                            numberArr.add(Integer.parseInt(myStringList[i]));
                        }
                    }
                    Integer[] numberList = numberArr.toArray(new Integer[0]);
                    String finalString = "Input Array: " +
                            Arrays.toString(numberList).replaceAll("\\[|\\]|,|\\s", " ") + "\n"
                            + "Insertion Sort (Intermediate Steps)";
                    int size = numberList.length;
                    for (int i = 1; i < size; i++) {
                        int keyNum = numberList[i];
                        int j = i - 1;
                        while (j >= 0 && numberList[j] > keyNum) {
                            numberList[j + 1] = numberList[j];
                            j = j - 1;
                        }
                        numberList[j + 1] = keyNum;
                        finalString = finalString + "\n" + Arrays.toString(numberList).replaceAll("\\[|\\]|,|\\s", " ");
                    }
                    textView1.setText(finalString);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}