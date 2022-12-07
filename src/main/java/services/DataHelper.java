package services;

public class DataHelper {

    public static int ParseToInt(String data) {
        try {
            return Integer.parseInt(data.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
