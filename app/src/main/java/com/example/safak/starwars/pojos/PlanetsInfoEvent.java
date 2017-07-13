package com.example.safak.starwars.pojos;

import java.util.List;

/**
 * Created by Koray on 13.07.2017.
 */

public class PlanetsInfoEvent {
    public List<PlanetsInfo> planetsInfoEventList;

    public PlanetsInfoEvent(List<PlanetsInfo> planetsInfoEventList) {
        this.planetsInfoEventList = planetsInfoEventList;
    }

    public List<PlanetsInfo> getPlanetsInfoEventList() {
        return planetsInfoEventList;
    }

    public void setPlanetsInfoEventList(List<PlanetsInfo> planetsInfoEventList) {
        this.planetsInfoEventList = planetsInfoEventList;
    }
}
