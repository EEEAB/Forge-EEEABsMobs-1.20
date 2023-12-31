package com.eeeab.eeeabsmobs.sever.entity.ai.goal;

import com.eeeab.eeeabsmobs.sever.entity.ai.goal.animation.base.AnimationAbstractGoal;
import com.eeeab.eeeabsmobs.sever.entity.impl.effect.EntityCameraShake;
import com.eeeab.eeeabsmobs.sever.entity.impl.namelessguardian.EntityNamelessGuardian;
import com.eeeab.eeeabsmobs.sever.entity.util.ModEntityUtils;
import com.eeeab.eeeabsmobs.sever.init.SoundInit;
import com.eeeab.eeeabsmobs.sever.util.ModDamageSource;
import com.github.alexthe666.citadel.animation.Animation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class GuardianCombo2Goal extends AnimationAbstractGoal<EntityNamelessGuardian> {
    private boolean isPowered;
    private final float range;
    private final float attackArc;

    public GuardianCombo2Goal(EntityNamelessGuardian entity, float range, float attackArc) {
        super(entity);
        this.range = range;
        this.attackArc = attackArc;
    }

    @Override
    public void start() {
        super.start();
        this.isPowered = this.entity.isPowered();
    }


    @Override
    protected boolean test(Animation animation) {
        return animation == EntityNamelessGuardian.ATTACK2_ANIMATION_1 || animation == EntityNamelessGuardian.ATTACK2_ANIMATION_2 || animation == EntityNamelessGuardian.ATTACK2_ANIMATION_3;
    }

    @Override
    public void tick() {
        Animation animation = this.entity.getAnimation();
        LivingEntity target = this.entity.getTarget();
        int tick = this.entity.getAnimationTick();
        float baseDamageMultiplier = isPowered ? 1.2F : 1.0F;
        entity.setDeltaMovement(0, entity.onGround() ? 0 : entity.getDeltaMovement().y, 0);
        if (animation == EntityNamelessGuardian.ATTACK2_ANIMATION_1) {
            int lookAtFrame = isPowered ? 12 : 8;
            if (tick < lookAtFrame && target != null) {
                this.entity.lookAt(target, 30F, 30F);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
            if (tick == 11) {
                if (this.entity.targetDistance > 1.8 || entity.getTarget() == null) {
                    double moveMultiplier = entity.targetDistance < 8 && entity.targetDistance > 3 ? (entity.targetDistance - 1.85) : 1.2;
                    this.entity.move(MoverType.SELF, new Vec3(Math.cos(Math.toRadians(entity.getYRot() + 90)) * moveMultiplier, 0, Math.sin(Math.toRadians(entity.getYRot() + 90)) * moveMultiplier));
                }
            } else if (tick == 8) {
                this.entity.playSound(SoundInit.NAMELESS_GUARDIAN_WHOOSH.get(), 1.95f, this.entity.getVoicePitch());
            } else if (tick == 12) {
                List<LivingEntity> entities = this.entity.getNearByLivingEntities(range);
                for (LivingEntity hitEntity : entities) {
                    float entityRelativeAngle = ModEntityUtils.getTargetRelativeAngle(entity, hitEntity);
                    float entityHitDistance = (float) Math.sqrt((hitEntity.getZ() - entity.getZ()) * (hitEntity.getZ() - entity.getZ()) + (hitEntity.getX() - entity.getX()) * (hitEntity.getX() - entity.getX())) - hitEntity.getBbWidth() / 2F;
                    if ((entityHitDistance <= range && (entityRelativeAngle <= (attackArc + 70) / 2F && entityRelativeAngle >= -(attackArc - 20) / 2F) || (entityRelativeAngle >= 360 - attackArc / 2F || entityRelativeAngle <= -360 + attackArc / 2F))) {
                        entity.guardianHurtTarget(entity, hitEntity, 0.05F, 1.0F, baseDamageMultiplier, true, true);
                        hitEntity.setDeltaMovement(hitEntity.getDeltaMovement().add(0, 0.6, 0));
                        entity.playSound(SoundInit.GIANT_AXE_HIT.get(), 1.5F, 0.2F);
                    }
                }
            } else if (tick == 20 && entity.checkCanAttackRange(2.0F, range) && canToggleAnimation(80)) {
                this.entity.playAnimation(EntityNamelessGuardian.ATTACK2_ANIMATION_2);
            }
        } else if (animation == EntityNamelessGuardian.ATTACK2_ANIMATION_2) {
            tick = this.entity.getAnimationTick();
            int lookAtFrame = isPowered ? 12 : 8;
            if (tick < lookAtFrame && target != null) {
                this.entity.lookAt(target, 30F, 30F);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
            if (tick == 5) {
                if (this.entity.targetDistance > 1.8 || entity.getTarget() == null)
                    this.entity.move(MoverType.SELF, new Vec3(Math.cos(Math.toRadians(entity.getYRot() + 90)) * 1.4, 0, Math.sin(Math.toRadians(entity.getYRot() + 90)) * 1.4));
            } else if (tick == 6) {
                this.entity.playSound(SoundInit.NAMELESS_GUARDIAN_WHOOSH.get(), 2.05f, this.entity.getVoicePitch() + 0.15f);
            } else if (tick == 10) {
                List<LivingEntity> entities = this.entity.getNearByLivingEntities(range);
                for (LivingEntity hitEntity : entities) {
                    float entityRelativeAngle = ModEntityUtils.getTargetRelativeAngle(entity, hitEntity);
                    float entityHitDistance = (float) Math.sqrt((hitEntity.getZ() - entity.getZ()) * (hitEntity.getZ() - entity.getZ()) + (hitEntity.getX() - entity.getX()) * (hitEntity.getX() - entity.getX())) - hitEntity.getBbWidth() / 2F;
                    if ((entityHitDistance <= range && (entityRelativeAngle <= (attackArc + 20) / 2F && entityRelativeAngle >= -(attackArc + 20) / 2F) || (entityRelativeAngle >= 360 - attackArc / 2F || entityRelativeAngle <= -360 + attackArc / 2F))) {
                        entity.guardianHurtTarget(entity, hitEntity, 0.05F, 1.0F, baseDamageMultiplier, true, true);
                        entity.playSound(SoundInit.GIANT_AXE_HIT.get(), 1.5F, 0.2F);
                        double ratioX = Math.sin(entity.getYRot() * ((float) Math.PI / 180F));
                        double ratioZ = (-Math.cos(entity.getYRot() * ((float) Math.PI / 180F)));
                        ModEntityUtils.forceKnockBack(hitEntity, 0.25F, ratioX, ratioZ, 1.0F, false);
                    }
                }
            } else if (tick == 20 && entity.checkCanAttackRange(2.5F, range) && canToggleAnimation(70)) {
                this.entity.playAnimation(EntityNamelessGuardian.ATTACK2_ANIMATION_3);
            }
        } else if (animation == EntityNamelessGuardian.ATTACK2_ANIMATION_3) {
            tick = this.entity.getAnimationTick();
            baseDamageMultiplier += 0.2F;
            if (tick < 13 && target != null) {
                this.entity.lookAt(target, 30F, 30F);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
            if (tick == 5) {
                if (this.entity.targetDistance > 1.8 || entity.getTarget() == null) {
                    double moveMultiplier = entity.targetDistance < 8 && entity.targetDistance > 4.5 ? (entity.targetDistance - 2.45) : 1.4;
                    this.entity.move(MoverType.SELF, new Vec3(Math.cos(Math.toRadians(entity.getYRot() + 90)) * moveMultiplier, 0, Math.sin(Math.toRadians(entity.getYRot() + 90)) * moveMultiplier));
                }
            } else if (tick == 9) {
                this.entity.playSound(SoundInit.NAMELESS_GUARDIAN_WHOOSH.get(), 2.2f, this.entity.getVoicePitch() + 0.15f);
            } else if (tick == 13) {
                final float attackArc = 30F;
                final float range = 5.4F;
                List<LivingEntity> entities = entity.getNearByLivingEntities(range, range - 0.6F, range, range);
                for (LivingEntity livingEntity : entities) {
                    float entityRelativeAngle = ModEntityUtils.getTargetRelativeAngle(entity, livingEntity);
                    float entityHitDistance = (float) Math.sqrt((livingEntity.getZ() - entity.getZ()) * (livingEntity.getZ() - entity.getZ()) + (livingEntity.getX() - entity.getX()) * (livingEntity.getX() - entity.getX())) - livingEntity.getBbWidth() / 2F;
                    if ((entityHitDistance <= range && (entityRelativeAngle <= attackArc / 2F && entityRelativeAngle >= -attackArc / 2F) || (entityRelativeAngle >= 360 - attackArc / 2F || entityRelativeAngle <= -360 + attackArc / 2F))) {
                        entity.guardianHurtTarget(entity, livingEntity, 0.1F, 1.0F, baseDamageMultiplier, true, true);
                        entity.playSound(SoundInit.GIANT_AXE_HIT.get(), 1.5F, 0.2F);
                    }
                }
            } else if (tick == 14) {
                entity.playSound(SoundEvents.GENERIC_EXPLODE, 1.25F, 1F + entity.getRandom().nextFloat() * 0.1F);
                EntityCameraShake.cameraShake(entity.level(), entity.position(), 10, 0.25F, 0, 10);
            }
        }
    }

    private boolean canToggleAnimation(int healthPercentage) {
        return (!isPowered && ((entity.getHealthPercentage() >= healthPercentage && entity.getRandom().nextFloat() < 0.2F) ||
                (entity.getHealthPercentage() < healthPercentage && entity.getRandom().nextFloat() < 0.3F))) ||
                (isPowered && entity.getRandom().nextFloat() < 0.9F);
    }
}
