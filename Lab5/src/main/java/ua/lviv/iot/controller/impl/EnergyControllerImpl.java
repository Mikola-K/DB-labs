package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.EnergyDaoImpl;
import ua.lviv.iot.model.entity.Energy;

public class EnergyControllerImpl extends AbstractControllerImpl<Energy> {
    public EnergyControllerImpl(){
        super(new EnergyDaoImpl());
    }
}