package com.xkings.pokemontd.component.attack.projectile;

import com.xkings.pokemontd.component.attack.AbilityComponent;

/**
 * Created by Tomas on 10/25/13.
 */
public class BuffAbility extends AbilityComponent {
    private final Type type;
    private final float ratio;
    private final float duration;

    public BuffAbility(Type type, float ratio, float duration) {
        this.type = type;
        this.ratio = ratio;
        this.duration = duration;
    }

    public enum Type {
        SPEED, DAMAGE, RANGE;
    }

    public static BuffAbility getDamage(float ratio, float duration) {
        return new BuffAbility(Type.DAMAGE, ratio, duration);
    }

    public Type getType() {
        return type;
    }

    public float getRatio() {
        return ratio;
    }

    public float getDuration() {
        return duration;
    }
}