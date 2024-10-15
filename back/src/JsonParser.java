import java.util.logging.Logger;

public class JsonParser {
    private static final Logger logger = LoggerConfig.getLogger(JsonParser.class.getName());




    public static Dot parseJson(String json) {
        var elements = json.split(":");


        double[] values = new double[3];
        try {
            values[0] = Integer.parseInt((elements[1].split(",")[0]).replace("\"", ""));
            logger.info(values[0] + "");
            values[1] = Double.parseDouble((elements[2].split(",")[0]).replace("\"", ""));
            logger.info(values[1] + "");
            values[2] = Double.parseDouble((elements[3].replace("\"", "").replace("}","")));
            logger.info(values[2] + "");

            logger.info(values[0] + " " + values[1] + " " + values[2]);

            return new Dot((int) values[0], values[1], (int) values[2], true);
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("gobnishe");
           throw new RuntimeException("Invalid JSON data");
        }

    }



}
