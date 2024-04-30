package com.ftninformatika.test.support;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public abstract class TwoWayConverter<Entity, Dto> implements GenericConverter {

    private Class<Entity> classOfEntity;
    private Class<Dto> classOfDto;

    protected TwoWayConverter() {
        Type typeA = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type typeB = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.classOfEntity = (Class) typeA;
        this.classOfDto = (Class) typeB;
    }

    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<ConvertiblePair>();
        convertiblePairs.add(new ConvertiblePair(classOfEntity, classOfDto));
        convertiblePairs.add(new ConvertiblePair(classOfDto, classOfEntity));
        return convertiblePairs;
    }

    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (classOfEntity.equals(sourceType.getType())) {
            return this.toDto((Entity) source);
        } else {
            return this.toEntity((Dto) source);
        }
    }

    public List<Dto> toDto(List<Entity> sources) {
        List<Dto> dtos = new ArrayList<>();
        sources.forEach(entity -> dtos.add(toDto(entity)));
        return dtos;
    }

    public List<Entity> toEntity(List<Dto> targets) {
        List<Entity> baseObjects = new ArrayList<>();
        targets.forEach(dto -> baseObjects.add(toEntity(dto)));
        return baseObjects;
    }

    public abstract Dto toDto(Entity source);

    public abstract Entity toEntity(Dto target);

}
