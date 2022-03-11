package chronosacaria.mcdw.mixin;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.api.interfaces.IMcdwEnchantedArrow;
import chronosacaria.mcdw.api.util.ProjectileEffectHelper;
import chronosacaria.mcdw.api.util.RangedAttackHelper;
import chronosacaria.mcdw.enums.EnchantmentsID;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {

    // Bonus Shot
    @Inject(method = "createArrow", at = @At(value = "RETURN"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void createBonusShotArrow(World world, LivingEntity user, ItemStack crossbow, ItemStack arrow,
                                    CallbackInfoReturnable<PersistentProjectileEntity> cir, ArrowItem arrowItem,
                                    PersistentProjectileEntity persistentProjectileEntity){
        ItemStack stack = user.getMainHandStack();
        if (Mcdw.CONFIG.mcdwEnchantmentsConfig.enableEnchantments.get(EnchantmentsID.BONUS_SHOT)) {
            if (stack.getItem() instanceof CrossbowItem){
                if (CrossbowItem.isCharged(stack)) {
                    IMcdwEnchantedArrow enchantedArrow = (IMcdwEnchantedArrow) persistentProjectileEntity;
                    if (enchantedArrow.getBonusShotLevel() > 0) {
                        float damageMultiplier = 0.1F + ((enchantedArrow.getBonusShotLevel() - 1) * 0.07F);

                        float arrowVelocity = RangedAttackHelper.getVanillaOrModdedCrossbowArrowVelocity(stack);
                        ProjectileEffectHelper.fireBonusShotTowardsOtherEntity(user, 10, damageMultiplier,
                                arrowVelocity);
                    }
                }
            }
        }
    }
}
