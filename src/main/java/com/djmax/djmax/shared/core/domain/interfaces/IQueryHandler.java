package com.djmax.djmax.shared.core.domain.interfaces;

public interface IQueryHandler<T> {
    T execute(IQuery command);
}
