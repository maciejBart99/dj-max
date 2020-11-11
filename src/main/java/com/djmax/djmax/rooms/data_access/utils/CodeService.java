package com.djmax.djmax.rooms.data_access.utils;

import org.springframework.stereotype.Service;

@Service
public class CodeService {
    public String generateCode(int pos) {
        int min = (int)Math.pow(10, pos);
        int max = (int)Math.pow(10, pos + 1) - 1;
        int random_int = (int)(Math.random() * (max - min + 1) + min);

        return Integer.toString(random_int);
    }
}
