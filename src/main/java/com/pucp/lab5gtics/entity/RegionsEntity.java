package com.pucp.lab5gtics.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "regions", schema = "hr", catalog = "")
public class RegionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "region_id")
    private int regionId;
    @Basic
    @Column(name = "region_name")
    private String regionName;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionsEntity that = (RegionsEntity) o;
        return regionId == that.regionId && Objects.equals(regionName, that.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, regionName);
    }
}
