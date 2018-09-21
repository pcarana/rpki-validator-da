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

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import mx.nic.lab.rpki.db.exception.ApiDataAccessException;
import mx.nic.lab.rpki.db.pojo.RpkiObject;
import mx.nic.lab.rpki.db.pojo.RpkiRepository;
import net.ripe.rpki.commons.crypto.CertificateRepositoryObject;
import net.ripe.rpki.commons.crypto.cms.manifest.ManifestCms;
import net.ripe.rpki.commons.validation.ValidationResult;

/**
 * Interface for {@link RpkiObject} DAO functions
 *
 */
public interface RpkiObjectDAO extends DAO {

	/**
	 * Gets an {@link RpkiObject} by its ID
	 * 
	 * @param id
	 * @return The {@link RpkiObject} or null if not found
	 * @throws ApiDataAccessException
	 */
	public RpkiObject getById(Long id) throws ApiDataAccessException;

	/**
	 * Stores a Set of {@link RpkiObject}s
	 * 
	 * @param rpkiObjects
	 * @throws ApiDataAccessException
	 */
	public void bulkCreate(Set<RpkiObject> rpkiObjects) throws ApiDataAccessException;

	/**
	 * Find an {@link RpkiObject} and return the search result as an
	 * {@link Optional} object
	 * 
	 * @param rpkiObjectId
	 * @param clazz
	 * @param validationResult
	 * @return
	 * @throws ApiDataAccessException
	 */
	public <T extends CertificateRepositoryObject> Optional<T> findCertificateRepositoryObject(long rpkiObjectId,
			Class<T> clazz, ValidationResult validationResult) throws ApiDataAccessException;

	/**
	 * Find a {@link RpkiObject} by its SHA256 hash and return the search result as
	 * an {@link Optional} object
	 * 
	 * @param sha256
	 * @return
	 * @throws ApiDataAccessException
	 */
	public Optional<RpkiObject> findBySha256(byte[] sha256) throws ApiDataAccessException;

	/**
	 * Fetch all the {@link RpkiObject}s present in a {@link ManifestCms}
	 * 
	 * @param manifestCms
	 * @return
	 * @throws ApiDataAccessException
	 */
	public Map<String, RpkiObject> findObjectsInManifest(ManifestCms manifestCms) throws ApiDataAccessException;

	/**
	 * Fetch the newest {@link RpkiObject} filtered by its <code>type</code> and
	 * <code>authorityKeyIdentifier</code>, and return the search result as an
	 * {@link Optional} object
	 * 
	 * @param type
	 * @param authorityKeyIdentifier
	 * @return
	 * @throws ApiDataAccessException
	 */
	public Optional<RpkiObject> findLatestByTypeAndAuthorityKeyIdentifier(RpkiObject.Type type,
			byte[] authorityKeyIdentifier) throws ApiDataAccessException;

	/**
	 * Delete all the {@link RpkiObject}s that haven't been reached since
	 * <code>unreachableSince</code>
	 * 
	 * @param unreachableSince
	 * @return
	 * @throws ApiDataAccessException
	 */
	public long deleteUnreachableObjects(Instant unreachableSince) throws ApiDataAccessException;

	/**
	 * Add the relation between a {@link RpkiObject} and a {@link RpkiRepository}
	 * based on its ID
	 * 
	 * @param rpkiObject
	 * @param rpkiRepositoryId
	 * @return <code>boolean</code> to indicate if the operation was successful
	 * @throws ApiDataAccessException
	 */
	public boolean addRpkiRepository(RpkiObject rpkiObject, Long rpkiRepositoryId) throws ApiDataAccessException;
}
