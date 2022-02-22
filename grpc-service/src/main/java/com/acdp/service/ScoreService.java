package com.acdp.service;

import io.grpc.stub.StreamObserver;
import com.acdp.grpc.Score;
import com.acdp.grpc.scoreGrpc;

public class ScoreService extends scoreGrpc.scoreImplBase {

    @Override
    public StreamObserver<Score.ScoreRequest> scoring(StreamObserver<Score.ScoreResponse> responseObserver) {
        return new ScoreRequestObserver(responseObserver);
    }

}
