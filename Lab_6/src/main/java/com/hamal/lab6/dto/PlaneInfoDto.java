package com.hamal.lab6.dto;


import com.hamal.lab6.domain.PlaneInfo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class PlaneInfoDto {

    private Integer planeId;
    private String planeIdentifier;
    private String type;
    private Integer totalHrs;
    private Integer maxSpeed;

    public PlaneInfoDto(Integer planeId, String planeIdentifier, String type,Integer totalHrs,Integer maxSpeed) {
        this.planeId = planeId;
        this.planeIdentifier = planeIdentifier;
        this.type = type;
        this.totalHrs = totalHrs;
        this.maxSpeed = maxSpeed;
    }

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

}
