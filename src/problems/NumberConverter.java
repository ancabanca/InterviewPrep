package com.github.ancabanca.interviewprep.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NumberConverter {
	private Map<Integer,String> map;
    private Set<String> supportedLanguages;
    private String languageISO;

    public NumberConverter(String languageISO) throws FileNotFoundException {
        supportedLanguages = new HashSet<String>();
        supportedLanguages.add("en"); // can be read from file / db
        if(!supportedLanguages.contains(languageISO))
            throw new UnsupportedOperationException("Number conversion not supported for language: " + languageISO);
        this.languageISO = languageISO;
        map = new HashMap<Integer,String>();
        // this can be injected through a config reader
        readFromFile("src/problems/cfg/" + languageISO + ".cfg");
    }

    public String convert(int n) {
        String s = "";

        // 1 million - 1 billion
        if(1000000 <= n && n < 1000000000) {
            s += convert(n / 1000000);
            s += " " + map.get(1000000) + " ";
            if(n % 1000000 != 0)
                s += convert(n % 1000000);
        }
        // 1 thousand - 1 million
        else if(1000 <= n && n < 1000000) {
            s += convert(n / 1000);
            s += " " + map.get(1000) + " ";
            if(n % 1000 != 0)
                s += convert(n % 1000);
        }
        else if(100 <= n && n < 1000) {
            s += convert(n / 100);
            s += " " + map.get(100) + " ";
            if(n % 100 != 0)
                s += convert(n % 100);
        }
        else if(0 <= n && n < 100) {
            if(0 <= n && n <= 20)
                s += map.get(n);
            else {
                s += map.get(n/10 * 10);
                s += " ";
                if(n % 10 != 0)
                    s += map.get(n%10);
            }
        }
        else {
            throw new UnsupportedOperationException("Number conversion not supported for number: " + n);
        }

        return s.trim();
    }

    private void readFromFile(String filename) throws FileNotFoundException {
        Scanner s = new Scanner(new File(filename));
        while(s.hasNextLine()) {
            String[] tokens = s.nextLine().split("\t");
            if(tokens[0].charAt(0) == '#') // comment
                continue;
            map.put(Integer.parseInt(tokens[0]), tokens[1]);
        }
    }
}