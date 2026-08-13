package com.example.demo.service;

import com.example.demo.dto.DemoDto;

import java.util.List;

public interface DemoService {
    DemoDto getById(String id);
    List<DemoDto> getAll();
}
