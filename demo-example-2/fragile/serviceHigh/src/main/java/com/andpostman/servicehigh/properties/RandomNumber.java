package com.andpostman.servicehigh.properties;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.SplittableRandom;

@Data
public class RandomNumber implements Serializable {

    private double number;
    private String comment;

    public RandomNumber() {
        this.number = new SplittableRandom().nextInt(1,100);
        this.comment = "выполнено";
    }

    public RandomNumber(double number){
        this.number = number;
        this.comment = "выполнено";
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("Result:")
                .append(number)
                .append(comment)
                .toString();
    }

}
