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
package org.apache.olingo.odata2.core.uri.expression;

import org.apache.olingo.odata2.api.edm.EdmType;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.uri.expression.CommonExpression;
import org.apache.olingo.odata2.api.uri.expression.ExceptionVisitExpression;
import org.apache.olingo.odata2.api.uri.expression.ExpressionKind;
import org.apache.olingo.odata2.api.uri.expression.ExpressionVisitor;
import org.apache.olingo.odata2.api.uri.expression.FilterExpression;

/**
 * @author SAP AG
 */
public class FilterExpressionImpl implements FilterExpression {
  private final String filterString;
  private EdmType edmType;
  private CommonExpression commonExpression;

  public FilterExpressionImpl(final String filterExpression) {
    filterString = filterExpression;
  }

  public FilterExpressionImpl(final String filterExpression, final CommonExpression childExpression) {
    filterString = filterExpression;
    commonExpression = childExpression;
  }

  @Override
  public String getExpressionString() {
    return filterString;
  }

  @Override
  public CommonExpression getExpression() {
    return commonExpression;
  }

  @Override
  public Object accept(final ExpressionVisitor visitor) throws ExceptionVisitExpression, ODataApplicationException {
    Object retCommonExpression = commonExpression.accept(visitor);

    return visitor.visitFilterExpression(this, filterString, retCommonExpression);
  }

  @Override
  public CommonExpression setEdmType(final EdmType edmType) {
    this.edmType = edmType;
    return this;
  }

  @Override
  public EdmType getEdmType() {
    return edmType;
  }

  @Override
  public ExpressionKind getKind() {
    return ExpressionKind.FILTER;
  }

  @Override
  public String getUriLiteral() {
    return getExpressionString();
  }

}
