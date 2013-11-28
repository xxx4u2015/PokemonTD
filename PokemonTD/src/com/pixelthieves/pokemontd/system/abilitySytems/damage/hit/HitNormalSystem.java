package com.pixelthieves.pokemontd.system.abilitySytems.damage.hit;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.pixelthieves.pokemontd.component.HealthComponent;
import com.pixelthieves.pokemontd.component.attack.projectile.data.NormalData;

/**
 * Created by Seda on 10/4/13.
 */
public class HitNormalSystem extends HitSystem<NormalData> {

    @Mapper
    ComponentMapper<HealthComponent> healthMapper;

    public HitNormalSystem() {
        super(NormalData.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        // DISCUS this on stackoverflow !
        setAoe(new AoeSystem() {
        });

    }

    @Override
    protected void hit(NormalData effectData, Entity e, Entity target) {
        float damage = damageMapper.get(e).getDamage();
        HealthComponent healthComponent = healthMapper.getSafe(target);
        if (healthComponent != null) {
            healthComponent.getHealth().decease((int) damage);
        }
    }

}
