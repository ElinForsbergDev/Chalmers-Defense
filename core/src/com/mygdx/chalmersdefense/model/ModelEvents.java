package com.mygdx.chalmersdefense.model;

import com.mygdx.chalmersdefense.model.event.IEvent;

public class ModelEvents implements IEvent {

    private final Type eventType;
    private final int amount;

    public enum Type{
        ADDTOPLAYER
    }
    public ModelEvents(Type eventType, int amount) {
        this.eventType = eventType;
        this.amount = amount;
    }

    public Type getEventType() {
        return eventType;
    }

    public int getAmount() {
        return amount;
    }
}
