/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.services.document.impl.diff;

import org.exoplatform.services.document.diff.DeleteDelta;
import org.exoplatform.services.document.diff.RevisionVisitor;

import java.util.List;

/**
 * Holds a delete-delta between to revisions of a text.
 * 
 * @version $Id: DeleteDeltaImpl.java 5799 2006-05-28 17:55:42Z geaz $
 * @author <a href="mailto:juanco@suigeneris.org">Juanco Anez</a>
 * @see DeltaImpl
 * @see DiffServiceImpl
 * @see ChunkImpl
 */
public class DeleteDeltaImpl extends DeltaImpl implements DeleteDelta
{

   DeleteDeltaImpl()
   {
      super();
   }

   public DeleteDeltaImpl(ChunkImpl orig)
   {
      init(orig, null);
   }

   public void verify(List target) throws Exception
   {
      if (!original.verify(target))
      {
         throw new IllegalStateException("target isn't correct");
      }
   }

   public void applyTo(List target)
   {
      original.applyDelete(target);
   }

   public void toString(StringBuffer s)
   {
      s.append(original.rangeString());
      s.append("d");
      s.append(revised.rcsto());
      s.append(DiffServiceImpl.NL);
      original.toString(s, "< ", DiffServiceImpl.NL);
   }

   public void toRCSString(StringBuffer s, String EOL)
   {
      s.append("d");
      s.append(original.rcsfrom());
      s.append(" ");
      s.append(original.size());
      s.append(EOL);
   }

   public void accept(RevisionVisitor visitor)
   {
      visitor.visit(this);
   }
}
