package chronosacaria.mcdw.enums;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.items.ItemsInit;
import net.minecraft.item.Item;

import java.util.EnumMap;
import java.util.HashMap;

public enum SwordsID implements McdwWeaponID {
    SWORD_BEESTINGER,
    SWORD_BROADSWORD,
    SWORD_BROKEN_SAWBLADE,
    SWORD_CLAYMORE,
    SWORD_CORAL_BLADE,
    SWORD_CUTLASS,
    SWORD_DANCERS_SWORD,
    SWORD_DARK_KATANA,
    SWORD_DIAMOND_SWORD_VAR,
    SWORD_FREEZING_FOIL,
    SWORD_FROST_SLAYER,
    SWORD_GREAT_AXEBLADE,
    SWORD_HAWKBRAND,
    SWORD_HEARTSTEALER,
    SWORD_IRON_SWORD_VAR,
    SWORD_KATANA,
    SWORD_MASTERS_KATANA,
    SWORD_MECHANIZED_SAWBLADE,
    SWORD_NAMELESS_BLADE,
    SWORD_OBSIDIAN_CLAYMORE,
    SWORD_RAPIER,
    SWORD_SINISTER,
    SWORD_SPONGE_STRIKER,
    SWORD_THE_STARLESS_NIGHT;

    public EnumMap<? extends Enum<?>, ? extends Item> getItemsEnum() {
        return ItemsInit.swordItems;
    }

    public HashMap<? extends Enum<?>, Float> getSpawnRates() {
        return Mcdw.CONFIG.mcdwNewlootConfig.swordSpawnRates;
    }

    public HashMap<? extends Enum<?>, Boolean> getEnabledItems(){
        return Mcdw.CONFIG.mcdwEnableItemsConfig.swordsEnabled;
    }
}