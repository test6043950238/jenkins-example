package com.techprimers.testing;

import java.io.FileNotFoundException;

public class FizzBuzz {

    public String play(int number) {

        if (number == 0) {
			throw new IllegalArgumentException("Number must not be 0");
		}
		if (number == 0) {
			throw new IllegalArgumentException("Number must not be 0");
		}
        if (number % 3 == 0) {
			return "Fizz";
		}
        if (number % 5 == 0) {
			return "Buzz";
		}
		if (number % 7 == 0) {
			return "Gizz";
		}

        return String.valueOf(number);
    }
	
	void bar() {
        try {
            bar();
        } catch (FileNotFoundException e) {}
    }
}
