package TestValuesPostgreDB;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "TestValues")
public class TestValue {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Getter
    private int id;

    @Column (name = "emptyCapWeight")
    @Getter
    @Setter
    private double emptyCapWeight;

    @Column (name = "fullCapWeight")
    @Getter
    @Setter
    private double fullCapWeight;

    @Column (name = "hitch")
    @Getter
    @Setter
    private double hitch;

    @Column (name = "compHeight")
    @Getter
    @Setter
    private double compHeight;

    @Column (name = "fullHeight")
    @Getter
    @Setter
    private double fullHeight;

    @Column (name = "actuationTime")
    @Getter
    @Setter
    private double actuationTime;

    @Column (name = "imas")
    @Getter
    @Setter
    private double imas;

    @Column (name = "ilin")
    @Getter
    @Setter
    private double ilin;

    @Column (name = "density")
    @Getter
    @Setter
    private double density;

    public String toString(){
        return "TestValue " +
                "[id=" +id+
                ", emptyCapWeight=" +emptyCapWeight+
                ", fullCapWeight=" +fullCapWeight+
                ", hitch=" +hitch+
                ", compHeight=" +compHeight+
                ", fullHeight=" +fullHeight+
                ", actuationTime=" +actuationTime+
                ", imas=" +imas+
                ", ilin=" +ilin+
                ", density=" +density+ "]";
    }
}
