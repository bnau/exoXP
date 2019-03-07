package com.bnau.cdb.util;

import org.springframework.data.domain.Page;

/**
 * Utility class for mapping between DTOs and entities.
 *
 * @author bertrand
 *
 */
public interface MapperUtil {
	
	/**
	 * Map objects.
	 *
	 * @param source    Source object
	 * @param destClass Class of destination
	 * @return Mapped object
	 */
	public <S, D> D map(S source, Class<D> destClass);
	
	/**
	 * Map page of objects.
	 *
	 * @param source    Source page
	 * @param destClass Class of destination
	 * @return Mapped page
	 */
	public <S, D> Page<D> map(Page<S> source, Class<D> destClass);
}
