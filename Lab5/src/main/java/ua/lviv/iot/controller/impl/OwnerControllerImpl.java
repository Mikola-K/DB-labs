package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.OwnerDaoImpl;
import ua.lviv.iot.model.entity.Owner;

public class OwnerControllerImpl extends AbstractControllerImpl<Owner> {
    public OwnerControllerImpl(){
        super(new OwnerDaoImpl());
    }
}