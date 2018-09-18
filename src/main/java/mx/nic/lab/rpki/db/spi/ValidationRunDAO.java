/**
 * The BSD License
 *
 * Copyright (c) 2010-2018 RIPE NCC
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *   - Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *   - Neither the name of the RIPE NCC nor the names of its contributors may be
 *     used to endorse or promote products derived from this software without
 *     specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package mx.nic.lab.rpki.db.spi;

import java.util.List;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.ValidationRun;

/**
 * Interface for {@link ValidationRun} DAO functions
 *
 */
public interface ValidationRunDAO extends DAO {

	/**
	 * Stores a {@link ValidationRun} and returns its created ID
	 * 
	 * @param validationRun
	 * @return The ID of the {@link ValidationRun} newly created
	 * @throws ApiDataAccessException
	 */
	public Long create(ValidationRun validationRun) throws ApiDataAccessException;

	/**
	 * Updates a {@link ValidationRun} when this has finished execution, return a
	 * <code>boolean</code> to indicate success
	 * 
	 * @param validationRun
	 * @return <code>boolean</code> to indicate success
	 * @throws ApiDataAccessException
	 */
	public boolean completeValidation(ValidationRun validationRun) throws ApiDataAccessException;

	/**
	 * Gets a {@link ValidationRun} by its ID
	 * 
	 * @param id
	 * @return The {@link ValidationRun} found or null otherwise
	 * @throws ApiDataAccessException
	 */
	public ValidationRun get(long id) throws ApiDataAccessException;

	/**
	 * Get all the {@link ValidationRun}s
	 * 
	 * @return {@link List} of {@link ValidationRun}s of empty list if none is found
	 * @throws ApiDataAccessException
	 */
	public List<ValidationRun> findAll() throws ApiDataAccessException;
}
