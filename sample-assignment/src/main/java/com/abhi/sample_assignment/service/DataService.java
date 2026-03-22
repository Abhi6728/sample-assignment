package com.abhi.sample_assignment.service;

import com.abhi.sample_assignment.entity.Request;
import com.abhi.sample_assignment.repository.RequestRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    private final RequestRepository requestRepository;
    public DataService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
    @Cacheable(value = "requests", key = "#id")
    public Request getData(Long id){
        System.out.println("DB HIT for id = " +id);
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found with id: " + id));
    }

    public List<Request> getAllData() {
        return requestRepository.findAll();
    }
}
