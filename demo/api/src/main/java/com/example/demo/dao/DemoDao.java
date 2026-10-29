package com.example.demo.dao;

import com.example.demo.dto.DemoDto;

import java.util.List;

public interface DemoDao {
    List<DemoDto> findAll();
}
