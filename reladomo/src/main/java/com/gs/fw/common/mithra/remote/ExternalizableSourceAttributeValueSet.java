/*
 Copyright 2016 Goldman Sachs.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package com.gs.fw.common.mithra.remote;

import com.gs.collections.impl.set.mutable.UnifiedSet;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.util.Set;
import java.util.Iterator;



public class ExternalizableSourceAttributeValueSet implements Externalizable
{

    private Set sourceAttributeValueSet;

    public ExternalizableSourceAttributeValueSet()
    {
        // for externalizable
    }

    public ExternalizableSourceAttributeValueSet(Set sourceAttributeValueSet)
    {
        this.sourceAttributeValueSet = sourceAttributeValueSet;
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        int size = in.readInt();
        this.sourceAttributeValueSet = new UnifiedSet(size);
        for(int i = 0 ; i < size; i ++)
        {
            sourceAttributeValueSet.add(in.readObject());
        }
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        int size = sourceAttributeValueSet.size();
        out.writeInt(size);

        for(Iterator it = sourceAttributeValueSet.iterator(); it.hasNext(); )
        {
            out.writeObject(it.next());
        }
    }

    public Set getSourceAttributeValueSet()
    {
        return sourceAttributeValueSet;
    }

}