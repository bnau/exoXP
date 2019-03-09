package com.bnau.cdb.util.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
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
	
	private static final DozerBeanMapper MAPPER = new DozerBeanMapper();
	
	static {
		MAPPER.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));
	}
	
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S, D> List<D> map(final List<S> source, final Class<D> destClass) {
		return source.stream().map(s -> MAPPER.map(s, destClass)).collect(Collectors.toList());
	}
	
}
