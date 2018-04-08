package services;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import controller.IMPLEMENTING;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class implementhandler implements HttpHandler{

    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        IMPLEMENTING ild = new IMPLEMENTING();
        String query = exchange.getRequestURI().getQuery();
        Map<String, String> mappie = queryToMap(query);
        int id = Integer.parseInt(mappie.get("id"));
        String type = mappie.get("type");
        if (requestMethod.equalsIgnoreCase("PUT")) {
            System.out.println("put");

            ild.update(id,type);
        }
        else if (requestMethod.equalsIgnoreCase("DELETE")){
             ild.delete(id,type);
            System.out.println("delete");
        }
        else if (requestMethod.equalsIgnoreCase("POST")){
            System.out.println("POST");
            ild.create(id,type);
        }
        String response = "succes";
        exchange.sendResponseHeaders(200,response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
    public Map<String, String> queryToMap(String query){
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length>1) {
                result.put(pair[0], pair[1]);
            }else{
                result.put(pair[0], "");
            }
        }
        return result;
    }

}
