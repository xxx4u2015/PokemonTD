package com.xkings.pokemontd.system.abilitySytems.projectile;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.math.Vector3;
import com.xkings.core.component.*;
import com.xkings.pokemontd.component.attack.ProjectileAttackComponent;
import com.xkings.pokemontd.manager.ProjectileManager;
import com.xkings.pokemontd.system.ClosestEnemySystem;

/**
 * Created by Tomas on 10/4/13.
 */
public class FireProjectilSystem extends EntityProcessingSystem {

    private final ClosestEnemySystem closestEnemySystem;
    private final ProjectileManager projectileManager;
    @Mapper
    ComponentMapper<SpeedComponent> speedMapper;
   @Mapper
    ComponentMapper<ProjectileAttackComponent> projectileMapper;
    @Mapper
    ComponentMapper<PositionComponent> positionMapper;
    @Mapper
    ComponentMapper<RangeComponent> rangeMapper;
    @Mapper
    ComponentMapper<TimeComponent> timeMapper;


    public FireProjectilSystem(ClosestEnemySystem closestEnemySystem, ProjectileManager projectileManager) {
        super(Aspect.getAspectForAll(TimeComponent.class, SpeedComponent.class, ProjectileAttackComponent.class,
                PositionComponent.class));
        this.closestEnemySystem = closestEnemySystem;
        this.projectileManager = projectileManager;
    }


    @Override
    protected void process(Entity entity) {
        Time time = timeMapper.get(entity).getTime();
        float speed = speedMapper.get(entity).getSpeed();

        time.increase(world.getDelta());
        while (time.getAvailableTime() >= speed) {
            time.decrease(speed);
            run(entity);
        }
    }

    private void run(Entity entity) {
        Vector3 position = positionMapper.get(entity).getPoint();
        float range = rangeMapper.get(entity).getRange();

        closestEnemySystem.start(entity, position, range);
        Entity closestEnemy = closestEnemySystem.getClosestEntity();
        if (closestEnemy != null) {
            Vector3 closestEnemyPosition = positionMapper.get(closestEnemy).getPoint();
            ProjectileAttackComponent projectileType = projectileMapper.get(entity);
           projectileManager.createProjectile(projectileType, position, closestEnemyPosition, closestEnemy);
        }
    }

}