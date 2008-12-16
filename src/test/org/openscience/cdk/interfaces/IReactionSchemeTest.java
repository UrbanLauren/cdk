/* $RCSfile$
 * 
 * $Author: egonw $    
 * $Date: 2006-08-01 21:13:42 +0200 (Tue, 01 Aug 2006) $    
 * $Revision: 6718 $
 * 
 *  Copyright (C) 2007  Miguel Rojasch <miguelrojasch@users.sf.net>
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA. 
 * 
 */
package org.openscience.cdk.interfaces;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Checks the functionality of {@link IReactionScheme} implementations.
 *
 * @cdk.module test-interfaces
 */
public class IReactionSchemeTest extends IReactionSetTest {

    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testGetReactionSchemeCount() {
    	IReactionScheme scheme = getBuilder().newReactionScheme();
    	scheme.add(getBuilder().newReactionScheme());
        Assert.assertEquals(1, scheme.getReactionSchemeCount());
    }
    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testGetReactionCount() {
    	IReactionScheme scheme = getBuilder().newReactionScheme();
    	scheme.addReaction(getBuilder().newReaction());
    	scheme.addReaction(getBuilder().newReaction());
        Assert.assertEquals(2, scheme.getReactionCount());
    }
    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testReactionSchemes() {
        IReactionScheme scheme = getBuilder().newReactionScheme();
        scheme.add(getBuilder().newReactionScheme());
        scheme.add(getBuilder().newReactionScheme());
        scheme.add(getBuilder().newReactionScheme());

        Assert.assertEquals(3, scheme.getReactionSchemeCount());
        int count = 0;
        for(IReactionScheme sch: scheme.reactionSchemes()) {
        	sch.getClass();
        	++count;
        }
        Assert.assertEquals(3, count);
    }
    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testReactions() {
        IReactionScheme scheme = getBuilder().newReactionScheme();
        scheme.addReaction(getBuilder().newReaction());
        scheme.addReaction(getBuilder().newReaction());
        scheme.addReaction(getBuilder().newReaction());

        Assert.assertEquals(3, scheme.getReactionCount());
        int count = 0;
        for(Iterator<IReaction> it = scheme.reactions().iterator(); it.hasNext();) {
        	it.next();
        	++count;
        }
        Assert.assertEquals(3, count);
    }
    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testAdd_IReactionScheme() {
    	IReactionScheme scheme = getBuilder().newReactionScheme();
        scheme.add(getBuilder().newReactionScheme());
        scheme.add(getBuilder().newReactionScheme());
        scheme.add(getBuilder().newReactionScheme());

        IReactionScheme tested = getBuilder().newReactionScheme();
        Assert.assertEquals(0, tested.getReactionSchemeCount());
        tested.add(scheme);
        Assert.assertEquals(1, tested.getReactionSchemeCount());
    }

    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testAdd_IReaction() {
    	IReactionScheme scheme = getBuilder().newReactionScheme();
    	scheme.add(getBuilder().newReactionScheme());
        scheme.add(getBuilder().newReactionScheme());
        scheme.add(getBuilder().newReactionScheme());

        IReactionScheme tested = getBuilder().newReactionScheme();
        Assert.assertEquals(0, tested.getReactionSchemeCount());
        tested.add(scheme);
        Assert.assertEquals(1, tested.getReactionSchemeCount());
        Assert.assertEquals(0, tested.getReactionCount());
    }
    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testClone() throws Exception {
    	IReactionScheme scheme = getBuilder().newReactionScheme();
        Object clone = scheme.clone();
        Assert.assertTrue(clone instanceof IReactionScheme);
        Assert.assertNotSame(scheme, clone);
    } 
    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testRemoveReactionScheme_IReactionScheme() {
        IReactionScheme scheme = getBuilder().newReactionScheme();
        IReactionScheme scheme1 = getBuilder().newReactionScheme();
        IReactionScheme scheme2 = getBuilder().newReactionScheme();
        scheme.add(scheme1);
        scheme.add(scheme2);
        scheme.removeReactionScheme(scheme1);
        Assert.assertEquals(1, scheme.getReactionSchemeCount());
    }
    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testRemoveAllReactionSchemes() {
    	 IReactionScheme scheme = getBuilder().newReactionScheme();
         IReactionScheme scheme1 = getBuilder().newReactionScheme();
         IReactionScheme scheme2 = getBuilder().newReactionScheme();
         scheme.add(scheme1);
         scheme.add(scheme2);
         
        Assert.assertEquals(2, scheme.getReactionSchemeCount());
        scheme.removeAllReactionSchemes();
        Assert.assertEquals(0, scheme.getReactionSchemeCount());
    }
}
