package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.Battery;

public class BatteryDaoImpl extends AbstractDaoImpl<Battery, Integer> {
    public BatteryDaoImpl() {
        super(Battery.class);
    }
}

