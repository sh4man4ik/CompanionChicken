package com.sh4man.companionchicken;

import java.util.Random;

public class Dictionary
{
    private static final Random random = new Random();

    private static final String[] phrases = {
            "I am not dinner",
            "This biome is ugly",
            "Don't look at me like that",
            "How do you like my balls?",
            "Want to taste my eggs?",
            "I'm not KFC",
            "Smells like noob in here",
            "You're slower than a turtle",
            "Keep walking, noob",
            "I'm too pretty to be nuggets",
            "I'll shit on your bed",
            "Pro gamer. Still gonna die",
            "My tail looks better than your face",
            "You smell like wet dog",
            "Wake me up when you find diamonds"
    };

    public static int getRandomTime(int min, int max)
    {
        return (min + random.nextInt(max - min + 1)) * 20;
    }

    public static String getRandomPhrases()
    {
        return phrases[random.nextInt(phrases.length)];
    }
}
