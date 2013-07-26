/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 *        or more contributor license agreements.  See the NOTICE file
 *        distributed with this work for additional information
 *        regarding copyright ownership.  The ASF licenses this file
 *        to you under the Apache License, Version 2.0 (the
 *        "License"); you may not use this file except in compliance
 *        with the License.  You may obtain a copy of the License at
 * 
 *          http://www.apache.org/licenses/LICENSE-2.0
 * 
 *        Unless required by applicable law or agreed to in writing,
 *        software distributed under the License is distributed on an
 *        "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *        KIND, either express or implied.  See the License for the
 *        specific language governing permissions and limitations
 *        under the License.
 ******************************************************************************/
package org.apache.olingo.odata2.processor.api.jpa.factory;

import org.apache.olingo.odata2.processor.api.jpa.ODataJPAContext;
import org.apache.olingo.odata2.processor.api.jpa.access.JPAEdmMappingModelAccess;
import org.apache.olingo.odata2.processor.api.jpa.access.JPAProcessor;
import org.apache.olingo.odata2.processor.api.jpa.model.JPAEdmModelView;

/**
 * Factory interface for creating
 * <ol>
 * <li>JPA EDM Model view</li>
 * <li>JPA Processor</li>
 * </ol>
 * 
 * @author SAP AG
 * 
 */
public interface JPAAccessFactory {
  /**
   * The method returns an instance of JPA EDM model view based on OData JPA
   * Context. The JPA EDM model view thus returned can be used for building
   * EDM models from Java persistence models.
   * 
   * @param oDataJPAContext
   *            a non null instance of
   *            {@link org.apache.olingo.odata2.processor.api.jpa.ODataJPAContext}
   * @return an instance of type
   *         {@link org.apache.olingo.odata2.processor.api.jpa.model.JPAEdmModelView}
   */
  public JPAEdmModelView getJPAEdmModelView(ODataJPAContext oDataJPAContext);

  /**
   * The method returns an instance of JPA processor based on OData JPA
   * Context. The JPA Processor thus returned can be used for building and
   * processing JPQL statements.
   * 
   * @param oDataJPAContext
   *            a non null instance of
   *            {@link org.apache.olingo.odata2.processor.api.jpa.ODataJPAContext}
   * @return an instance of type
   *         {@link org.apache.olingo.odata2.processor.api.jpa.access.JPAProcessor}
   */
  public JPAProcessor getJPAProcessor(ODataJPAContext oDataJPAContext);

  /**
   * The method returns an instance of JPA EDM mapping model access based on
   * OData JPA context. The instance thus returned can be used for accessing
   * the mapping details maintained for an OData service
   * 
   * @param oDataJPAContext
   *            a non null instance of
   *            {@link org.apache.olingo.odata2.processor.api.jpa.ODataJPAContext}
   * @return an instance of type
   *         {@link org.apache.olingo.odata2.processor.api.jpa.access.JPAEdmMappingModelAccess}
   */
  public JPAEdmMappingModelAccess getJPAEdmMappingModelAccess(
      ODataJPAContext oDataJPAContext);
}
