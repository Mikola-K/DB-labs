package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.Energy;

public class EnergyDaoImpl extends AbstractDaoImpl<Energy, Integer> {
    public EnergyDaoImpl() {
        super(Energy.class);
    }
}
