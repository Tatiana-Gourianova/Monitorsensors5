package com.gourianova.binocularvision;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Sensor")
@Table(
        name = "sensors",
        uniqueConstraints = {
                @UniqueConstraint(name = "sensors_id_unique", columnNames = "id")
        }
)
public class Sensor{
    @Id
    @SequenceGenerator(
            name ="sensors_sequence",
            sequenceName = "sensors_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator ="sensors_sequence"
    )
    @Column(
            name = "id"
    )
        private int id;
    @Column(
            name = "Name",
            nullable = false
    )
    private String name;
    @Column(
            name = "Model",
            nullable = false
    )
    private String model;
    @Column(
            name = "Range_from",
            nullable = false
    )
    private Integer range_from;
    @Column(
            name = "Range_to",
            nullable = false
    )

    private Integer range_to;

    @Column(
            name = "Type",
            nullable = false
    )

    private String type;

    @Column(
            name = "Unit",
            nullable = false
    )

    private String unit;
    @Column(
            name = "Location",
            nullable = false
    )

    private String location;
    @Column(
            name = "Description"
    )

    private String description;


    public Sensor() {
    }

    public Sensor(int id,
                  String name,
                  String model,
                  int range_from,
                  int range_to,
                  String type,
                  String unit,
                  String location,
                  String description) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.range_from = range_from;
        this.range_to = range_to;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public Sensor(String name, String model, Integer range_from, Integer range_to, String type, String unit, String location, String description) {
        this.name = name;
        this.model = model;
        this.range_from = range_from;
        this.range_to = range_to;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRange_from() {
        return range_from;
    }

    public void setRange_from(int range_from) {
        this.range_from = range_from;
    }

    public int getRange_to() {
        return range_to;
    }

    public void setRange_to(int range_to) {
        this.range_to = range_to;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sensor)) return false;
        Sensor sensor = (Sensor) o;
        return getId() == sensor.getId() &&
                Objects.equals(getName(), sensor.getName()) &&
                Objects.equals(getModel(), sensor.getModel()) &&
                Objects.equals(getType(), sensor.getType()) &&
                Objects.equals(getUnit(), sensor.getUnit()) &&
                getRange_from() == sensor.getRange_from() &&
                getRange_to() == sensor.getRange_to() &&
                Objects.equals(getLocation(), sensor.getLocation()) &&
                Objects.equals(getDescription(), sensor.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getModel(), getRange_from(), getRange_to(), getType(),getUnit(),getLocation(), getDescription());
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", Name='" + name +
                ", Model='" + model +
                ", Range_from='" + range_from +
                ", Range_to='" + range_to +
                ", Type='" + type +
                ", Unit='"+unit+
                ", Location='" + location +
                ", Description='" + description +
                '}' + super.toString();
    }
}