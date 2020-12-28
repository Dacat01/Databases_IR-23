package com.hamal.lab6.domain;

import javax.persistence.*;

@Entity
@Table(name = "plane_info", schema = "hamal_db")
public class PlaneInfo  {
    @Id
    @Column(name = "Plane_id")
    private Integer planeId;
    @Basic
    @Column(name = "plane_identifier")
    private String planeIdentifier;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "total_hrs")
    private Integer totalHrs;
    @Basic
    @Column(name = "max_speed")
    private Integer maxSpeed;
    @OneToOne
    @JoinColumn(name = "Plane_id", referencedColumnName = "id", nullable = false)
    private Plane planeByPlaneId;


    public Integer getPlaneId() {
        return planeId;
    }
    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

    public String getPlaneIdentifier() {
        return planeIdentifier;
    }
    public void setPlaneIdentifier(String planeIdentifier) {
        this.planeIdentifier = planeIdentifier;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Integer getTotalHrs() {
        return totalHrs;
    }
    public void setTotalHrs(Integer totalHrs) {
        this.totalHrs = totalHrs;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
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
        if (totalHrs != null ? !totalHrs.equals(planeInfo.totalHrs) : planeInfo.totalHrs != null) return false;
        if (maxSpeed != null ? !maxSpeed.equals(planeInfo.maxSpeed) : planeInfo.maxSpeed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planeId != null ? planeId.hashCode() : 0;
        result = 31 * result + (planeIdentifier != null ? planeIdentifier.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (totalHrs != null ? totalHrs.hashCode() : 0);
        result = 31 * result + (maxSpeed != null ? maxSpeed.hashCode() : 0);
        return result;
    }


    public Plane getPlaneByPlaneId() {
        return planeByPlaneId;
    }
    public void setPlaneByPlaneId(Plane planeByPlaneId) {
        this.planeByPlaneId = planeByPlaneId;
    }

    @Override
    public String toString() {
        return "PlaneInfo{" +
                "planeId=" + planeId +
                ", planeIdentifier='" + planeIdentifier + '\'' +
                ", type='" + type + '\'' +
                ", totalHrs=" + totalHrs +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

}