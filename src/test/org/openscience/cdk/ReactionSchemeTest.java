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
package org.openscience.cdk;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openscience.cdk.interfaces.IReactionScheme;
import org.openscience.cdk.interfaces.IReactionSetTest;

/**
 * Checks the functionality of the MolecularFormulaSet class.
 *
 * @cdk.module test-data
 *
 * @see ReactionScheme
 */
public class ReactionSchemeTest extends IReactionSetTest {

    @BeforeClass public static void setUp() {
        setBuilder(DefaultChemObjectBuilder.getInstance());
    }

    /**
	 * A unit test suite for JUnit.
	 *
	 * @return    The test suite
	 */
    @Test 
    public void testReactionScheme() {
        IReactionScheme scheme = new ReactionScheme();
        Assert.assertNotNull(scheme);
    }
    
}
