package com.example.safak.starwars.pojos;

import java.util.List;

/**
 * Created by Safak on 12.07.2017.
 */

public class RequestBodyPeople {

   public int count;
   public List<PeopleInfo> results;

    public RequestBodyPeople(int count, List<PeopleInfo> results) {
        this.count = count;
        this.results = results;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PeopleInfo> getResults() {
        return results;
    }

    public void setResults(List<PeopleInfo> results) {
        this.results = results;
    }
}
