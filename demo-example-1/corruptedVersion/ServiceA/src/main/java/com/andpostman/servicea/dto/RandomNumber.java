package com.andpostman.servicea.dto;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.SplittableRandom;

@Data
public class RandomNumber {

    private int number;
    private String comment;

    public RandomNumber() {
        this.number = new SplittableRandom().nextInt(1,6);
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


