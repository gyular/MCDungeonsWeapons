package chronosacaria.mcdw.enums;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.items.ItemsInit;
import net.minecraft.item.Item;

import java.util.EnumMap;
import java.util.HashMap;

public enum SpearsID implements McdwWeaponID {
    SPEAR_SPEAR,
    SPEAR_WHISPERING_SPEAR,
    SPEAR_FORTUNE;

    public EnumMap<? extends Enum<?>, ? extends Item> getItemsEnum() {
        return ItemsInit.spearItems;
    }

    public HashMap<? extends Enum<?>, Float> getSpawnRates() {
        return Mcdw.CONFIG.mcdwNewlootConfig.spearSpawnRates;
    }

    public HashMap<? extends Enum<?>, Boolean> getEnabledItems(){
        return Mcdw.CONFIG.mcdwEnableItemsConfig.spearsEnabled;
    }
}
