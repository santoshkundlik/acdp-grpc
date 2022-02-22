package com.acdp.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: score.proto")
public final class scoreGrpc {

  private scoreGrpc() {}

  public static final String SERVICE_NAME = "score";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.acdp.grpc.Score.ScoreRequest,
      com.acdp.grpc.Score.ScoreResponse> getScoringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "scoring",
      requestType = com.acdp.grpc.Score.ScoreRequest.class,
      responseType = com.acdp.grpc.Score.ScoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.acdp.grpc.Score.ScoreRequest,
      com.acdp.grpc.Score.ScoreResponse> getScoringMethod() {
    io.grpc.MethodDescriptor<com.acdp.grpc.Score.ScoreRequest, com.acdp.grpc.Score.ScoreResponse> getScoringMethod;
    if ((getScoringMethod = scoreGrpc.getScoringMethod) == null) {
      synchronized (scoreGrpc.class) {
        if ((getScoringMethod = scoreGrpc.getScoringMethod) == null) {
          scoreGrpc.getScoringMethod = getScoringMethod = 
              io.grpc.MethodDescriptor.<com.acdp.grpc.Score.ScoreRequest, com.acdp.grpc.Score.ScoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "score", "scoring"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.acdp.grpc.Score.ScoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.acdp.grpc.Score.ScoreResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new scoreMethodDescriptorSupplier("scoring"))
                  .build();
          }
        }
     }
     return getScoringMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static scoreStub newStub(io.grpc.Channel channel) {
    return new scoreStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static scoreBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new scoreBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static scoreFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new scoreFutureStub(channel);
  }

  /**
   */
  public static abstract class scoreImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.acdp.grpc.Score.ScoreRequest> scoring(
        io.grpc.stub.StreamObserver<com.acdp.grpc.Score.ScoreResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getScoringMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScoringMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.acdp.grpc.Score.ScoreRequest,
                com.acdp.grpc.Score.ScoreResponse>(
                  this, METHODID_SCORING)))
          .build();
    }
  }

  /**
   */
  public static final class scoreStub extends io.grpc.stub.AbstractStub<scoreStub> {
    private scoreStub(io.grpc.Channel channel) {
      super(channel);
    }

    private scoreStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected scoreStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new scoreStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.acdp.grpc.Score.ScoreRequest> scoring(
        io.grpc.stub.StreamObserver<com.acdp.grpc.Score.ScoreResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getScoringMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class scoreBlockingStub extends io.grpc.stub.AbstractStub<scoreBlockingStub> {
    private scoreBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private scoreBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected scoreBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new scoreBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class scoreFutureStub extends io.grpc.stub.AbstractStub<scoreFutureStub> {
    private scoreFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private scoreFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected scoreFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new scoreFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SCORING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final scoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(scoreImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCORING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.scoring(
              (io.grpc.stub.StreamObserver<com.acdp.grpc.Score.ScoreResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class scoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    scoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.acdp.grpc.Score.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("score");
    }
  }

  private static final class scoreFileDescriptorSupplier
      extends scoreBaseDescriptorSupplier {
    scoreFileDescriptorSupplier() {}
  }

  private static final class scoreMethodDescriptorSupplier
      extends scoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    scoreMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (scoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new scoreFileDescriptorSupplier())
              .addMethod(getScoringMethod())
              .build();
        }
      }
    }
    return result;
  }
}
