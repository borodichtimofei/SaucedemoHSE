package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {

    public static Double getPrice(String str) {
        Pattern pattern = Pattern.compile("\\$(\\d+\\.?\\d*)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1));
        }
        return null;
    }
}
