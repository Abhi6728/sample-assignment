package com.abhi.sample_assignment.service;

import com.abhi.sample_assignment.entity.Request;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ScheduledService {
    private final QueueService queueService;
    private final RestTemplate restTemplate = new RestTemplate();

    public ScheduledService(QueueService queueService) {
        this.queueService = queueService;
    }
    @Scheduled(fixedRate = 10000)
    public void processQueue() throws InterruptedException {
        Request request = queueService.dequeue();
        if (request != null) {
            CompletableFuture.runAsync(() -> {
                restTemplate.postForObject("https://webhook.site/355bb31a-ef94-47d4-9bd5-815bcd522c6a", request, String.class);
            });
        }
    }
}