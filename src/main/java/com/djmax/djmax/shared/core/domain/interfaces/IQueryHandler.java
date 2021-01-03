package com.djmax.djmax.shared.core.domain.interfaces;

public interface IQueryHandler<T, P extends IQuery> {
    T execute(P command);
}
