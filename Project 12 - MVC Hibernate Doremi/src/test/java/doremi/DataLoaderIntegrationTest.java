package doremi;

import doremi.domain.Album;
import doremi.domain.Band;
import doremi.domain.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class DataLoaderIntegrationTest {

    @Autowired
    private DataLoader dataLoader;

    @Test
    public void testTheStrokes() {
        Band b = dataLoader.getTheStrokes();
        assertEquals("The Strokes", b.getName());
        assertTrue(b.getActive());
        assertEquals(2, b.getAlbums().size());
    }

    @Test
    public void testJoyDivision() {
        Band b = dataLoader.getJoyDivision();
        assertEquals("Joy Division", b.getName());
        assertFalse(b.getActive());
        assertEquals(2, b.getAlbums().size());
    }

    @Test
    public void testLanaDelRey() {
        Band b = dataLoader.getLanaDelRey();
        assertEquals("Lana Del Rey", b.getName());
        assertTrue(b.getActive());
        assertEquals(3, b.getAlbums().size());
    }

    @Test
    public void testPixies() {
        Band b = dataLoader.getPixies();
        assertEquals("Pixies", b.getName());
        assertTrue(b.getActive());
        assertEquals(4, b.getAlbums().size());
    }

    @Test
    public void testPublicEnemy() {
        Band b = dataLoader.getPublicEnemy();
        assertEquals("Public Enemy", b.getName());
        assertTrue(b.getActive());
        assertEquals(1, b.getAlbums().size());
    }

    @Test
    public void testB1() {
        Album a = dataLoader.getAlbum1();
        assertEquals("Is This It", a.getTitle());
        assertEquals(Genre.INDIE, a.getGenre());
        assertEquals(2001, a.getYear());
        assertEquals("The Strokes", a.getBand().getName());
    }

    @Test
    public void testB2() {
        Album a = dataLoader.getAlbum2();
        assertEquals("Room on Fire", a.getTitle());
        assertEquals(Genre.INDIE, a.getGenre());
        assertEquals(2003, a.getYear());
        assertEquals("The Strokes", a.getBand().getName());
    }

    @Test
    public void testB3() {
        Album a = dataLoader.getAlbum3();
        assertEquals("Unknown Pleasures", a.getTitle());
        assertEquals(Genre.ROCK, a.getGenre());
        assertEquals(1979, a.getYear());
        assertEquals("Joy Division", a.getBand().getName());
    }

    @Test
    public void testB4() {
        Album a = dataLoader.getAlbum4();
        assertEquals("Closer", a.getTitle());
        assertEquals(Genre.ROCK, a.getGenre());
        assertEquals(1980, a.getYear());
        assertEquals("Joy Division", a.getBand().getName());
    }

    @Test
    public void testB5() {
        Album a = dataLoader.getAlbum5();
        assertEquals("Born to Die", a.getTitle());
        assertEquals(Genre.POP, a.getGenre());
        assertEquals(2012, a.getYear());
        assertEquals("Lana Del Rey", a.getBand().getName());
    }

    @Test
    public void testB6() {
        Album a = dataLoader.getAlbum6();
        assertEquals("Chemtrails over the Country Club", a.getTitle());
        assertEquals(Genre.FOLK, a.getGenre());
        assertEquals(2021, a.getYear());
        assertEquals("Lana Del Rey", a.getBand().getName());
    }

    @Test
    public void testB7() {
        Album a = dataLoader.getAlbum7();
        assertEquals("Norman Fucking Rockwell", a.getTitle());
        assertEquals(Genre.INDIE, a.getGenre());
        assertEquals(2019, a.getYear());
        assertEquals("Lana Del Rey", a.getBand().getName());
    }

    @Test
    public void testB8() {
        Album a = dataLoader.getAlbum8();
        assertEquals("Surfer Rosa", a.getTitle());
        assertEquals(Genre.INDIE, a.getGenre());
        assertEquals(1988, a.getYear());
        assertEquals("Pixies", a.getBand().getName());
    }

    @Test
    public void testB9() {
        Album a = dataLoader.getAlbum9();
        assertEquals("Doolittle", a.getTitle());
        assertEquals(Genre.INDIE, a.getGenre());
        assertEquals(1989, a.getYear());
        assertEquals("Pixies", a.getBand().getName());
    }

    @Test
    public void testB10() {
        Album a = dataLoader.getAlbum10();
        assertEquals("Beneath the Eyrie", a.getTitle());
        assertEquals(Genre.INDIE, a.getGenre());
        assertEquals(2019, a.getYear());
        assertEquals("Pixies", a.getBand().getName());
    }

    @Test
    public void testB11() {
        Album a = dataLoader.getAlbum11();
        assertEquals("Bossanova", a.getTitle());
        assertEquals(Genre.INDIE, a.getGenre());
        assertEquals(1990, a.getYear());
        assertEquals("Pixies", a.getBand().getName());
    }

    @Test
    public void testB12() {
        Album a = dataLoader.getAlbum12();
        assertEquals("It Takes a Nation of Millions to Hold Us Back", a.getTitle());
        assertEquals(Genre.RAP, a.getGenre());
        assertEquals(1988, a.getYear());
        assertEquals("Public Enemy", a.getBand().getName());
    }

}