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

import java.util.Optional;
import java.util.stream.Stream;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.RpkiRepository;

/**
 * Interface for {@link RpkiRepository} DAO functions
 *
 */
public interface RpkiRepositoryDAO extends DAO {

	/**
	 * Stores an {@link RpkiRepository} and returns its created ID
	 * 
	 * @param rpkiRepository
	 * @return The ID of the {@link RpkiRepository} newly created
	 * @throws ApiDataAccessException
	 */
	public Long create(RpkiRepository rpkiRepository) throws ApiDataAccessException;

	/**
	 * Find a {@link RpkiRepository} by its URI and return the search result as an
	 * {@link Optional} object
	 * 
	 * @param uri
	 * @return
	 * @throws ApiDataAccessException
	 */
	public Optional<RpkiRepository> findByURI(String uri) throws ApiDataAccessException;

	/**
	 * Get all the {@link RpkiRepository}s and return the search result as a
	 * {@link Stream}
	 * 
	 * @return
	 * @throws ApiDataAccessException
	 */
	public Stream<RpkiRepository> findRsyncRepositories() throws ApiDataAccessException;

	/**
	 * Updates the parentRepository of a {@link RpkiRepository}
	 * 
	 * @param rpkiRepository
	 * @return <code>boolean</code> indicating success or failure
	 * @throws ApiDataAccessException
	 */
	public boolean updateParentRepository(RpkiRepository rpkiRepository) throws ApiDataAccessException;
}
