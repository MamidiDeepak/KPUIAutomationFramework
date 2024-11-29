package org.KPUIFramework.asserts;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertClass {

    public static void testStatusCode(Integer actual, Integer expected){
        assertThat(actual).isEqualTo(expected);
    }

    public static void testStatusLine(String actual, String expected){
        assertThat(actual).isEqualTo(expected);
    }

    public static void testContentType(String actual, String expected){
        assertThat(actual).isEqualTo(expected);
    }

    public static void testResponseTime(Long actual, Long expected){
        assertThat(actual).isLessThan(expected);
    }
}
