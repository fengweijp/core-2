/*
 * Copyright (C) 2010 eXo Platform SAS.
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
package org.exoplatform.services.organization;

import java.util.List;

/**
 * Provides the ability to get the list of {@link MembershipTypeEventListener}
 *
 * @author <a href="abazko@exoplatform.com">Anatoliy Bazko</a>
 * @LevelAPI Platform
 */
public interface MembershipTypeEventListenerHandler
{

   /**
    * Return list of MembershipTypeEventListener. List should be unmodifiable 
    * to prevent modification outside of MembershipTypeHandler.
    * 
    * @return list of MembershipTypeEventListener
    */
   public List<MembershipTypeEventListener> getMembershipTypeListeners();
}