package org.codehaus.plexus.util.interpolation;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import java.util.List;

/**
 * COPIED FROM plexus-utils-1.5.15 TO SATISFY TESTS
 *
 * @version $Id: RegexBasedInterpolator.java 12174 2010-05-16 21:04:35Z rfscholte $
 * @deprecated Use plexus-interpolation APIs instead.
 */
public class RegexBasedInterpolator
    extends org.codehaus.plexus.interpolation.RegexBasedInterpolator
    implements Interpolator
{
    public RegexBasedInterpolator()
    {
        super();
    }

    public RegexBasedInterpolator( List valueSources )
    {
        super( valueSources );
    }

    public RegexBasedInterpolator( String startRegex,
                                   String endRegex,
                                   List valueSources )
    {
        super( startRegex, endRegex, valueSources );
    }

    public RegexBasedInterpolator( String startRegex,
                                   String endRegex )
    {
        super( startRegex, endRegex );
    }

    public void addValueSource( ValueSource valueSource )
    {
        super.addValueSource( valueSource );
    }

    public void removeValuesSource( ValueSource valueSource )
    {
        super.removeValuesSource( valueSource );
    }
}
