package com.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tracker")
public class Tracker {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    //  @Column(name = "IP")
   // private HttpServletRequest request;

    //@Enumerated(EnumType.STRING)
    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "date", nullable = false)
    private LocalDate localDate;

    public Tracker(String action, LocalDate localDate) {
        this.action = action;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
