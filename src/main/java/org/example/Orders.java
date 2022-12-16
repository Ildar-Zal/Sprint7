package org.example;

public class Orders {
    private String courierId;
    private String nearestStation;
    private String limit;
    private String page;

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public String getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Orders(String courierId, String nearestStation, String limit, String page) {
        this.courierId = courierId;
        this.nearestStation = nearestStation;
        this.limit = limit;
        this.page = page;
    }
}
