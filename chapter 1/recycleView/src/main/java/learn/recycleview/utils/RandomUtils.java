package learn.recycleview.utils;

import java.util.Random;

public class RandomUtils {

    public static int getValue(){
        Random random = new Random();
        return random.nextInt(7);
    }
}
