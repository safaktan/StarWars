package com.example.safak.starwars.pojos;

import java.util.List;

/**
 * Created by Safak on 12.07.2017.
 */

public class PeopleInfoEvent {
    public List<PeopleInfo> peopleInfoEventList;

    public PeopleInfoEvent(List<PeopleInfo> peopleInfoEventList) {
        this.peopleInfoEventList = peopleInfoEventList;
    }

    public List<PeopleInfo> getPeopleInfoEventList() {
        return peopleInfoEventList;
    }

    public void setPeopleInfoEventList(List<PeopleInfo> peopleInfoEventList) {
        this.peopleInfoEventList = peopleInfoEventList;
    }
}
