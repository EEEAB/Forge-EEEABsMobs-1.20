package com.eeeab.eeeabsmobs.sever.item;

import com.eeeab.eeeabsmobs.sever.ability.AbilityHandler;
import com.eeeab.eeeabsmobs.sever.capability.AbilityCapability;
import com.eeeab.eeeabsmobs.sever.init.ItemInit;
import com.eeeab.eeeabsmobs.sever.item.util.EEToolTipItem;
import com.eeeab.eeeabsmobs.sever.util.MTUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemImmortalStaff extends EEToolTipItem {
    public ItemImmortalStaff(Properties properties) {
        super(properties);
    }

    @Override
    protected void detailsTooltip(List<Component> tooltip) {
        tooltip.add(MTUtil.simpleWeaponText("immortal_staff", MTUtil.STYLE_GRAY));
    }

    @Override
    public void appendHoverText(ItemStack stack, @org.jetbrains.annotations.Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(MTUtil.UNABLE_BREAKS);
        super.appendHoverText(stack, level, tooltip, flagIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeCharged) {
        int charge = this.getUseDuration(stack) - timeCharged;
        if (entity instanceof Player player && charge > 20) {
            InteractionHand hand = player.getUsedItemHand();
            player.swing(hand, true);
            AbilityCapability.IAbilityCapability capability = AbilityHandler.INSTANCE.getAbilityCapability(player);
            if (capability != null) {
                AbilityHandler.INSTANCE.sendPlayerAbilityMessage(player, AbilityHandler.IMMORTAL_STAFF_ABILITY_TYPE);
                player.getCooldowns().addCooldown(this, 20);
            }
        }
    }

    @Override
    @NotNull
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }


    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }
}
