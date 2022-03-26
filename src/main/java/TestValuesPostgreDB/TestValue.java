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
    private Integer id;

    @Column (name = "emptyCapWeight")
    @Getter
    @Setter
    private Double emptyCapWeight;

    @Column (name = "fullCapWeight")
    @Getter
    @Setter
    private Double fullCapWeight;

    @Column (name = "hitch")
    @Getter
    @Setter
    private Double hitch;

    @Column (name = "compHeight")
    @Getter
    @Setter
    private Double compHeight;

    @Column (name = "fullHeight")
    @Getter
    @Setter
    private Double fullHeight;

    @Column (name = "actuationTime")
    @Getter
    @Setter
    private Double actuationTime;

    @Column (name = "imas")
    @Getter
    @Setter
    private Double imas;

    @Column (name = "ilin")
    @Getter
    @Setter
    private Double ilin;

    @Column (name = "density")
    @Getter
    @Setter
    private Double density;

    // need to lombok this
    public TestValue(Double emptyCapWeight,
                     Double fullCapWeight,
                     Double hitch,
                     Double compHeight,
                     Double fullHeight,
                     Double actuationTime,
                     Double imas,
                     Double ilin,
                     Double density){
        this.emptyCapWeight = emptyCapWeight;
        this.fullCapWeight = fullCapWeight;
        this.hitch = hitch;
        this.compHeight = compHeight;
        this.fullHeight = fullHeight;
        this.actuationTime = actuationTime;
        this.imas = imas;
        this.ilin = ilin;
        this.density = density;
    }

    public TestValue(){

    }

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