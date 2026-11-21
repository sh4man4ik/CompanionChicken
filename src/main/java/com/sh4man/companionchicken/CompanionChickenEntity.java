package com.sh4man.companionchicken;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CompanionChickenEntity extends EntityChicken
{
    public CompanionChickenEntity(World world)
    {
        super(world);
    }

    @Override
    public CompanionChickenEntity createChild(EntityAgeable ageable)
    {
        return new CompanionChickenEntity(world);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (!this.world.isRemote)
        {
            moveToPlayer();
        }
    }

    public void moveToPlayer()
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
}
