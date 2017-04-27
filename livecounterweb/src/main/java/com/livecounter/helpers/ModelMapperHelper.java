package com.livecounter.helpers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperHelper {
    private static ModelMapper modelMapper;

    @Autowired
    public ModelMapperHelper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
     public static <D, S> D convertToDto(Class<D> clazz, S source) {
        D dto = modelMapper.map(source, clazz);
        return dto;
     }

}
