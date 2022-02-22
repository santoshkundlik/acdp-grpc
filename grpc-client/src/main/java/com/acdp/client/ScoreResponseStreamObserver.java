package com.acdp.client;

import com.google.common.util.concurrent.Uninterruptibles;
import com.acdp.grpc.Score.ScoreRequest;
import com.acdp.grpc.Score.ScoreResponse;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class ScoreResponseStreamObserver implements StreamObserver<ScoreResponse>
{
    private StreamObserver<ScoreRequest> requestStreamObserver;

    private int currentBallNumber;
    private int runsToWin;

    @Override
    public void onNext(ScoreResponse scoreResponse) {

        currentBallNumber = currentBallNumber +1;
        if(scoreResponse.getRemainingBalls() >0 && scoreResponse.getRunsToWin()>0 ){
            print(scoreResponse);
            runsToWin =  scoreResponse.getRunsToWin();
            this.playCricket();
        }else{
            this.requestStreamObserver.onCompleted();
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {
        System.out.println("-------***----------------***-------");
        if(currentBallNumber<=6)
            System.out.println("Match is Over: Batting Team won the match!!");
        else
            System.out.println("Match is Over: Bowling Team won the match by " + runsToWin + " runs!!");

    }

    public void startGame(StreamObserver<ScoreRequest> requestStreamObserver){
        System.out.println("Target Score 15");
        System.out.println("-------***----------------***-------");
        this.requestStreamObserver = requestStreamObserver;
        currentBallNumber = currentBallNumber +1;
        this.playCricket();
    }

    private void playCricket(){

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        ScoreRequest scoreRequest = ScoreRequest.newBuilder()
                .setRunsScored(ThreadLocalRandom.current().nextInt(0, 4))
                .setBallNumber(this.currentBallNumber)
                .build();
        System.out.println("Ball Number: "+ currentBallNumber);
        System.out.println("Runs Scored: "+ scoreRequest.getRunsScored());
        runsToWin =  runsToWin - scoreRequest.getRunsScored();
        requestStreamObserver.onNext(scoreRequest);
    }

    private void print(ScoreResponse scoreResponse){
        System.out.println("Remaining Balls : " + scoreResponse.getRemainingBalls());
        System.out.println("Runs to Win: " + scoreResponse.getRunsToWin());
        System.out.println("Required Run Rate: " + scoreResponse.getRequiredRunRate());
        System.out.println("------------------------------");
    }
}
