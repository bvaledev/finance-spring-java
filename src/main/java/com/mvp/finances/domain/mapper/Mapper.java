package com.mvp.finances.domain.mapper;

public interface Mapper<F,T> {
    T map(F t);
}
