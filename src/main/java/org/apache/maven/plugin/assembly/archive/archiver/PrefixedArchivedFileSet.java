package org.apache.maven.plugin.assembly.archive.archiver;

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

import static org.apache.maven.plugin.assembly.archive.archiver.PrefixedFileSet.combineSelectors;

import org.codehaus.plexus.archiver.ArchivedFileSet;
import org.codehaus.plexus.components.io.fileselectors.FileSelector;

import java.io.File;

/**
 * @version $Id$
 */
public class PrefixedArchivedFileSet
    implements ArchivedFileSet
{

    private final String rootPrefix;
    private final ArchivedFileSet fileSet;
    private final FileSelector[] selectors;

    public PrefixedArchivedFileSet( ArchivedFileSet fileSet, String rootPrefix, FileSelector[] selectors )
    {
        this.fileSet = fileSet;
        this.selectors = selectors;

        if ( rootPrefix.length() > 0 && ! rootPrefix.endsWith( "/" ) )
        {
            this.rootPrefix = rootPrefix + "/";
        }
        else
        {
            this.rootPrefix = rootPrefix;
        }
    }

    public File getArchive()
    {
        return fileSet.getArchive();
    }

    public String[] getExcludes()
    {
        return fileSet.getExcludes();
    }

    public FileSelector[] getFileSelectors()
    {
        return combineSelectors(fileSet.getFileSelectors(), selectors);
    }

    public String[] getIncludes()
    {
        return fileSet.getIncludes();
    }

    public String getPrefix()
    {
        String prefix = fileSet.getPrefix();
        if ( prefix.startsWith( "/" ) )
        {
            if ( prefix.length() > 1 )
            {
                prefix = prefix.substring( 1 );
            }
            else
            {
                prefix = "";
            }
        }

        return rootPrefix + prefix;
    }

    public boolean isCaseSensitive()
    {
        return fileSet.isCaseSensitive();
    }

    public boolean isIncludingEmptyDirectories()
    {
        return fileSet.isIncludingEmptyDirectories();
    }

    public boolean isUsingDefaultExcludes()
    {
        return fileSet.isUsingDefaultExcludes();
    }

}