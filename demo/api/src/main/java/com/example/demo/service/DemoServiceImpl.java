package com.example.demo.service;

import com.example.demo.dao.DemoDao;
import com.example.demo.dto.DemoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoDao demoDao;

    @Override
    public DemoDto getById(String id) {
        return new DemoDto(id, "Ednaldo");
    }

    @Override
    public List<DemoDto> getAll() {
        return demoDao.findAll();
    }
}
