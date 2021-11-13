package net.yoonaxes.auth.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.Validate;

import java.util.Random;

@UtilityClass
public class RandomUtil {

    @Getter (value = AccessLevel.PROTECTED)
    private final Random random = new Random();

    public String randomString(int length, boolean letters, boolean numbers) {
        Validate.isTrue(length > 0, "A length can't be smaller than 1.");
        Validate.isTrue(!(!letters && !numbers), "Random String can't be generated without letters and numbers.");

        return RandomStringUtils.random(length, letters, numbers);
    }

    public Integer randomInteger(int min, int max) {
        Validate.isTrue(max > min, "A min value can't be higher than max value.");

        return getRandom().nextInt(max - min + 1) + min;
    }

    public Double randomDouble(double min, double max) {
        Validate.isTrue(max > min, "A min value can't be higher than max value.");

        return getRandom().nextDouble() * (max - min) + min;
    }

    public Float randomFloat(float min, float max) {
        Validate.isTrue(max > min, "A min value can't be higher than max value.");

        return getRandom().nextFloat() * (max - min) + min;
    }
}
