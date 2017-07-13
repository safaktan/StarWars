package com.example.safak.starwars.pojos;

import java.util.List;

/**
 * Created by Koray on 13.07.2017.
 */

public class RequestBodyPlanets {
    public int count;
    public List<PlanetsInfo> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PlanetsInfo> getResults() {
        return results;
    }

    public void setResults(List<PlanetsInfo> results) {
        this.results = results;
    }

    public RequestBodyPlanets(int count, List<PlanetsInfo> results) {

        this.count = count;
        this.results = results;
    }
}
