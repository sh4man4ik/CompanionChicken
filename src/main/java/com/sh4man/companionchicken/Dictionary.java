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

    private static final String[] swearPhrases = {
            "Damn",
            "Bullshit",
            "Asshole",
            "Fuck",
            "Shit",
            "Bitch",
            "Motherfucker",
            "Son of a biscuit",
            "What the fuck",
            "What the heck",
            "Kiss my ass",
            "Digger"
    };

    private static final String[] nightPhrases = {
            "Zombies love idiots like you",
            "Build a dirt hole or something",
            "Great, now the creepers come out",
            "Wake me up when it's morning",
            "Where's your bed, idiot?",
            "Great, my favorite time to die",
            "Step on a creeper and we're done",
            "White meat stands out in the dark",
            "Free loot delivery service is here",
            "I'm too young to become zombie nuggets"
    };

    private static final String[] waterPhrases = {
            "I'm a chicken, not a duck",
            "Do I look like a boat?",
            "My balls are freezing",
            "Get me out of here",
            "Who put me in water?",
            "Get me out before I freeze",
            "I'm too pretty to drown",
            "Stop looking and pull me out",
            "Why am I in the ocean?",
            "Get me out, you blind digger"
    };

    private static final String[] noSkyPhrases = {
            "Where did the sky go?",
            "We're buried alive",
            "I'm a bird, not a mole",
            "Too dark for my pretty face",
            "Get me back to the sun",
            "Are we living in a hole now?",
            "I'm not dying in a hole",
            "Who put a roof over me?",
            "Trapped underground with a total idiot",
            "Let me out, you cave rat"
    };

    private static final String[] playerHurtPhrases = {
            "Hahaha",
            "Nice reflexes",
            "Skill issue",
            "Keep taking hits, pro gamer",
            "You fight like a blind villager",
            "Are you trying to die?",
            "My grandma dodges better than you",
            "Uninstall the game already, noob",
            "Try using a shield",
            "Blocking with your face again?",
            "Are your eyes closed?",
            "Speedrunning the death screen again?",
            "Go back to peaceful mode"
    };

    private static final String[] playerSneakingPhrases = {
            "Sitting on a bottle again?",
            "Stand up, you look stupid",
            "Hiding won't save your ass",
            "Are you twerking or hiding?",
            "Everyone still sees you",
            "Playing hide and seek alone?",
            "Your hitbox is still huge, idiot"
    };

    private static final String[] playerSprintingPhrases = {
            "Where the hell are you going?",
            "Don't leave me behind",
            "Slow down",
            "Hey! I have little chicken legs!",
            "Wait for me",
            "Why are we running so fast?",
            "Hey, wait for the chicken",
            "Hold up, you giant digger!",
            "Slow your ass down right now",
            "Why the hell are we sprinting?"
    };

    private static final String[] playerLowHealthPhrases = {
            "Can I have your stuff now?",
            "Rest in peace, total noob",
            "See you in hell",
            "Nice knowing you, dead man",
            "Should I start digging your grave?",
            "Have a nice trip to hell",
            "Well, it was nice knowing you",
            "Reserve a spot in hell for me"
    };

    private static final String[] playerHungryPhrases = {
            "Don't look at me like that",
            "Don't even think about it",
            "Back off, I'm not KFC",
            "Go find a pig or something",
            "Stop staring at my thighs",
            "I'm too skinny to eat anyway",
            "I'm your friend, not dinner",
            "Keep your fork away from me",
            "I'm not on the menu",
            "Don't make me into nuggets"
    };

    private static String getter(String[] array)
    {
        return array[random.nextInt(array.length)];
    }

    public static int getRandomTime(int min, int max)
    {
        return (min + random.nextInt(max - min + 1)) * 20;
    }

    public static String getRandomPhrase()
    {
        return getter(phrases);
    }

    public static String getRandomSwearPhrase()
    {
        return getter(swearPhrases);
    }

    public static String getRandomNightPhrase()
    {
        return getter(nightPhrases);
    }

    public static String getRandomWaterPhrase()
    {
        return getter(waterPhrases);
    }

    public static String getRandomNoSkyPhrase()
    {
        return getter(noSkyPhrases);
    }

    public static String getRandomPlayerHurtPhrase()
    {
        return getter(playerHurtPhrases);
    }

    public static String getRandomPlayerSneakingPhrase()
    {
        return getter(playerSneakingPhrases);
    }

    public static String getRandomPlayerSprintingPhrase()
    {
        return getter(playerSprintingPhrases);
    }

    public static String getRandomPlayerLowHealthPhrase()
    {
        return getter(playerLowHealthPhrases);
    }

    public static String getRandomPlayerHungryPhrase()
    {
        return getter(playerHungryPhrases);
    }
}