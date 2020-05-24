package com.microservices.placeservice.repository.elastic;

import com.microservices.placeservice.entity.elastic.EsPlace;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticPlaceRepository extends ElasticsearchRepository<EsPlace,String> {
}
