package com.eeeab.eeeabsmobs.sever.item.util;

import com.eeeab.eeeabsmobs.sever.init.ItemInit;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import java.util.EnumMap;
import java.util.function.Supplier;

//盔甲级别
public enum EMArmorMaterial implements net.minecraft.world.item.ArmorMaterial {
    GHOST_WARRIOR_MATERIAL("ghost_warrior", 180, Util.make(new EnumMap<>(EquipmentSlot.class), (map) -> {
        map.put(EquipmentSlot.FEET, 5);
        map.put(EquipmentSlot.LEGS, 8);
        map.put(EquipmentSlot.CHEST, 11);
        map.put(EquipmentSlot.HEAD, 5);
    }), 20, SoundEvents.ARMOR_EQUIP_IRON, 4.5F, 0.125F, () -> {
        return Ingredient.of(ItemInit.GHOST_STEEL_INGOT.get());//修复材料
    });

    private final String name;//名字 用于渲染装备有关
    private final int durabilityMultiplier;//耐久性乘数
    private final EnumMap<EquipmentSlot, Integer> protectionFunctionForType;//盔甲防御值(map格式)
    private final int enchantability;//附魔亲和力
    private final SoundEvent soundEvent;//穿上盔甲音效
    private final float toughness;//盔甲韧性
    private final float knockbackResistance;//击退抗性
    private final LazyLoadedValue<Ingredient> repairMaterial;//维修材料
    private static final EnumMap<EquipmentSlot, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(EquipmentSlot.class), (map) -> {
        map.put(EquipmentSlot.FEET, 13);
        map.put(EquipmentSlot.LEGS, 15);
        map.put(EquipmentSlot.CHEST, 16);
        map.put(EquipmentSlot.HEAD, 11);
    });

    EMArmorMaterial(String name, int durabilityMultiplier, EnumMap<EquipmentSlot, Integer> protectionFunctionForType, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionFunctionForType;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot type) {
        return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot type) {
        return protectionFunctionForType.get(type);
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
