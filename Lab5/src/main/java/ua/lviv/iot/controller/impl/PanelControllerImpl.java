package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.PanelDaoImpl;
import ua.lviv.iot.model.entity.Panel;

public class PanelControllerImpl extends AbstractControllerImpl<Panel> {
    public PanelControllerImpl(){
        super(new PanelDaoImpl());
    }
}