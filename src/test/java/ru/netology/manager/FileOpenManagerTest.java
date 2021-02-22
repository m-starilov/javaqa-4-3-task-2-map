package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {

    private FileOpenManager manager = new FileOpenManager();
    private Map<String, String> map = new HashMap<>();

    @Nested
    public class Empty {

        @Test
        public void shouldAddNewApp() {
            manager.add(".html", "Google Chrome");
            Map<String, String> actual = manager.getAll();

            map.put(".html", "Google Chrome");
            Map<String, String> expected = map;

            assertEquals(expected, actual);
        }

        @Test
        public void shouldNotFindAppByExt() {
            String actual = manager.findAppByExt(".html");

            assertNull(actual);
        }

        @Test
        public void shouldNotDeleteExt() {
            String actual = manager.deleteExt(".html");

            assertNull(actual);
        }
    }

    @Nested
    public class SingleItem {

        @BeforeEach
        public void setUp() {
            manager.add(".html", "Google Chrome");
        }

        @Test
        public void shouldAddNewApp() {
            manager.add(".FB2", "FBReader");
            Map<String, String> actual = manager.getAll();

            map.put(".html", "Google Chrome");
            map.put(".fb2", "FBReader");
            Map<String, String> expected = map;

            assertEquals(expected, actual);
        }

        @Test
        public void shouldFindAppByExt() {
            String actual = manager.findAppByExt(".html");
            String expected = "Google Chrome";

            assertEquals(expected, actual);
        }

        @Test
        public void shouldDeleteExt() {
            String actual = manager.deleteExt(".html");
            String expected = "Google Chrome";

            assertEquals(expected, actual);

            Map<String, String> actualSet = manager.getAll();
            Map<String, String> expectedSet = map;

            assertEquals(expectedSet, actualSet);
        }
    }

    @Nested
    public class MultipleItems {

        @BeforeEach
        public void setUp() {
            manager.add(".HTML", "Firefox");
            manager.add(".7z", "WinRAR");
            manager.add(".gif", "Microsoft Photo Editor");
            manager.add(".pdf", "Adobe Reader");
            manager.add(".mp4", "VLC media player");
            manager.add(".FB2", "FBReader");
            manager.add(".xls", "Microsoft Excel");
        }

        @Test
        public void shouldAddNewApp() {
            manager.add(".mp3", "WinAmp");
            Map<String, String> actual = manager.getAll();

            map.put(".html", "Firefox");
            map.put(".7z", "WinRAR");
            map.put(".gif", "Microsoft Photo Editor");
            map.put(".pdf", "Adobe Reader");
            map.put(".mp4", "VLC media player");
            map.put(".fb2", "FBReader");
            map.put(".xls", "Microsoft Excel");
            map.put(".mp3", "WinAmp");
            Map<String, String> expected = map;

            assertEquals(expected, actual);
        }

        @Test
        public void shouldFindAppByExt() {
            String actual = manager.findAppByExt(".pdf");
            String expected = "Adobe Reader";

            assertEquals(expected, actual);
        }

        @Test
        public void shouldDeleteExt() {
            String actual = manager.deleteExt(".html");
            String expected = "Firefox";

            assertEquals(expected, actual);

            Map<String, String> actualSet = manager.getAll();
            
            map.put(".7z", "WinRAR");
            map.put(".gif", "Microsoft Photo Editor");
            map.put(".pdf", "Adobe Reader");
            map.put(".mp4", "VLC media player");
            map.put(".fb2", "FBReader");
            map.put(".xls", "Microsoft Excel");
            Map<String, String> expectedSet = map;
            
            assertEquals(expectedSet, actualSet);
        }

        @Test
        public void shouldGetAllSortedExt() {
            List<String> actual = manager.getAllSortedExt();
            List<String> expected = List.of(".7z", ".fb2", ".gif", ".html", ".mp4", ".pdf", ".xls");

            assertEquals(expected, actual);
        }

        @Test
        public void shouldGetAllSortedApp() {
            List<String> actual = manager.getAllSortedApp();
            List<String> expected = List.of("Adobe Reader", "FBReader", "Firefox", "Microsoft Excel","Microsoft Photo Editor", "VLC media player", "WinRAR");

            assertEquals(expected, actual);
        }
    }

}