package com.eeeab.eeeabsmobs.client.model.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AnimationImmortalSkeleton {
    public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(0f).looping().addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-75f, 25f, 10f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(-0.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-85f, -10f, -10f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition SWINGARM = AnimationDefinition.Builder.withLength(0.75f).addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167667f, KeyframeAnimations.posVec(0f, 0.1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("upper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5416766f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-120.08f, 4.53f, -2.12f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-116.88f, 2f, 2.24f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(-21.96f, -9.14f, 18.25f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(11.54f, -6f, 2.34f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-120.08f, -4.53f, 2.12f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-116.88f, -2f, -2.24f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(-21.96f, 9.14f, -18.25f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(11.54f, 6f, -2.34f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition MELEE1 = AnimationDefinition.Builder.withLength(0.75f).addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.08f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.2f, KeyframeAnimations.degreeVec(60f, 20f, -20f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.52f, KeyframeAnimations.degreeVec(-15f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.64f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.2f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.36f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.52f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.2f, KeyframeAnimations.degreeVec(-135.19f, 20f, -10.51f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.28f, KeyframeAnimations.degreeVec(-150f, 10f, -8f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4f, KeyframeAnimations.degreeVec(-52.4f, -35.14f, 9.57f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(-38.22f, -28.51f, 5.38f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.56f, KeyframeAnimations.degreeVec(-20f, -20f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.68f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("upper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.2f, KeyframeAnimations.degreeVec(-5f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4f, KeyframeAnimations.degreeVec(10f, -10f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(9.95f, -9.94f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.64f, KeyframeAnimations.degreeVec(2f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.2f, KeyframeAnimations.degreeVec(0f, -5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.72f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.2f, KeyframeAnimations.degreeVec(-9.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(4.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.2f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition MELEE2 = AnimationDefinition.Builder.withLength(0.75f).addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16f, KeyframeAnimations.degreeVec(54.04f, 36.85f, -32.34f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4f, KeyframeAnimations.degreeVec(53.13f, 26.08f, -24.78f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.56f, KeyframeAnimations.degreeVec(-6.64f, -0.83f, -6.73f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.72f, KeyframeAnimations.degreeVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.56f, KeyframeAnimations.posVec(0f, -0.29f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.64f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16f, KeyframeAnimations.degreeVec(-106.7f, -14.11f, 61.69f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4f, KeyframeAnimations.degreeVec(4.01f, -8.93f, 70.24f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.56f, KeyframeAnimations.degreeVec(-32.24f, -6.26f, 54.49f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.72f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("upper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16f, KeyframeAnimations.degreeVec(-5f, -40f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4f, KeyframeAnimations.degreeVec(10f, 20f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.56f, KeyframeAnimations.degreeVec(-2f, 5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.72f, KeyframeAnimations.degreeVec(2f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16f, KeyframeAnimations.degreeVec(-2.53f, 9.99f, -0.66f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4f, KeyframeAnimations.degreeVec(10.11f, 9.92f, 0.88f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.56f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16f, KeyframeAnimations.degreeVec(-6.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.4f, KeyframeAnimations.degreeVec(6.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.56f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition ROAR = AnimationDefinition.Builder.withLength(2f).addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.posVec(0f, 0f, -3f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.posVec(0f, 0f, -3f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.posVec(0f, 0f, -1.33f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.92f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("upper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(-20f, 5f, -2.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.degreeVec(45f, -2.5f, -2.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.4f, KeyframeAnimations.degreeVec(40f, -5.71f, -2.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.degreeVec(27.63f, -6.13f, -2.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(15f, -5f, -2.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.degreeVec(-40.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.4f, KeyframeAnimations.degreeVec(-35.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.degreeVec(-28.12f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(-90.5f, 10f, 20f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.degreeVec(30.5f, 0f, -20f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.degreeVec(30.5f, 0f, -10f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(-90.5f, -10f, -20f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.degreeVec(30.5f, 0f, 20f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.degreeVec(30.5f, 0f, 10f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.posVec(0f, 0f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.posVec(0f, 0f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.posVec(0f, 0f, 0.44f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.92f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.degreeVec(4.44f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.92f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.posVec(0f, 0f, -0.89f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.92f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.44f, KeyframeAnimations.degreeVec(-50f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.6f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.56f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.76f, KeyframeAnimations.degreeVec(-4.44f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.92f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition BLOCK = AnimationDefinition.Builder.withLength(0.5f).addAnimation("upper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.12f, KeyframeAnimations.degreeVec(5f, 15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.36f, KeyframeAnimations.degreeVec(5f, 15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.12f, KeyframeAnimations.degreeVec(-7.5f, -12.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.36f, KeyframeAnimations.degreeVec(-7.5f, -12.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.12f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.36f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.48f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.12f, KeyframeAnimations.degreeVec(-60f, 60f, 20f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.36f, KeyframeAnimations.degreeVec(-60f, 60f, 20f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.12f, KeyframeAnimations.degreeVec(7.5f, 0f, 10f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.36f, KeyframeAnimations.degreeVec(7.5f, 0f, 10f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
}