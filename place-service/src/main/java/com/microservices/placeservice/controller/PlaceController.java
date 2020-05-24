package com.microservices.placeservice.controller;

import com.microservices.placeservice.dto.PlaceDto;
import com.microservices.placeservice.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {


    private final PlaceService placeService;

    @PostMapping
    public ResponseEntity<PlaceDto> save(@RequestBody PlaceDto placeDto){

        return ResponseEntity.ok(placeService.save(placeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceDto> update(@PathVariable String id, @RequestBody PlaceDto placeDto){

        return ResponseEntity.ok(placeService.update(id,placeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){

        return ResponseEntity.ok(placeService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDto> findById(@PathVariable  String id){

        return ResponseEntity.ok(placeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PlaceDto>> findAll(){

        return ResponseEntity.ok(placeService.findAll());
    }
}
