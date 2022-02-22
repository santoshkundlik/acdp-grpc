package com.acdp.service;
import com.acdp.grpc.Score;
import io.grpc.stub.StreamObserver;

public class ScoreRequestObserver implements StreamObserver<Score.ScoreRequest> {

    private final int runsTarget = 15;
    private final int totalBalls = 6;

    private int totalRunsScored;
    private final StreamObserver<Score.ScoreResponse> scoreResponseStreamObserver;

    public ScoreRequestObserver(StreamObserver<Score.ScoreResponse> scoreResponseStreamObserver) {
        this.scoreResponseStreamObserver = scoreResponseStreamObserver;
    }

    @Override
    public void onNext(Score.ScoreRequest scoreRequest) {
        this.totalRunsScored = this.totalRunsScored + scoreRequest.getRunsScored();
        int runsToWin = Math.max(0, runsTarget - this.totalRunsScored);
        int remainingBalls = Math.max(0, totalBalls - scoreRequest.getBallNumber());

        // the match is over
        if(runsToWin == 0 || remainingBalls ==0){
            this.scoreResponseStreamObserver.onNext(Score.ScoreResponse.getDefaultInstance());
            return;
        }

        //Required Run Rate = (Runs required to win / Balls Remaining) x 6.0
        double requiredRunRate = ((double) runsToWin / (double) remainingBalls) * 6.0 ;

        Score.ScoreResponse scoreResponse = Score.ScoreResponse.newBuilder()
                .setRemainingBalls(remainingBalls)
                .setRunsToWin(runsToWin)
                .setRequiredRunRate(requiredRunRate)
                .build();
        this.scoreResponseStreamObserver.onNext(scoreResponse);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {
        this.scoreResponseStreamObserver.onCompleted();
        System.out.println("Match is Over");
    }

}
