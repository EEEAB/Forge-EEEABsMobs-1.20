package com.eeeab.eeeabsmobs.sever.entity.impl;

import com.github.alexthe666.citadel.animation.Animation;
import com.github.alexthe666.citadel.animation.AnimationHandler;
import com.github.alexthe666.citadel.animation.IAnimatedEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import org.apache.commons.lang3.ArrayUtils;

/**
 * <b>EEEABMobLibrary</b><br/>
 */
public abstract class EEEABMobLibrary extends EEEABMobEntity implements IAnimatedEntity, IEntityAdditionalSpawnData {
    private int animationTick;
    private Animation animation = NO_ANIMATION;
    public boolean canplayHurtAnimation = true;//可以播放受伤动画
    public boolean hurtInterruptsAnimation = false;//伤害中断其他动画


    public EEEABMobLibrary(EntityType<? extends EEEABMobLibrary> type, Level level) {
        super(type, level);
    }

    public abstract Animation getDeathAnimation();

    public abstract Animation getHurtAnimation();


    @Override
    public boolean hurt(DamageSource source, float damage) {
        boolean attack = super.hurt(source, damage);
        if (attack) {
            if (getHealth() > 0.0F && (getAnimation() == NO_ANIMATION || hurtInterruptsAnimation) && canplayHurtAnimation) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, getHurtAnimation());
            } else if (getHealth() <= 0.0F) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, getDeathAnimation());
            }
        }
        return attack;
    }

    @Override
    protected int getDeathDuration() {
        Animation death;
        if ((death = getDeathAnimation()) != null) {
            return death.getDuration() - 20;
        }
        return 20;
    }

    public void playAnimation(Animation animation) {
        if (animation != null) AnimationHandler.INSTANCE.sendAnimationMessage(this, animation);
    }

    @Override
    public int getAnimationTick() {
        return this.animationTick;
    }

    @Override
    public void setAnimationTick(int tick) {
        this.animationTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return this.animation;
    }

    @Override
    public void setAnimation(Animation animation) {
        if (animation != NO_ANIMATION) {
            onAnimationStart(animation);
        } else {
            onAnimationFinish(this.animation);
        }
        this.animation = animation;
        setAnimationTick(0);
    }

    protected void onAnimationStart(Animation animation) {
    }

    protected void onAnimationFinish(Animation animation) {
    }

    //用于在生成时需要在服务器和客户端之间进行通信的额外信息的实体的接口
    //由服务器在构造生成数据包时调用。应将数据添加到提供的流中
    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {
        buffer.writeInt(ArrayUtils.indexOf(this.getAnimations(), this.getAnimation()));
        buffer.writeInt(this.getAnimationTick());
    }

    //客户端在收到实体生成数据包时调用。应以与写入数据相同的方式从流中读出数据
    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {
        yRotO = getYRot();
        yBodyRotO = yBodyRot = yHeadRotO = yHeadRot;
        int animOrdinal = additionalData.readInt();
        int animTick = additionalData.readInt();
        this.setAnimation(animOrdinal == -1 ? NO_ANIMATION : this.getAnimations()[animOrdinal]);
        this.setAnimationTick(animTick);
    }
}
