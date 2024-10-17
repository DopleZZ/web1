import java.io.IOException;
import java.util.logging.Logger;




public class Dot {

    final Logger logger = LoggerConfig.getLogger(this.getClass().getName());
    private final int x;
    private final double y;
    private final double r;

    private  boolean isValidData;


    public Dot(int x, double y, double r, boolean isValidData) throws IOException {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isValidData = isValidData;
        logger.info("new dot created");
    }





    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isValidData() {
        return isValidData;
    }



    public void setValidData(boolean validData) {
        isValidData = validData;
    }
}
