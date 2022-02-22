package com.acdp.client;

import com.acdp.grpc.scoreGrpc;
import com.acdp.grpc.Score.ScoreRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScoringTest {

    private ManagedChannel channel;
    private scoreGrpc.scoreStub clientStub;

    @Before
    public void setup(){
        this.channel = ManagedChannelBuilder.forAddress("localhost", 9091)
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
    }

    @After
    public void teardown(){
        this.channel.shutdown();
    }
}
