package com.pixelthieves.pokemontd.entity;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.graphics.Color;
import com.pixelthieves.core.component.PositionComponent;
import com.pixelthieves.core.component.RangeComponent;
import com.pixelthieves.core.component.RotationComponent;
import com.pixelthieves.core.component.SizeComponent;
import com.pixelthieves.core.entity.ConcreteEntity;
import com.pixelthieves.pokemontd.component.PathComponent;
import com.pixelthieves.pokemontd.component.SpriteComponent;
import com.pixelthieves.pokemontd.component.TintComponent;
import com.pixelthieves.pokemontd.entity.datatypes.CommonDataType;
import com.pixelthieves.pokemontd.entity.datatypes.StaticObjectType;
import com.pixelthieves.pokemontd.entity.tower.TowerType;

/**
 * Created by Seda on 10/5/13.
 */
public class StaticObject extends ConcreteEntity {

    private StaticObject(CommonDataType commonDataType, World world, float x, float y) {
        super(world);
        addComponent(new PositionComponent(x, y, 0));
        addComponent(new RotationComponent(0, 0, 0));
        addComponent(new PathComponent(null));
        addComponent(new SpriteComponent(commonDataType.getTexture()));
        addComponent(new SizeComponent(commonDataType.getSize(), commonDataType.getSize(), 0));
    }

    public static Entity registerStaticObject(World world, StaticObjectType staticObjectType, float x, float y) {
        StaticObject staticObject = new StaticObject(staticObjectType, world, x, y);
        staticObject.register();
        return staticObject.entity;
    }

    public static Entity registerFakeTower(World world, TowerType towerType, float x, float y, Color tint) {
        StaticObject fakeTower = new StaticObject(towerType, world, x, y);
        fakeTower.addComponent(new RangeComponent(towerType.getRange(), true));
        fakeTower.addComponent(new TintComponent(tint));
        fakeTower.register();
        return fakeTower.entity;
    }
}
