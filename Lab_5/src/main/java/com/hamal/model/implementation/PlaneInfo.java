package com.hamal.model.implementation;


import javax.persistence.*;

import com.hamal.model.BasicModel;


public class PlaneInfo implements  BasicModel  {

    private Integer planeId;
    private String planeIdentifier;
    private String type;
    private Integer totalHours;
    private Integer maximumSpeed;


    public final Integer getId() {return null;}

    public PlaneInfo(final Integer planeId, final String planeIdentifier, final String type,final Integer totalHours,final Integer maximumSpeed) {
        this.planeId = planeId;
        this.planeIdentifier = planeIdentifier;
        this.type = type;
        this.totalHours = totalHours;
        this.maximumSpeed = maximumSpeed;
    }

    @Id
    @Column(name = "Plane_id")
    public Integer getplaneId() {
        return planeId;
    }

    public void setplaneId(Integer planeId) {
        this.planeId = planeId;
    }

    @Basic
    @Column(name = "plane_identifier")
    public String getPlaneIdentifier() {
        return planeIdentifier;
    }

    public void setPlaneIdentifier(String planeIdentifier) {
        this.planeIdentifier = planeIdentifier;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "total_hours")
    public Integer getTotalHours() {
        return totalHours;
    }

    public void getTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    @Basic
    @Column(name = "max_speed")
    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(Integer maxSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaneInfo planeInfo = (PlaneInfo) o;

        if (planeId != null ? !planeId.equals(planeInfo.planeId) : planeInfo.planeId != null) return false;
        if (planeIdentifier != null ? !planeIdentifier.equals(planeInfo.planeIdentifier) : planeInfo.planeIdentifier != null)
            return false;
        if (type != null ? !type.equals(planeInfo.type) : planeInfo.type != null) return false;
        if (totalHours != null ? !totalHours.equals(planeInfo.totalHours) : planeInfo.totalHours != null) return false;
        if (maximumSpeed != null ? !maximumSpeed.equals(planeInfo.maximumSpeed) : planeInfo.maximumSpeed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planeId != null ? planeId.hashCode() : 0;
        result = 31 * result + (planeIdentifier != null ? planeIdentifier.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (totalHours != null ? totalHours.hashCode() : 0);
        result = 31 * result + (maximumSpeed != null ? maximumSpeed.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlaneInfo{" +
                "planeId=" + planeId +
                ", planeIdentifier='" + planeIdentifier + '\'' +
                ", type='" + type + '\'' +
                ", totalHrs=" + totalHours +
                ", maxSpeed=" + maximumSpeed +
                '}';
    }

}
