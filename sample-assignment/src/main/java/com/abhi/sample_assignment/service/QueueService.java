package com.abhi.sample_assignment.service;

import com.abhi.sample_assignment.entity.Request;
import com.abhi.sample_assignment.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
@Service
public class QueueService {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();
    private final RequestRepository requestRepository;
    public QueueService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
    public void enqueue(Request request){
        requestRepository.save(request);
        queue.add(request);
    }
    public Request dequeue() throws InterruptedException{
        return queue.poll();
    }

}
