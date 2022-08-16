package chronosacaria.mcdw.enums;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.bases.McdwSoulDagger;
import chronosacaria.mcdw.configs.McdwNewStatsConfig;
import chronosacaria.mcdw.items.ItemsInit;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;

import java.util.EnumMap;
import java.util.HashMap;

import static chronosacaria.mcdw.Mcdw.CONFIG;

public enum SoulDaggersID implements IMcdwWeaponID, IMeleeWeaponID {
    DAGGER_ETERNAL_KNIFE(ToolMaterials.NETHERITE,4, -0.9f, "minecraft:netherite_scrap"),
    DAGGER_SOUL_KNIFE(ToolMaterials.IRON,1, -1.1f, "minecraft:iron_ingot"),
    SWORD_TRUTHSEEKER(ToolMaterials.NETHERITE,3, -1.5f, "minecraft:netherite_scrap");

    private final ToolMaterial material;
    private final int damage;
    private final float attackSpeed;
    private final String[] repairIngredient;


    SoulDaggersID(ToolMaterial material, int damage, float attackSpeed, String... repairIngredient) {
        this.material = material;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.repairIngredient = repairIngredient;
    }

    public static HashMap<SoulDaggersID, Boolean> getEnabledItems(){
        return Mcdw.CONFIG.mcdwEnableItemsConfig.soulDaggersEnabled;
    }

    public static EnumMap<SoulDaggersID, McdwSoulDagger> getItemsEnum() {
        return ItemsInit.soulDaggerItems;
    }

    public static HashMap<SoulDaggersID, Integer> getSpawnRates() {
        return Mcdw.CONFIG.mcdwNewlootConfig.soulDaggerSpawnRates;
    }

    public static HashMap<SoulDaggersID, MeleeStats> getWeaponStats() {
        return CONFIG.mcdwNewStatsConfig.soulDaggerStats;
    }

    @Override
    public Boolean isEnabled(){
        return getEnabledItems().get(this);
    }

    @Override
    public McdwSoulDagger getItem() {
        return getItemsEnum().get(this);
    }

    @Override
    public Integer getItemSpawnRate() {
        return getSpawnRates().get(this);
    }

    @Override
    public HashMap<SoulDaggersID, MeleeStats> getWeaponStats(McdwNewStatsConfig mcdwNewStatsConfig) {
        return mcdwNewStatsConfig.soulDaggerStats;
    }

    @Override
    public MeleeStats getWeaponItemStats() {
        return getWeaponStats().get(this);
    }

    @Override
    public MeleeStats getWeaponItemStats(McdwNewStatsConfig mcdwNewStatsConfig) {
        return mcdwNewStatsConfig.soulDaggerStats.get(this);
    }

    @Override
    public ToolMaterial getMaterial(){
        return material;
    }

    @Override
    public int getDamage(){
        return damage;
    }

    @Override
    public float getAttackSpeed(){
        return attackSpeed;
    }

    @Override
    public String[] getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public McdwSoulDagger makeWeapon() {
        McdwSoulDagger mcdwSoulDagger = new McdwSoulDagger(ItemsInit.stringToMaterial(this.getWeaponItemStats().material),
                this.getWeaponItemStats().damage, this.getWeaponItemStats().attackSpeed, this.getWeaponItemStats().repairIngredient);

        getItemsEnum().put(this, mcdwSoulDagger);
        return mcdwSoulDagger;
    }
}