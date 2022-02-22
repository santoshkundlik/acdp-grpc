package com.acdp.server;

import com.acdp.service.ScoreService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * GRPC Server that manager startup/shutdown of a {@code Score} server.
 */
public class GRPCServer {

    public static void main(String args[]) throws IOException, InterruptedException {

        /*The server runs on the port 9091*/
        Server server = ServerBuilder.forPort(9091).addService(new ScoreService()).build();

        server.start();

        System.out.println("Server started on " + server.getPort());

        // shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Scoring server is shutting down!");
            server.shutdown();
        }));

        server.awaitTermination();



    }
}
