package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.SolarSystemDaoImpl;
import ua.lviv.iot.model.entity.SolarSystem;

public class SolarSystemControllerImpl extends AbstractControllerImpl<SolarSystem> {
    public SolarSystemControllerImpl(){
        super(new SolarSystemDaoImpl());
    }
}