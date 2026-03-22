package com.abhi.sample_assignment;

import com.abhi.sample_assignment.service.QueueService;
import com.abhi.sample_assignment.service.ScheduledService;
import org.mockito.junit.jupiter.MockitoExtension;
import com.abhi.sample_assignment.entity.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ScheduledServiceTest {
    @ExtendWith(MockitoExtension.class)

        @Mock
        private QueueService queueService;
        @InjectMocks
        private ScheduledService scheduledService;

        @Test
        void shouldProcessQueue_whenRequestExists() throws Exception {
            Request request = new Request();

            when(queueService.dequeue()).thenReturn(request);

            scheduledService.processQueue();

            verify(queueService, times(1)).dequeue();
        }

        @Test
        void shouldNotProcess_whenQueueEmpty() throws Exception {
            when(queueService.dequeue()).thenReturn(null);

            scheduledService.processQueue();

            verify(queueService, times(1)).dequeue();
        }
    }

