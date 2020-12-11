package com.hamal.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "plane_info", schema = "hamal_db", catalog = "")
public class PlaneInfo {
    private Integer planeId;
    private String planeIdentifier;
    private String type;
    private Integer totalHrs;
    private Integer maxSpeed;
    private Plane planeByPlaneId;

    @Id
    @Column(name = "Plane_id")
    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
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
    @Column(name = "total_hrs")
    public Integer getTotalHrs() {
        return totalHrs;
    }

    public void setTotalHrs(Integer totalHrs) {
        this.totalHrs = totalHrs;
    }

    @Basic
    @Column(name = "max_speed")
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

    @OneToOne
    @JoinColumn(name = "Plane_id", referencedColumnName = "id", nullable = false)
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
                ", planeByPlaneId=" + planeByPlaneId +
                '}';
    }
}
