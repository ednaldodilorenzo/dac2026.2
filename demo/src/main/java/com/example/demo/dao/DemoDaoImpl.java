package com.example.demo.dao;

import com.example.demo.dto.DemoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemoDaoImpl implements DemoDao {
    @Override
    public List<DemoDto> findAll() {
        return List.of(
                new DemoDto("1", "Ednaldo"),
                new DemoDto("2", "Rodrigo"),
                new DemoDto("3", "Caminas")
        );
    }
}
