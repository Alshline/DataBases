package TestValuesPostgreDB.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "TestValues")
@ToString
@Getter
@Setter
public class TestValue extends BaseEntity{

    @Column (name = "emptyCapWeight")
    private Double emptyCapWeight;

    @Column (name = "fullCapWeight")
    private Double fullCapWeight;

    @Column (name = "hitch")
    private Double hitch;

    @Column (name = "compHeight")
    private Double compHeight;

    @Column (name = "fullHeight")
    private Double fullHeight;

    @Column (name = "actuationTime")
    private Double actuationTime;

    @Column (name = "imas")
    private Double imas;

    @Column (name = "ilin")
    private Double ilin;

    @Column (name = "density")
    private Double density;

    // need to lombok this maybe
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
}