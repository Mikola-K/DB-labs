package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.AdressDaoImpl;
import ua.lviv.iot.model.entity.Adress;

public class AdressControllerImpl extends AbstractControllerImpl<Adress> {
    public AdressControllerImpl(){
        super(new AdressDaoImpl());
    }
}