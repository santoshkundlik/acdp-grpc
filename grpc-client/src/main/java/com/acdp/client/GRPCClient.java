package com.acdp.client;

import com.acdp.grpc.Score;
import com.acdp.grpc.scoreGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * A GRPC client that sends runs scored & gets runs to win & required run-rate from the Score server.
 */
public class GRPCClient {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel;
        scoreGrpc.scoreStub clientStub;

        channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();
        clientStub = scoreGrpc.newStub(channel);

        ScoreResponseStreamObserver scoreResponseStreamObserver = new ScoreResponseStreamObserver();
        StreamObserver<Score.ScoreRequest> requestStreamObserver = clientStub.scoring(scoreResponseStreamObserver);
        scoreResponseStreamObserver.startGame(requestStreamObserver);

        // just for testing
        Thread.sleep(10000);


    }


}
