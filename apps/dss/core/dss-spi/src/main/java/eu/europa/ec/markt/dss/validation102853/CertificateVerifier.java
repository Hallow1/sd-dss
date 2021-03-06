/*
 * DSS - Digital Signature Services
 *
 * Copyright (C) 2013 European Commission, Directorate-General Internal Market and Services (DG MARKT), B-1049 Bruxelles/Brussel
 *
 * Developed by: 2013 ARHS Developments S.A. (rue Nicolas Bové 2B, L-1253 Luxembourg) http://www.arhs-developments.com
 *
 * This file is part of the "DSS - Digital Signature Services" project.
 *
 * "DSS - Digital Signature Services" is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * DSS is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * "DSS - Digital Signature Services".  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.europa.ec.markt.dss.validation102853;

import java.io.Serializable;

import eu.europa.ec.markt.dss.validation102853.crl.CRLSource;
import eu.europa.ec.markt.dss.validation102853.crl.ListCRLSource;
import eu.europa.ec.markt.dss.validation102853.loader.DataLoader;
import eu.europa.ec.markt.dss.validation102853.ocsp.ListOCSPSource;
import eu.europa.ec.markt.dss.validation102853.ocsp.OCSPSource;

/**
 * Provides information on the sources to be used in the validation process in the context of a signature.
 *
 * @version $Revision: 946 $ - $Date: 2011-06-06 17:15:14 +0200 (Mon, 06 Jun 2011) $
 */

public interface CertificateVerifier extends Serializable {

	/**
	 * Returns the OCSP source associated with this verifier.
	 *
	 * @return
	 */
	public OCSPSource getOcspSource();

	/**
	 * Returns the CRL source associated with this verifier.
	 *
	 * @return
	 */
	public CRLSource getCrlSource();

	/**
	 * Defines the source of CRL used by this class
	 *
	 * @param crlSource the crlSource to set
	 */
	public void setCrlSource(final CRLSource crlSource);

	/**
	 * Defines the source of OCSP used by this class
	 *
	 * @param ocspSource the ocspSource to set
	 */
	public void setOcspSource(final OCSPSource ocspSource);

	CertificatePool getValidationPool();

	void setValidationPool(CertificatePool validationPool);

	/**
	 * Returns the trusted certificates source associated with this verifier. This source is used to identify the trusted anchor.
	 *
	 * @return
	 */
	public TrustedCertificateSource getTrustedCertSource();

	/**
	 * Sets the trusted certificates source.
	 *
	 * @param certSource The certificates source to set
	 */
	public void setTrustedCertSource(final TrustedCertificateSource certSource);

	/**
	 * Returns the adjunct certificates source associated with this verifier.
	 *
	 * @return
	 */
	public CertificateSource getAdjunctCertSource();

	/**
	 * Associates an adjunct certificates source to this verifier.
	 *
	 * @param adjunctCertSource
	 */
	public void setAdjunctCertSource(final CertificateSource adjunctCertSource);

	/**
	 * The data loader used to access AIA certificate source.
	 *
	 * @return
	 */
	public DataLoader getDataLoader();

	/**
	 * The data loader used to access AIA certificate source. If this property is not set the default {@code CommonsHttpDataLoader} is created.
	 *
	 * @param dataLoader
	 */
	public void setDataLoader(final DataLoader dataLoader);

	/**
	 * This method returns the CRL source (information extracted from signatures).
	 */
	public ListCRLSource getSignatureCRLSource();

	/**
	 * This method allows to set the CRL source (information extracted from signatures).
	 *
	 * @param signatureCRLSource
	 */
	public void setSignatureCRLSource(final ListCRLSource signatureCRLSource);

	/**
	 * This method returns the OCSP source (information extracted from signatures).
	 */
	public ListOCSPSource getSignatureOCSPSource();

	/**
	 * This method allows to set the OCSP source (information extracted from signatures).
	 *
	 * @param signatureOCSPSource
	 */
	public void setSignatureOCSPSource(final ListOCSPSource signatureOCSPSource);


	/**
	 * This method creates the validation pool of certificates which is used during the validation process. It contains the certificates that compose the trusted and the adjunct
	 * certificate source.
	 */
	public CertificatePool createValidationPool();
}