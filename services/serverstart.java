package services;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class serverstart {

    public static void main(String[] args) throws Exception {
        int port = 9000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);

        server.createContext("/", new Roothandler());
        server.createContext("/businessrule",new implementhandler());
        server.setExecutor(null);
        server.start();
    }

}
