import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarmestDataStructureTest {

    @Test
    void testBasicFlow() {
        WarmestDataStructureInterface ds = new WarmestDataStructure();

        assertNull(ds.getWarmest());

        assertNull(ds.put("a", 100));
        assertEquals("a", ds.getWarmest());

        assertEquals(100, ds.put("a", 101));
        assertEquals(101, ds.put("a", 101));
        assertEquals(101, ds.get("a"));
        assertEquals("a", ds.getWarmest());

        assertEquals(101, ds.remove("a"));
        assertNull(ds.remove("a"));
        assertNull(ds.getWarmest());
    }

    @Test
    void testMultipleKeys() {
        WarmestDataStructureInterface ds = new WarmestDataStructure();

        assertNull(ds.put("a", 100));
        assertNull(ds.put("b", 200));
        assertNull(ds.put("c", 300));
        assertEquals("c", ds.getWarmest());

        assertEquals(200, ds.remove("b"));
        assertEquals("c", ds.getWarmest());

        assertEquals(300, ds.remove("c"));
        assertEquals("a", ds.getWarmest());

        assertEquals(100, ds.remove("a"));
        assertNull(ds.getWarmest());

        assertNull(ds.remove("a"));
    }

    @Test
    void testGetUpdatesWarmest() {
        WarmestDataStructureInterface ds = new WarmestDataStructure();

        ds.put("a", 1);
        ds.put("b", 2);
        ds.put("c", 3);

        assertEquals("c", ds.getWarmest());
        assertEquals(2, ds.get("b"));
        assertEquals("b", ds.getWarmest());
    }

    @Test
    void testOverwriteValue() {
        WarmestDataStructureInterface ds = new WarmestDataStructure();

        assertNull(ds.put("x", 10));
        assertEquals(10, ds.put("x", 20));
        assertEquals(20, ds.get("x"));
        assertEquals("x", ds.getWarmest());
    }

    @Test
    void testRemoveNonExistent() {
        WarmestDataStructureInterface ds = new WarmestDataStructure();

        assertNull(ds.remove("ghost"));
        assertNull(ds.get("ghost"));

        ds.put("real", 5);
        assertEquals(5, ds.remove("real"));
        assertNull(ds.remove("real"));
    }
}
