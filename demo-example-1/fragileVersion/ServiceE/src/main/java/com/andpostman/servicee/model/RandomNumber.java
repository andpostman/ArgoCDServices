package com.andpostman.servicee.model;

import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "random_numbers", schema = "demo")
@Immutable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Getter
public class RandomNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number")
    private int number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RandomNumber)) return false;

        RandomNumber that = (RandomNumber) o;

        if (getNumber() != that.getNumber()) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getNumber();
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id",id)
                .append("number",number)
                .toString();
    }
}
