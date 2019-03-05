package com.bnau.cdb.util.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.bnau.cdb.util.MapperUtil;

/**
 * Mapper implementation using Dozer.
 *
 * @author bertrand
 *
 */
@Component
public class DozerMapperUtil implements MapperUtil {
	
	private static final Mapper MAPPER = new DozerBeanMapper();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S, D> D map(final S source, final Class<D> destClass) {
		return MAPPER.map(source, destClass);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S, D> Page<D> map(final Page<S> source, final Class<D> destClass) {
		return source.map(s -> MAPPER.map(s, destClass));
	}
	
}
