package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class JokesProvider {
    private List<String> jokes;
    private static Random random;

    static {
        random = new Random();
    }

    public JokesProvider() {
        jokes = new ArrayList<>();
        jokes.add("The box said ‘Requires Windows Vista or better’. So I installed LINUX");
        jokes.add("Bugs come in through open Windows");
        jokes.add("If at first you didn’t succeed, Call it version 1.0");
    }


    public String getJoke() {
        return jokes.get(random.nextInt(2));
    }
}
