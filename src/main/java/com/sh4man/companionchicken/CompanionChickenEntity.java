package com.sh4man.companionchicken;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import com.mojang.text2speech.Narrator;

public class CompanionChickenEntity extends EntityChicken
{
    private static final Narrator narrator = Narrator.getNarrator();
    private int time = Dictionary.getRandomTime(10, 20);

    private float lastChickenHealth = -1;
    private float lastPlayerHealth = -1;
    private boolean wasNight = false;
    private boolean wasInWater = false;
    private boolean wasNoSky = false;
    private boolean wasSneaking = false;
    private boolean wasSprinting = false;
    private boolean wasLowHealth = false;
    private boolean wasHungry = false;
    private boolean greeted = false;

    private void speak(String text)
    {
        this.setCustomNameTag(text);
        narrator.say(text);
    }

    private void randomCommunication()
    {
        String randomPhrase = Dictionary.getRandomPhrase();
        speak(randomPhrase);
    }

    private void isChickenHurt()
    {
        float health = this.getHealth();
        boolean triggered = lastChickenHealth >= 0 && health < lastChickenHealth;
        lastChickenHealth = health;

        if (triggered)
        {
            speak(Dictionary.getRandomSwearPhrase());
        }
    }

    private void isNight()
    {
        boolean night = false;

        if (this.world.provider.getDimension() == 0)
        {
            long worldTime = this.world.getWorldTime() % 24000L;
            night = worldTime > 13000L && worldTime < 23000L;
        }

        boolean triggered = night && !wasNight;
        wasNight = night;

        if (triggered)
        {
            speak(Dictionary.getRandomNightPhrase());
        }
    }

    private void isWater()
    {
        boolean inWater = this.isInWater();
        boolean triggered = inWater && !wasInWater;
        wasInWater = inWater;

        if (triggered)
        {
            speak(Dictionary.getRandomWaterPhrase());
        }
    }

    private void isNoSky()
    {
        boolean noSky = !this.world.canSeeSky(this.getPosition());
        boolean triggered = noSky && !wasNoSky;
        wasNoSky = noSky;

        if (triggered)
        {
            speak(Dictionary.getRandomNoSkyPhrase());
        }
    }

    private void isPlayerHurt(EntityPlayer player)
    {
        float health = player.getHealth();
        boolean triggered = lastPlayerHealth >= 0 && health < lastPlayerHealth;
        lastPlayerHealth = health;

        if (triggered)
        {
            speak(Dictionary.getRandomPlayerHurtPhrase());
        }
    }

    private void isPlayerSneaking(EntityPlayer player)
    {
        boolean sneaking = player.isSneaking();
        boolean triggered = sneaking && !wasSneaking;
        wasSneaking = sneaking;

        if (triggered)
        {
            speak(Dictionary.getRandomPlayerSneakingPhrase());
        }
    }

    private void isPlayerSprinting(EntityPlayer player)
    {
        boolean sprinting = player.isSprinting();
        boolean triggered = sprinting && !wasSprinting;
        wasSprinting = sprinting;

        if (triggered)
        {
            speak(Dictionary.getRandomPlayerSprintingPhrase());
        }
    }

    private void isPlayerLowHealth(EntityPlayer player)
    {
        boolean lowHealth = player.getHealth() <= 6.0F || wasLowHealth && player.getHealth() < 10.0F;
        boolean triggered = lowHealth && !wasLowHealth;
        wasLowHealth = lowHealth;

        if (triggered)
        {
            speak(Dictionary.getRandomPlayerLowHealthPhrase());
        }
    }

    private void isPlayerHungry(EntityPlayer player)
    {
        boolean hungry = player.getFoodStats().getFoodLevel() <= 6;
        boolean triggered = hungry && !wasHungry;
        wasHungry = hungry;

        if (triggered)
        {
            speak(Dictionary.getRandomPlayerHungryPhrase());
        }
    }

    private void isGreeting(EntityPlayer player)
    {
        if (!greeted)
        {
            speak("Hi " + player.getName() + ", Boris here");
            greeted = true;
        }
    }

    private void moveToPlayer()
    {
        EntityPlayer player = this.world.getClosestPlayerToEntity(this, 16.0D);

        if (player != null)
        {
            double distance = this.getDistance(player);

            if (distance > 3.0D)
            {
                this.getNavigator().tryMoveToEntityLiving(player, 1.0D);
            }
            else
            {
                this.getNavigator().clearPath();
            }
        }
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.world.isRemote)
        {
            return;
        }

        moveToPlayer();
        isChickenHurt();

        EntityPlayer player = this.world.getClosestPlayerToEntity(this, 16.0D);

        if (player != null)
        {
            isGreeting(player);
            isPlayerHurt(player);
        }

        if (this.ticksExisted % 10 == 0)
        {
            isNight();
            isWater();
            isNoSky();

            if (player != null)
            {
                isPlayerSneaking(player);
                isPlayerSprinting(player);
                isPlayerLowHealth(player);
                isPlayerHungry(player);
            }
        }

        time--;

        if (time <= 0)
        {
            randomCommunication();
            time = Dictionary.getRandomTime(10, 20);
        }
    }

    @Override
    public CompanionChickenEntity createChild(EntityAgeable ageable)
    {
        return new CompanionChickenEntity(world);
    }

    public CompanionChickenEntity(World world)
    {
        super(world);
        this.setAlwaysRenderNameTag(true);
    }
}
