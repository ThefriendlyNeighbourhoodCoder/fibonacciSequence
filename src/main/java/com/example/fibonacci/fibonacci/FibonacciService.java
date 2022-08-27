package com.example.fibonacci.fibonacci;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FibonacciService {
    public ArrayList<Integer> getNumbersAfter(Integer first, Integer second) {
        ArrayList<Integer> sequence = new ArrayList<>();
        sequence.add(first);
        sequence.add(second);
        for (int i = 0; i < 10; i++) {
            sequence.add(first + second);
            first = second;
            second = sequence.get(sequence.size() - 1);
        }
        return sequence;
    }
}