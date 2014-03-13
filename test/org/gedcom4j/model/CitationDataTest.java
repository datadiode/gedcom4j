package org.gedcom4j.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test for {@link CitationData}
 * 
 * @author frizbog1
 * 
 */
public class CitationDataTest {

    /**
     * Test for .equals();
     */
    @Test
    public void testEquals() {
        CitationData c1 = new CitationData();
        CitationData c2 = new CitationData();
        assertNotSame(c1, c2);
        assertEquals(c1, c2);

        c1.customTags = null;
        assertFalse(c1.equals(c2));
        c1.customTags = new ArrayList<StringTree>();
        assertEquals(c1, c2);

        c1.entryDate = new StringWithCustomTags("Frying Pan");
        assertFalse(c1.equals(c2));
        c2.entryDate = new StringWithCustomTags("Frying Pan");
        assertEquals(c1, c2);

        c1.sourceText.add(new ArrayList<String>());
        assertFalse(c1.equals(c2));
        c2.sourceText.add(new ArrayList<String>());
        assertEquals(c1, c2);

    }

    /**
     * Test for .hashCode();
     */
    @Test
    public void testHashCode() {
        CitationData c1 = new CitationData();
        CitationData c2 = new CitationData();
        assertNotSame(c1.hashCode(), c2.hashCode());
        assertEquals(c1.hashCode(), c2.hashCode());

        c1.customTags = null;
        assertFalse(c1.hashCode() == c2.hashCode());
        c1.customTags = new ArrayList<StringTree>();
        assertEquals(c1.hashCode(), c2.hashCode());

        c1.entryDate = new StringWithCustomTags("Frying Pan");
        assertFalse(c1.hashCode() == c2.hashCode());
        c2.entryDate = new StringWithCustomTags("Frying Pan");
        assertEquals(c1.hashCode(), c2.hashCode());

        c1.sourceText.add(new ArrayList<String>());
        assertFalse(c1.hashCode() == c2.hashCode());
        c2.sourceText.add(new ArrayList<String>());
        assertEquals(c1.hashCode(), c2.hashCode());

    }

    /**
     * Test for .toString()
     */
    @Test
    public void testToString() {
        CitationData c1 = new CitationData();
        assertEquals("CitationData [sourceText=[], customTags=[]]", c1.toString());

        c1.customTags = null;
        c1.entryDate = new StringWithCustomTags("Frying Pan");
        c1.sourceText.add(new ArrayList<String>());

        assertEquals("CitationData [entryDate=Frying Pan, sourceText=[[]], ]", c1.toString());
    }

}
