package com.example.demo.controller;

import com.example.demo.dto.DemoDto;
import com.example.demo.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/demo")
@AllArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/{id}")
    public DemoDto hello(@PathVariable String id,
                         @RequestParam(required = false) String status,
                         @RequestParam(required = false) String data) {
        IO.println(status);
        IO.println(data);
        return demoService.getById(id);
    }

    @GetMapping("/{id}/{nome}")
    public DemoDto hello2(@PathVariable String id, @PathVariable String nome) {
        return new DemoDto(id, nome);
    }

    @GetMapping
    public List<DemoDto> getList(){
        return demoService.getAll();
    }
}
