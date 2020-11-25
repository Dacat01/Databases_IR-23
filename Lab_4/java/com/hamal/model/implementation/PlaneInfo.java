package com.hamal.model.implementation;

import com.hamal.model.BasicModel;


public class PlaneInfo implements  BasicModel  {

    private Integer planeId;
    private String planeIdentifier;
    private String type;
    private Integer totalHours;
    private Integer maximumSpeed;

    public PlaneInfo(final Integer planeId, final String planeIdentifier, final String type,final Integer totalHours,final Integer maximumSpeed) {
        this.planeId = planeId;
        this.planeIdentifier = planeIdentifier;
        this.type = type;
        this.totalHours = totalHours;
        this.maximumSpeed = maximumSpeed;
    }

    public final Integer getId() {return null;}

    public final Integer getplaneId() {
        return planeId;
    }
    public final void setPlaneId(final Integer planeId) {
        this.planeId = planeId;
    }

    public final String getPlaneIdentifier() {
        return planeIdentifier;
    }
    public final void setPlaneIdentifier(final String planeIdentifier) {
        this.planeIdentifier = planeIdentifier;
    }

    public final String getType() {
        return type;
    }
    public final void setType(final String type) {
        this.type = type;
    }

    public final Integer getTotalHours() {
        return totalHours;
    }
    public final void setTotalHours(final Integer totalHours) {
        this.totalHours = totalHours;
    }

    public final Integer getMaximumSpeed() {
        return maximumSpeed;
    }
    public final void setMaximumSpeed(final Integer maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    @Override
    public final String toString() {
        return "{"
                + "Plane ID = " + planeId
                + ", Identifier = " + planeIdentifier
                + ", Type = " + type
                + ", Total hours = " + totalHours
                + ", Maximum speed = " + maximumSpeed
                +'}';
    }
}
