import com.fastcgi.FCGIInterface;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class ResponseSender {

    private final FunctionCalc functionCalc;

    final Logger logger = LoggerConfig.getLogger(this.getClass().getName());

    private final RequestHandler requestHandler;


    public ResponseSender(FunctionCalc functionCalc, RequestHandler requestHandler) {
        this.functionCalc = functionCalc;
        this.requestHandler = requestHandler;

    }


    public void sendResponse() throws IOException {


        var fcgiInterface = new FCGIInterface();

        logger.info("Waiting for requests...");
        while (fcgiInterface.FCGIaccept() >= 0) {
            var start = System.currentTimeMillis();
            Dot dot = requestHandler.readRequest();
            try {
                var status = functionCalc.isInTheSpot(dot);
                var content = """
                        
                        {        
                            "status" : %s         
                        }
                        
                        """;
                content = content.formatted(status);
                var httpResponse = """
                        HTTP/1.1 200 OK
                        Content-Type: application/json
                        Content-Length: %d
                                                
                        %s
                        """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);

                logger.warning("status: %s".formatted(status));
                System.out.println(httpResponse);
                logger.info("ogo");


            } catch (Exception e) {
                var content = """
                        {
                                            
                        error: %s
                                            
                        }
                        """;
                content = content.formatted(e.getMessage());
                var httpResponse = """
                        HTTP/1.1 400 Bad Request
                        Content-Type: application/json
                        Content-Length: %d
                                                
                        %s
                        """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);
                logger.info("ogo1");
                System.out.println(httpResponse);


            }


        }
    }


}