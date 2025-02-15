package com.eeeab.eeeabsmobs.sever.entity.effects;

import com.eeeab.eeeabsmobs.client.util.ControlledAnimation;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//基于自: https://github.com/BobMowzie/MowziesMobs/blob/master/src/main/java/com/bobmowzie/mowziesmobs/server/entity/effects/EntitySolarBeam.java
public class EntityAbsBeam extends EntityMagicEffects {
    protected float damage;
    public float yaw, pitch;
    public float preYaw, prePitch;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    public double prevCollidePosX, prevCollidePosY, prevCollidePosZ;
    public Direction blockSide = null;
    public boolean ON = true;
    public ControlledAnimation displayControlled = new ControlledAnimation(3);
    private static final EntityDataAccessor<Float> DATA_YAW = SynchedEntityData.defineId(EntityAbsBeam.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DATA_PITCH = SynchedEntityData.defineId(EntityAbsBeam.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_DURATION = SynchedEntityData.defineId(EntityAbsBeam.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_COUNT_DOWN = SynchedEntityData.defineId(EntityAbsBeam.class, EntityDataSerializers.INT);

    public EntityAbsBeam(EntityType<?> type, Level level, int countDown) {
        super(type, level);
        this.setCountDown(countDown);
        noCulling = true;
    }

    @Override
    public void tick() {
        super.tick();
        this.prevCollidePosX = this.collidePosX;
        this.prevCollidePosY = this.collidePosY;
        this.prevCollidePosZ = this.collidePosZ;
        this.preYaw = this.yaw;
        this.prePitch = this.pitch;
        this.yaw = this.getYaw();
        this.pitch = this.getPitch();
        this.xo = this.getX();
        this.yo = this.getY();
        this.zo = this.getZ();
        if (this.tickCount == 1 && this.level().isClientSide) {
            this.caster = (LivingEntity) this.level().getEntity(getCasterId());
        }

        this.beamTick();

        if ((!ON && this.displayControlled.isStop()) || (this.caster != null && !caster.isAlive())) {
            this.discard();
        }

        this.displayControlled.incrementOrDecreaseTimer(ON && this.isAccumulating());

        if (this.tickCount - this.getCountDown() > this.getDuration()) {
            ON = false;
        }
    }

    protected void beamTick() {
    }

    protected void spawnExplosionParticles() {
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_YAW, 0F);
        this.entityData.define(DATA_PITCH, 0F);
        this.entityData.define(DATA_DURATION, 0);
        this.entityData.define(DATA_COUNT_DOWN, 0);
    }

    public boolean isAccumulating() {
        return this.tickCount > this.getCountDown();
    }

    public float getYaw() {
        return getEntityData().get(DATA_YAW);
    }

    public void setYaw(float rotAngle) {
        getEntityData().set(DATA_YAW, rotAngle);
    }

    public float getPitch() {
        return getEntityData().get(DATA_PITCH);
    }

    public void setPitch(float rotAngle) {
        getEntityData().set(DATA_PITCH, rotAngle);
    }

    public int getDuration() {
        return getEntityData().get(DATA_DURATION);
    }

    public void setDuration(int duration) {
        getEntityData().set(DATA_DURATION, duration);
    }

    public int getCountDown() {
        return getEntityData().get(DATA_COUNT_DOWN);
    }

    public void setCountDown(int countDown) {
        getEntityData().set(DATA_COUNT_DOWN, countDown);
    }

    protected void calculateEndPos(double radius) {
        if (level().isClientSide()) {
            endPosX = getX() + radius * Math.cos(yaw) * Math.cos(pitch);
            endPosZ = getZ() + radius * Math.sin(yaw) * Math.cos(pitch);
            endPosY = getY() + radius * Math.sin(pitch);
        } else {
            endPosX = getX() + radius * Math.cos(getYaw()) * Math.cos(getPitch());
            endPosZ = getZ() + radius * Math.sin(getYaw()) * Math.cos(getPitch());
            endPosY = getY() + radius * Math.sin(getPitch());
        }
    }


    public HitResult raytraceEntities(Level world, Vec3 from, Vec3 to) {
        HitResult result = new HitResult();
        result.setBlockHit(world.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)));
        if (result.getBlockHit() != null) {
            Vec3 hitVec = result.getBlockHit().getLocation();
            collidePosX = hitVec.x;
            collidePosY = hitVec.y;
            collidePosZ = hitVec.z;
            blockSide = result.getBlockHit().getDirection();
        } else {
            collidePosX = endPosX;
            collidePosY = endPosY;
            collidePosZ = endPosZ;
            blockSide = null;
        }
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).inflate(1, 1, 1));
        for (LivingEntity entity : entities) {
            if (entity == this.caster) {
                continue;
            }
            float pad = entity.getPickRadius() + getBaseScale();
            AABB aabb = entity.getBoundingBox().inflate(pad, pad, pad);
            Optional<Vec3> hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }

    protected float getBaseScale() {
        return 0.5F;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public static class HitResult {
        private BlockHitResult blockHit;
        private final List<LivingEntity> entities = new ArrayList<>();

        public BlockHitResult getBlockHit() {
            return blockHit;
        }

        public List<LivingEntity> getEntities() {
            return entities;
        }

        public void setBlockHit(net.minecraft.world.phys.HitResult rayTraceResult) {
            if (rayTraceResult.getType() == net.minecraft.world.phys.HitResult.Type.BLOCK)
                this.blockHit = (BlockHitResult) rayTraceResult;
        }

        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);
        }
    }
}
