package com.abhi.sample_assignment;

import com.abhi.sample_assignment.service.QueueService;
import org.mockito.junit.jupiter.MockitoExtension;
import com.abhi.sample_assignment.entity.Request;
import com.abhi.sample_assignment.repository.RequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QueueServiceTest {
        @Mock
        private RequestRepository requestRepository;

        @InjectMocks
        private QueueService queueService;

        @Test
        void shouldEnqueueRequest() {
            Request request = new Request();

            queueService.enqueue(request);

            verify(requestRepository, times(1)).save(request);
        }

        @Test
        void shouldDequeueRequest() throws InterruptedException {
            Request request = new Request();

            queueService.enqueue(request);
            Request result = queueService.dequeue();

            assertNotNull(result);
        }
    }

