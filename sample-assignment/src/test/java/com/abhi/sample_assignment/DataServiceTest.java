package com.abhi.sample_assignment;

import com.abhi.sample_assignment.entity.Request;
import com.abhi.sample_assignment.repository.RequestRepository;
import com.abhi.sample_assignment.service.DataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DataServiceTest {

        @Mock
        private RequestRepository requestRepository;

        @InjectMocks
        private DataService dataService;

        @Test
        void shouldReturnRequest_whenIdExists() {
            Request request = new Request();
            request.setId(1L);

            when(requestRepository.findById(1L))
                    .thenReturn(Optional.of(request));

            Request result = dataService.getData(1L);

            assertEquals(1L, result.getId());
        }

        @Test
        void shouldThrowException_whenRequestNotFound() {
            when(requestRepository.findById(1L))
                    .thenReturn(Optional.empty());

            assertThrows(RuntimeException.class, () -> {
                dataService.getData(1L);
            });
        }
    }

