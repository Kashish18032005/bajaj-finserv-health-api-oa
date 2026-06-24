package com.chitkara.bfhl.service;

import com.chitkara.bfhl.dto.BfhlRequest;
import com.chitkara.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String FULL_NAME = "Kashish Sharma";
    private static final String USER_ID = "kashish_sharma_18032005";
    private static final String EMAIL = "kashish2574.be23@chitkara.edu.in";
    private static final String ROLL_NUMBER = "2310992574";

    @Override
    public BfhlResponse processData(BfhlRequest request) {
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        long numericSum = 0;
        StringBuilder allAlphaChars = new StringBuilder();

        if (request.getData() != null) {
            for (String item : request.getData()) {
                if (isNumber(item)) {
                    long val = Long.parseLong(item);
                    if (val % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                    numericSum += val;
                } else if (isAlpha(item)) {
                    alphabets.add(item.toUpperCase());
                    allAlphaChars.append(item);
                } else {
                    specialCharacters.add(item);
                }
            }
        }

        BfhlResponse response = new BfhlResponse();
        response.setSuccess(true);
        response.setUserId(USER_ID);
        response.setEmail(EMAIL);
        response.setRollNumber(ROLL_NUMBER);
        response.setOddNumbers(oddNumbers);
        response.setEvenNumbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecialCharacters(specialCharacters);
        response.setSum(String.valueOf(numericSum));
        response.setConcatString(buildConcatString(allAlphaChars.toString()));

        return response;
    }

    private boolean isNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isAlpha(String s) {
        return s != null && !s.isEmpty() && s.chars().allMatch(Character::isLetter);
    }

    private String buildConcatString(String allChars) {
        if (allChars == null || allChars.isEmpty()) return "";
        
        String reversed = new StringBuilder(allChars).reverse().toString();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        
        return result.toString();
    }
}
