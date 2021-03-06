/*
 * SonarQube Findbugs Plugin
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.findbugs;

import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleRepository;
import org.sonar.api.rules.XMLRuleParser;
import org.sonar.plugins.java.Java;

import java.util.List;

public final class FbContribRuleRepository extends RuleRepository {

  public static final String REPOSITORY_KEY = "fb-contrib";

  private XMLRuleParser xmlRuleParser;

  public FbContribRuleRepository(XMLRuleParser xmlRuleParser) {
    super(REPOSITORY_KEY, Java.KEY);
    setName("fb-contib");
    this.xmlRuleParser = xmlRuleParser;
  }

  @Override
  public List<Rule> createRules() {
    return xmlRuleParser.parse(getClass().getResourceAsStream("/org/sonar/plugins/findbugs/rules-fbcontrib.xml"));
  }
}
