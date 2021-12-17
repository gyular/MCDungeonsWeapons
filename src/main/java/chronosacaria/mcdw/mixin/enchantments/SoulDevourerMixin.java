
package chronosacaria.mcdw.mixin.enchantments;

import chronosacaria.mcdw.enchants.EnchantsRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LivingEntity.class, PlayerEntity.class})
public abstract class SoulDevourerMixin {

    @Inject(method = "onDeath", at = @At("HEAD"), cancellable = true)
    public void onSoulDevourerDeath(DamageSource source, CallbackInfo ci) {
        if(!(source.getAttacker() instanceof PlayerEntity)) return;

        LivingEntity user = (LivingEntity) source.getAttacker();
        LivingEntity target = (LivingEntity) (Object) this;

        ItemStack mainHandStack;

        if (user != null) {
            mainHandStack = user.getMainHandStack();

            if (mainHandStack != null && EnchantmentHelper.getLevel(EnchantsRegistry.SOUL_DEVOURER, mainHandStack) >= 1) {
                int level = EnchantmentHelper.getLevel(EnchantsRegistry.SOUL_DEVOURER, mainHandStack);
                ((PlayerEntity)user).addExperience(level * 4);
                target.world.playSound(
                        null,
                        target.getX(),
                        target.getY(),
                        target.getZ(),
                        SoundEvents.PARTICLE_SOUL_ESCAPE,
                        SoundCategory.PLAYERS,
                        0.5F,
                        1.0F);



            }
        }
    }
}
