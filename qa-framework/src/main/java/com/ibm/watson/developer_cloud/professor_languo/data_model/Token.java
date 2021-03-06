/*
 * Copyright IBM Corp. 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.professor_languo.data_model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is intended to store the attributes of tokens like lemmas, pos, etc.,.
 *
 */
public class Token {
  private final String originalText;
  private String POS;
  private String lemma;
  private Map<String, Double> tokenWeight;

  public Token(String originalText) {
    this.originalText = originalText;
  }

  public Token(String originalText, String pos, String lemma) {
    this(originalText);
    setPOS(pos);
    setLemma(lemma);
  }

  public String getPOS() {
    return POS;
  }

  public void setPOS(String pOS) {
    POS = pOS;
  }

  public String getLemma() {
    if (lemma != null)
      return lemma;
    else
      return originalText;
  }

  public void setLemma(String lemma) {
    this.lemma = lemma;
  }

  public String getOriginalText() {
    return originalText;
  }

  public void setTokenWeight(String key, double weight) {
    if (this.tokenWeight == null) {
      this.tokenWeight = new HashMap<String, Double>();
    }

    if (key != null) {
      this.tokenWeight.put(key, weight);
    }
  }

  public Double getTokenWeight(String key) {
    if (this.tokenWeight == null || key == null) {
      return null;
    }

    return this.tokenWeight.get(key);
  }

  @Override public String toString() {
    return this.getOriginalText() + '[' + this.getPOS() + ':' + this.getLemma() + ']';
  }

}
