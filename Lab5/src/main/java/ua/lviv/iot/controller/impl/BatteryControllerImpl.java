package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.BatteryDaoImpl;
import ua.lviv.iot.model.entity.Battery;

public class BatteryControllerImpl extends AbstractControllerImpl<Battery> {
    public BatteryControllerImpl(){
        super(new BatteryDaoImpl());
    }
}