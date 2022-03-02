package com.acdp.client;

import com.acdp.grpc.scoreGrpc;
import com.acdp.grpc.Score.ScoreRequest;
import com.acdp.service.ScoreService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ScoringTest {

    private ManagedChannel channel;
    private scoreGrpc.scoreStub clientStub;

    /*The server runs on the port 9099*/
    Server server = ServerBuilder.forPort(9099).addService(new ScoreService()).build();

    @Before
    public void setup() throws IOException, InterruptedException {

        server.start();
        Thread.sleep(1000);

        this.channel = ManagedChannelBuilder.forAddress("localhost", 9099)
                .usePlaintext()
                .build();
        this.clientStub = scoreGrpc.newStub(channel);
    }

    @Test
    public void scoreTest() throws InterruptedException {
        ScoreResponseStreamObserver scoreResponseStreamObserver = new ScoreResponseStreamObserver();
        StreamObserver<ScoreRequest> requestStreamObserver = this.clientStub.scoring(scoreResponseStreamObserver);
        scoreResponseStreamObserver.startGame(requestStreamObserver);

        // just for testing
        Thread.sleep(10000);
        server.shutdown();
    }

    @After
    public void teardown(){
        this.channel.shutdown();
    }
}
