package com.microservices.placeservice.service;

import com.microservices.placeservice.dto.PlaceDto;
import com.microservices.placeservice.entity.Place;
import com.microservices.placeservice.entity.elastic.EsPlace;
import com.microservices.placeservice.repository.PlaceRepository;
import com.microservices.placeservice.repository.elastic.ElasticPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    private final ModelMapper modelMapper;

    private final ElasticPlaceRepository elasticPlaceRepository;

    @Transactional
    @Override
    public PlaceDto save(PlaceDto placeDto) {

        Place place = modelMapper.map(placeDto,Place.class);

        EsPlace esPlace = EsPlace.builder()
                              .placeName(placeDto.getPlaceName())
                              .address(placeDto.getAddress())
                              .capacity(placeDto.getCapacity())
                              .build();



        elasticPlaceRepository.save(esPlace);

        placeRepository.save(place);

        return modelMapper.map(place,PlaceDto.class);
    }

    @Override
    @Transactional
    public PlaceDto update(String id, PlaceDto placeDto) {

        if (id == null)
             throw new IllegalArgumentException("Id cannot be null!");

        Optional<Place> place = placeRepository.findById(id);


        Place updatePlace =  place.map(p->{
             p.setAddress(placeDto.getAddress());
             p.setPhoneNumber(placeDto.getPhoneNumber());
             p.setCapacity(placeDto.getCapacity());
             p.setPlaceName(placeDto.getPlaceName());

             return p;

         }).orElseThrow(IllegalArgumentException::new);


        elasticPlaceRepository.save(modelMapper.map(updatePlace, EsPlace.class));

        return modelMapper.map(updatePlace, PlaceDto.class);
    }

    @Override
    public Boolean delete(String id) {

        if (id == null)
            throw new IllegalArgumentException("Id cannot be null!");

        placeRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        elasticPlaceRepository.deleteById(id);

        placeRepository.deleteById(id);

        return Boolean.TRUE;
    }

    @Override
    public PlaceDto findById(String id) {

        if (id == null)
            throw new IllegalArgumentException("Id cannot be null!");

        Optional<Place> place = placeRepository.findById(id);

        return modelMapper.map(place, PlaceDto.class);
    }

    @Override
    public List<PlaceDto> findAll() {

       List<Place> placeList = placeRepository.findAll();

       List<PlaceDto> placeDtoList = Arrays.asList(modelMapper.map(placeList, PlaceDto[].class));

        return placeDtoList;
    }
}
